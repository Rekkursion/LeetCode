typedef long long int ll;

ll doPower(ll, int, int);

char* subStrHash(char *s, int power, int modulo, int k, int hashValue) {
    // calculate the hash value of the last substring
    ll v = 0;
    int const sLen = strlen(s);
    int i = sLen - 1;
    for (int j = k - 1; j >= 0; --j, --i)
        v = (v + (s[i] - 96) * doPower((ll)power, j, modulo)) % modulo;
    
    // start moving to left to check other substrings in the reversed order
    int ansIdx = i + 1;
    for (int j = i; j >= 0; --j) {
        v -= ((s[j + k] - 96) * doPower((ll)power, k - 1, modulo)) % modulo;
        while (v <= 0)
            v += modulo;
        v *= power;
        v += s[j] - 96;
        v %= modulo;
        // printf("|j = %d|%.*s|v = %lld|\n", j, k, s + j, v);
        if ((int)v == hashValue)
            ansIdx = j;
    }
    
    char *ret = (char*)calloc(k + 1, sizeof(char));
    strncpy(ret, s + ansIdx, k);
    return ret;
}

ll doPower(ll b, int p, int m) {
    ll ret = 1;
    while (p) {
        if (p & 1)
            ret = (ret * b) % m;
        b = (b * b) % m;
        p >>= 1;
    }
    return ret;
}


/*
"ufbasdfoudsbfuoasfbheawsuifeasbgdfuisadfbeauiosfbdsfuoidsabnfsduoifbndsuiofdsbfuidsbfguidsobgfsdiufgbdsuiogfbnsduifgsdsdsdsdhsdsdsrekkedefusbdfuidsfbdufdrdddsdekkdfsaudfbiasfdichnsadksadyusadsdfdskofyodsfdfdfdfdfddbdssssduyisvd"
999999999
2
67
1
*/