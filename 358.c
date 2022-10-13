typedef struct node {
    char c;
    int cnt;
}Node;

int cmp(void const*, void const*);
void freeBuckets(char**, int*, int const);

char* rearrangeString(char *s, int k) {
    if (k <= 1)
        return s;
    
    Node arr[26];
    for (int p = 0; p < 26; ++p)
        arr[p].cnt = 0, arr[p].c = p;
    
    int sLen = 0;
    for (char *p = s; *p; ++p)
        ++(arr[*p - 97].cnt), ++sLen;
    qsort(arr, 26, sizeof(Node), cmp);
    
    int maxCnt = arr[0].cnt;
    char **buckets = (char**)malloc(sizeof(char*) * maxCnt);
    int *buckCnts = (int*)malloc(sizeof(int) * maxCnt);
    for (int j = 0; j < maxCnt; ++j) {
        buckets[j] = (char*)calloc(sLen + 1, sizeof(char));
        buckCnts[j] = 0;
    }
    int retLen = 0;
    for (int p = 0; p < 26;) {
        if (arr[p].cnt == maxCnt) {
            for (int j = 0; j < maxCnt; ++j)
                buckets[j][buckCnts[j]++] = arr[p].c + 97;
            ++p;
            retLen += maxCnt;
        }
        else if (arr[p].cnt == 0)
            ++p;
        else {
            for (int j = 0; j < maxCnt - 1 && p < 26; ++p) {
                for (; j < maxCnt - 1 && arr[p].cnt; ++j) {
                    buckets[j][buckCnts[j]++] = arr[p].c + 97;
                    ++retLen;
                    --(arr[p].cnt);
                }
                if (j == maxCnt - 1)
                    break;
            }
        }
    }
    char *ret = (char*)calloc(retLen + 1, sizeof(char));
    for (int j = 0; j < maxCnt - 1; ++j) {
        if (buckCnts[j] < k) {
            freeBuckets(buckets, buckCnts, maxCnt);
            free(ret);
            return "";
        }
        strcat(ret, buckets[j]);
    }
    strcat(ret, buckets[maxCnt - 1]);
    freeBuckets(buckets, buckCnts, maxCnt);
    return ret;
}

int cmp(void const *a, void const *b) {
    return ((Node*)a)->cnt < ((Node*)b)->cnt;
}

void freeBuckets(char **bkts, int *bktCnts, int const maxCnt) {
    for (int j = 0; j < maxCnt; ++j)
        free(bkts[j]);
    free(bkts);
    free(bktCnts);
}