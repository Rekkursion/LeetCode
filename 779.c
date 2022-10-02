

int kthGrammar(int n, int k) {
    int ans = 0, d;
    --k;
    while (k > 0) {
        // go right from top to bottom
        if (k & 1)
            ans = ~ans;
        k >>= 1;
    }
    if (ans)
        ans = 1;
    return ans;
}