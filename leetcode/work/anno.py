import os
import sys
import pandas as pd


def anno(file):
    dic = {}
    with open("../../eur.merge.bim", "r") as f:
        for line in f:
            line = line.strip().split()
            dic[line[1]] = line[0] + ':' + line[3]

    with open(file, "r") as f1:
        result = []
        keys = f1.readline().strip().split()
        while True:
            lines = f1.readline().strip().split()
            if not lines:
                break
            item = {}
            for name, value in zip(keys, lines):
                item[name] = value
            try:
                item['CHR'] = dic.get(item['SNP']).split(':')[0]
                item['POS'] = dic.get(item['SNP']).split(':')[1]
                result.append(item)
            except:
                print(item['SNP'])

    df = pd.DataFrame(result)
    df = df.reindex(columns=['SNP', 'A1', 'A2', 'CHR', 'POS', 'p.placo'])
    df['CHR'] = pd.to_numeric(df['CHR'], errors='coerce')
    df['POS'] = pd.to_numeric(df['POS'], errors='coerce')
    df = df.sort_values(by=['CHR', 'POS'])
    df.to_csv(file + '.annotated', index=False, sep='\t')


if __name__ == '__main__':
    path = sys.argv[1]
    files = [file for file in os.listdir(path) if file.endswith(".PLACO")]
    for file in files:
        anno(file)
