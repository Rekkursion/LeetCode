

bool isMatch(char *s, char *p) {
    int sLen = strlen(s);
    bool *dp = (bool*)malloc(sizeof(bool) * (sLen + 1));
    dp[0] = true;
    for (int k = 1; k <= sLen; ++k)
        dp[k] = false;
    
    // for (int k = 0; k <= sLen; ++k)
    //     printf("%d ", dp[k]);
    // puts("");
    
    bool upLeft, tmp;
    for (char *c = p; *c; ++c) {
        tmp = dp[0];
        if (*(c + 1) != '*')
            dp[0] = false;
        for (int k = 1; k <= sLen; ++k) {
            upLeft = tmp;
            tmp = dp[k];
            if (*(c + 1) == '*') {
                // .*
                if (*c == '.')
                    dp[k] = upLeft || dp[k - 1] || dp[k];
                // c*
                else {
                    if (s[k - 1] == *c)
                        dp[k] = upLeft || dp[k - 1] || dp[k];
                }
            }
            else {
                // .
                if (*c == '.')
                    dp[k] = upLeft;
                // c
                else {
                    if (s[k - 1] == *c)
                        dp[k] = upLeft;
                    else
                        dp[k] = false;
                }
            }
        }
        if (*(c + 1) == '*')
            ++c;
        // for (int k = 0; k <= sLen; ++k)
        //     printf("%d ", dp[k]);
        // puts("");
    }
    
    bool ret = dp[sLen];
    free(dp);
    return ret;
}