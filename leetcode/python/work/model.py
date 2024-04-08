from sklearn import linear_model, datasets, utils
from sklearn.metrics import mean_squared_error, r2_score
import matplotlib.pyplot as plt
import numpy as np
from sklearn.model_selection import GridSearchCV
import pandas as pd


def LassoTrain(npx, label):
    reg = linear_model.Lasso(max_iter=10000)
    param_grid = {'alpha': np.array(range(1, 1000, 1)) / 1000}
    grid_search = GridSearchCV(reg, param_grid, cv=5, scoring='r2')
    gs = grid_search.fit(npx, label)

    params = gs.param_grid['alpha']
    scores = gs.cv_results_['mean_test_score']
    # print(scores)
    # scale_score = np.max(gs.cv_results_['mean_test_score'])/gs.cv_results_['mean_test_score']
    scale_score = gs.cv_results_['mean_test_score'] / np.max(gs.cv_results_['mean_test_score'])
    selected_idx = np.where(scale_score >= 0.95)[0][-1]

    alpha = params[selected_idx]
    # print(alpha)
    # select alpha with performance of 0.95
    lasso_model = linear_model.Lasso(alpha=alpha, max_iter=10000)
    lasso_model.fit(npx, label)
    # train model in all samples
    return lasso_model


def BootStrap(samples, npx, label, n_bootstrap=200):
    # dpg = dict(zip(samples,[[] for _ in samples]))
    models = []
    for i in range(n_bootstrap):
        print(i)
        resamples = utils.resample(samples)
        re_npx = npx.loc[resamples]
        re_label = label.loc[resamples]

        models.append(LassoTrain(re_npx, re_label))
    return models


if __name__ == '__main__':
    original_data = pd.read_csv('30900.protein.npx', header=0, index_col=0, sep='\t')
    # original_data = original_data.fillna(0)
    sex = pd.read_csv('ukb.sex', header=0, index_col=0, sep='\t')
    original_data = original_data.join(sex)
    # print(original_data)
    healthy_ids = np.loadtxt('41270.healthy.ids', dtype=int)
    healthy_data = original_data.loc[np.intersect1d(original_data.index, healthy_ids)]

    healthy_samples = healthy_data.index
    ages = pd.read_csv('ukb.ages', header=0, index_col=0, sep='\t')

    tissues = np.loadtxt('tissues', dtype=str).reshape(-1)

    for t in tissues:
        tsg = list(np.loadtxt('TSP/' + t + '.specific.genes', dtype=str))
        tsg.append('sex')
        tissue_data = healthy_data[np.intersect1d(healthy_data.columns, tsg)]
        tissue_data = tissue_data.dropna()
        t_samples = tissue_data.index
        t_ages = ages.loc[t_samples]

        tissue_data_all = original_data[np.intersect1d(original_data.columns, tsg)]
        tissue_data_all = tissue_data_all.dropna()
        t_samples_all = tissue_data_all.index
        print(t)
        print(len(tissue_data))
        '''
        t_models = BootStrap(t_samples,tissue_data,t_ages,n_bootstrap=200)
        #t_models = BootStrap(t_samples,tissue_data,t_ages,n_bootstrap=200)
        pre_ages = []
        F = open(t+'.model.coefs','w')
        F.write('BootStrap\t'+'\t'.join(tissue_data.columns)+'\n')
        
        n = 0
        for m in t_models:
            n+=1
            pre_ages.append(m.predict(tissue_data_all))
            coef = m.coef_
            F.write(str(n)+'\t'+'\t'.join(coef.astype(str))+'\n')
        F.close()
            
        pre_ages = np.mean(np.array(pre_ages),axis=0)
        
        with open(t+'.pred_ages','w') as fp:
            for i in range(len(t_samples_all)):
                fp.write(str(t_samples_all[i])+'\t'+str(pre_ages[i])+'\n')
             
        '''
