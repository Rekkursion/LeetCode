

bool isMatch(char *s, char *p) {
    int sLen = strlen(s);
    bool *dp = (bool*)malloc(sizeof(bool) * (sLen + 1));
    for (int k = 1; k <= sLen; ++k)
        dp[k] = false;
    dp[0] = true;
    
    bool upLeft, tmp;
    for (char *c = p; *c; ++c) {
        tmp = dp[0];
        if (*c != '*')
            dp[0] = false;
        for (int k = 1; k <= sLen; ++k) {
            upLeft = tmp;
            tmp = dp[k];
            if (*c == '?')
                dp[k] = upLeft;
            else if (*c == '*')
                dp[k] = upLeft || dp[k - 1] || dp[k];
            else {
                if (*c == s[k - 1])
                    dp[k] = upLeft;
                else
                    dp[k] = false;
            }
        }
    }
    
    bool ret = dp[sLen];
    free(dp);
    return ret;
}