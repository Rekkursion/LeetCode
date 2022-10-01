#define CHECK_ONE_DIGIT(c) ((c) == '*' ? 9LL : (ll)((c) != '0'))
#define MOD 1000000007LL

typedef long long int ll;

ll checkTwoDigitsUnsplittable(char, char);

int numDecodings(char *s) {
    int sLen = strlen(s);
    ll* dp = (ll*)malloc(sizeof(ll) * (sLen + 1));
    dp[0] = 1LL;
    dp[1] = CHECK_ONE_DIGIT(s[0]);
    for (int k = 1; k < sLen; ++k)
        dp[k + 1] = (dp[k] * CHECK_ONE_DIGIT(s[k]) + (dp[k - 1] * checkTwoDigitsUnsplittable(s[k - 1], s[k]))) % MOD;
    int ret = (int)dp[sLen];
    free(dp);
    return ret;
}

ll checkTwoDigitsUnsplittable(char a, char b) {
    if (a == '*' && b == '*')
        return 15LL;
    else if (a == '*')
        return b <= '6' ? 2LL : 1LL;
    else if (b == '*') {
        if (a == '0' || a >= '3')
            return 0LL;
        if (a == '1')
            return 9LL;
        return 6LL;
    }
    return (ll)(a == '1' || (a == '2' && b <= '6'));
}