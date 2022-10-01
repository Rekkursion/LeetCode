#define CHECK_TWO_DIGITS(a, b) ((a) == '1' || ((a) == '2' && (b) <= '6'))

int getNumWays(char*, int, int);

int numDecodings(char *s) {
    return getNumWays(s, 0, strlen(s));
}

int getNumWays(char *s, int p, int q) {
    // printf("|%.*s|\n", q - p, s + p);
    // len = 0
    if (p >= q)
        return 1;
    // len = 1
    if (p + 1 == q)
        return s[p] != '0';
    // len = 2
    if (p + 2 == q)
        return ((s[p] != '0') * (s[p + 1] != '0')) + CHECK_TWO_DIGITS(s[p], s[p + 1]);
    
    int mid = (p + q) / 2;
    int leftNum = getNumWays(s, p, mid);
    int rightNum = getNumWays(s, mid, q);
    
    char a = s[mid - 1], b = s[mid];
    int leftNum2 = 0, rightNum2 = 0;
    if (CHECK_TWO_DIGITS(a, b)) {
        leftNum2 = getNumWays(s, p, mid - 1);
        rightNum2 = getNumWays(s, mid + 1, q);
    }
    return leftNum * rightNum + leftNum2 * rightNum2;
}