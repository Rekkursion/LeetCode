

RAW_INPUT_FPATH = './0.raw'
INPUT_FPATH = './0.in'


with open(str(RAW_INPUT_FPATH), 'r', encoding='utf-8') as f:
    raw = f.read().replace('\r', '').replace('\n', '')

lis = eval(raw)

with open(str(INPUT_FPATH), 'w', encoding='utf-8') as f:
    for row_idx, row in enumerate(lis):
        f.write(' '.join(row))
        if row_idx < 8:
            f.write('\n')
