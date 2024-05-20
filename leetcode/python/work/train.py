### LASSO回归模型训练-蛋白组年龄预测 ###


import sys
import pandas as pd
import numpy as np
import pickle
import os
import seaborn as sns
import matplotlib.pyplot as plt
import multiprocessing as mp
from scipy import stats
from sklearn.model_selection import train_test_split
from sklearn.linear_model import Lasso
from sklearn.model_selection import GridSearchCV
from sklearn import utils
import matplotlib.patches as mpatches

plt.rcParams['font.family'] = 'Arial'


def LassoTrain(i, npx, label, train_cohort, organ, cell_type):
    reg = Lasso(max_iter=10000)
    param_grid = {'alpha': np.array(range(1, 1000, 1)) / 1000}
    grid_search = GridSearchCV(reg, param_grid, cv=5, scoring='r2', n_jobs=1)
    gs = grid_search.fit(npx, label)

    params = gs.param_grid['alpha']
    scores = gs.cv_results_['mean_test_score']
    # print(scores)
    # select alpha with performance of 0.95
    scale_score = scores / np.max(scores)
    selected_idx = np.where(scale_score >= 0.95)[0][-1]
    alpha = params[selected_idx]
    # print(alpha)

    # retrain
    lasso_model = Lasso(alpha=alpha, max_iter=10000)
    lasso_model.fit(npx, label)

    # 指定模型保存的路径
    save_dir = f"./scAge_models/{train_cohort}/{organ}/{cell_type}/"
    # os.makedirs(save_dir, exist_ok=True)

    # 指定模型保存的文件名
    save_fname = f"lasso_bs{i}_aging_model.pkl"
    append_fname = "lasso_model.coefs"
    savefp = os.path.join(save_dir, save_fname)
    appendfp = os.path.join(save_dir, append_fname)

    # 追加模型信息
    coef = lasso_model.coef_
    # print(coef)
    with open(appendfp, 'a') as F:
        F.write(str(i) + '\t' + '\t'.join(coef.astype(str)) + '\t' + str(alpha) + '\n')

    # 将模型保存到文件中
    with open(savefp, 'wb') as f:
        pickle.dump(lasso_model, f)

    return lasso_model


def parallel_LassoTrain(input_list):
    i, re_npx, re_label, train_cohort, organ, cell_type = input_list
    print(f"第{i}次Bootstrap采样\n")
    return LassoTrain(i, re_npx, re_label, train_cohort, organ, cell_type)


def BootStrap(samples, npx, label, train_cohort, organ, cell_type, n_bootstrap):
    # 创建进程池
    pool = mp.Pool(2)

    # 构造和并行训练对应的输入列表
    input_list = []
    for i in range(n_bootstrap):
        resamples = utils.resample(samples)
        re_npx = npx.loc[resamples]
        re_label = label.loc[resamples]
        input_list.append((i, re_npx, re_label, train_cohort, organ, cell_type))

    # 使用异步并行
    results = [pool.apply_async(parallel_LassoTrain, args=(input_arg,)) for input_arg in input_list]
    models = [res.get() for res in results]

    # 关闭进程池，确保所有训练任务都已完成
    pool.close()
    pool.join()

    return models


if __name__ == '__main__':
    train_cohort = 'UKB_healthy_bs10'
    organ = sys.argv[1]  # 'Brain-Cortex'
    cell_type = sys.argv[2]  # 'IN'

    save_dir = f"./scAge_models/{train_cohort}/{organ}/{cell_type}/"
    os.makedirs(save_dir, exist_ok=True)

    save_name = "lasso_model.coefs"
    savefp = os.path.join(save_dir, save_name)
    pre_res = os.path.join(save_dir, "lasso_ukb_test.pred_ages")

    df_pro = pd.read_csv('./proteins_processed.tsv', sep='\t')
    df_markers = pd.read_csv('./celltype_markers.bulk.tsv', sep='\t')

    if cell_type == 'All':
        df_pfc_s = df_markers
    else:
        df_pfc_s = df_markers[df_markers['clusters'].str.contains(cell_type)]

    specific_proteins = df_pfc_s['markers'].tolist()
    filtered_columns = df_pro.filter(items=specific_proteins)
    data = pd.concat([df_pro.iloc[:, :3], filtered_columns], axis=1)
    X = data.drop(['Age', 'ID'], axis=1)
    y = data['Age']
    X_train, X_test, y_train, y_test = train_test_split(X, y, train_size=0.8, random_state=42)
    print(X_train.shape, X_test.shape)

    idx = X_train.index
    with open(savefp, 'w') as f:
        f.write('BootStrap\t' + '\t'.join(X_train.columns) + '\tAlpha' + '\n')

    t_models = BootStrap(idx, X_train, y_train, train_cohort, organ, cell_type, n_bootstrap=10)

    # 直接使用暂存的模型
    pre_ages = []
    for m in t_models:
        pre_ages.append(m.predict(X_test))
    pre_ages = np.mean(np.array(pre_ages), axis=0)
    pre_res = os.path.join(save_dir, "lasso_ukb_test.pred_ages")
    with open(pre_res, 'w') as fp:
        fp.write('ID\t' + 'Pre_age\t' + 'Real_age\t' + '\n')
        for i in range(len(X_test)):
            fp.write(str(data.loc[X_test.index[i], 'ID']) + '\t' + str(pre_ages[i]) + '\t' + str(
                data.loc[X_test.index[i], 'Age']) + '\n')

    pre_data = pd.read_csv(pre_res, sep='\t')
    r_value, p_value = stats.pearsonr(pre_data['Real_age'], pre_data['Pre_age'])

    plt.figure(figsize=(6, 6))
    scatter_plot = sns.scatterplot(data=pre_data, x="Real_age", y="Pre_age")
    sns.regplot(x='Real_age', y='Pre_age', data=pre_data,
                line_kws={"color": "r", "alpha": 1, "lw": 1},
                scatter_kws={'s': 10, 'alpha': 1},
                ci=95)
    legend_text = f'R = {r_value:.2f}, p = {p_value:.1e}'
    red_patch = mpatches.Patch(color='none', label=legend_text)
    plt.title(f'train_cohort: {train_cohort}, organ: {organ}, cell_type: {cell_type}')
    plt.legend(handles=[red_patch], frameon=False
    plt.savefig(f'{train_cohort}_{organ}_{cell_type}_pre_r.pdf', format='pdf')
    plt.show()
