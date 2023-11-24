import os
import sys
import pandas as pd


def check_maf(file):
    dic = {}
    with open("eur.merge.bim", "r") as f:
        for line in f:
            line = line.strip().split()
            dic[line[1]] = line[4] + line[5]

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
            if dic.get(item["SNP"])[0] == item["A2"] and dic.get(item["SNP"])[1] == item["A1"]:
                item['A1'], item['A2'] = item['A2'], item['A1']
                item["EAF"] = 1.0 - float(item["EAF"])
                item["beta"] = -float(item["beta"])
                result.append(item)
            elif dic.get(item["SNP"])[0] == item["A1"] and dic.get(item["SNP"])[1] == item["A2"]:
                result.append(item)
            else:
                continue

    df = pd.DataFrame(result)
    df = df.reindex(columns=['SNP', 'A1', 'A2', 'EAF', 'beta', 'se', 'p', 'N'])
    df.to_csv(file + '.checked', index=False, sep='\t')


if __name__ == '__main__':
    path = sys.argv[1]
    files = [file for file in os.listdir(path) if file.endswith(".ma")]
    for file in files:
        check_maf(file)
