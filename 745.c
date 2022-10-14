// #define QQ


typedef struct lnode {
    int idx;
    struct lnode *next;
}LNode;

typedef struct inner_trie_node {
    LNode *lhead;
    LNode *ltail;
    struct inner_trie_node *children[26];
}InnerTrieNode;

typedef struct outer_trie_node {
    InnerTrieNode *innerRoot;
    struct outer_trie_node *children[26];
}OuterTrieNode;


#ifdef QQ
    void visitITrie(InnerTrieNode *iRoot, int layer) {
        if (!iRoot)
            return;
        for (int k = 0; k < 26; ++k) {
            if (iRoot->children[k]) {
                LNode *x = iRoot->children[k]->lhead;
                for (int j = 0; j < layer; ++j)
                    putchar('\t');
                printf("\t(%c)", k + 97);
                while (x) {
                    printf("->|%d|", x->idx);
                    x = x->next;
                }
                puts("");
                visitITrie(iRoot->children[k], layer + 1);
            }
        }
    }
#endif


LNode* newLNode(int const wordIdx) {
    LNode *nd = (LNode*)malloc(sizeof(LNode));
    nd->idx = wordIdx;
    nd->next = NULL;
    return nd;
}


InnerTrieNode* newITNode() {
    InnerTrieNode *nd = (InnerTrieNode*)malloc(sizeof(InnerTrieNode));
    nd->lhead = nd->ltail = NULL;
    for (int k = 0; k < 26; ++k)
        nd->children[k] = NULL;
    return nd;
}


OuterTrieNode* newOTNode() {
    OuterTrieNode *nd = (OuterTrieNode*)malloc(sizeof(OuterTrieNode));
    nd->innerRoot = newITNode();
    for (int k = 0; k < 26; ++k)
        nd->children[k] = NULL;
    return nd;
}

void insertWordAtInner(InnerTrieNode *iRoot, int const wordIdx, char const *const p) {
    int k = *p - 97;
    if (!(iRoot->children[k]))
        iRoot->children[k] = newITNode();
    
    LNode *lnd = newLNode(wordIdx);
    if (!(iRoot->children[k]->lhead))
        iRoot->children[k]->lhead = iRoot->children[k]->ltail = lnd;
    else {
        iRoot->children[k]->ltail->next = lnd;
        iRoot->children[k]->ltail = lnd;
    }
    
    if (*(p + 1))
        insertWordAtInner(iRoot->children[k], wordIdx, p + 1);
}

void insertWord(OuterTrieNode *oRoot, int const wordIdx, char const *const s, int q) {
    int k = s[q] - 97;
    if (oRoot->children[k] == NULL)
        oRoot->children[k] = newOTNode();
    
    insertWordAtInner(oRoot->children[k]->innerRoot, wordIdx, s);
    
    if (q > 0)
        insertWord(oRoot->children[k], wordIdx, s, q - 1);
}

InnerTrieNode* searchSuffix(OuterTrieNode *oRoot, char const *const suffix, int q) {
    int k = suffix[q] - 97;
    if (!oRoot || !(oRoot->children[k]))
        return NULL;
    if (q > 0)
        return searchSuffix(oRoot->children[k], suffix, q - 1);
    return oRoot->children[k]->innerRoot;
}

LNode* searchPrefix(InnerTrieNode *iRoot, char const *const p) {
    if (*p == 0)
        return iRoot->ltail;
    
    #ifdef QQ
        printf("\n[%c]", *p);
        visitITrie(iRoot, 0);
    #endif
    
    int k = *p - 97;
    if (!iRoot || !(iRoot->children[k]))
        return NULL;
    return searchPrefix(iRoot->children[k], p + 1);
}

void freeInnerTrie(InnerTrieNode *iRoot) {
    for (int k = 0; k < 26; ++k) {
        if (iRoot->children[k])
            freeInnerTrie(iRoot->children[k]);
    }
    LNode *x = iRoot->lhead, *y = NULL;
    while (x) {
        y = x;
        x = x->next;
        free(y);
    }
    free(iRoot);
}

void freeOuterTrie(OuterTrieNode *oRoot) {
    for (int k = 0; k < 26; ++k) {
        if (oRoot->children[k])
            freeOuterTrie(oRoot->children[k]);
    }
    freeInnerTrie(oRoot->innerRoot);
    free(oRoot);
}


typedef struct {
    OuterTrieNode *outerRoot;
} WordFilter;


WordFilter* wordFilterCreate(char **words, int wordsSize) {
    WordFilter *obj = (WordFilter*)malloc(sizeof(WordFilter));
    obj->outerRoot = newOTNode(NULL);
    int wLen;
    for (int j = 0; j < wordsSize; ++j) {
        wLen = strlen(words[j]);
        insertWord(obj->outerRoot, j, words[j], wLen - 1);
    }
    return obj;
}

int wordFilterF(WordFilter *obj, char *pref, char *suff) {
    InnerTrieNode *iRoot = searchSuffix(obj->outerRoot, suff, strlen(suff) - 1);
    
    LNode *ret = searchPrefix(iRoot, pref);
    if (!ret)
        return -1;
    return ret->idx;
}

void wordFilterFree(WordFilter* obj) {
    freeOuterTrie(obj->outerRoot);
    free(obj);
}

/**
 * Your WordFilter struct will be instantiated and called as such:
 * WordFilter* obj = wordFilterCreate(words, wordsSize);
 * int param_1 = wordFilterF(obj, pref, suff);
 
 * wordFilterFree(obj);
*/