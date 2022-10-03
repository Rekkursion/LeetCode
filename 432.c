// #define QQ


typedef struct lnode {
    int cnt;
    char *s;
    struct lnode *next;
    struct lnode *prev;
}LNode;

LNode* newLNode(char *s) {
    LNode *nd = (LNode*)malloc(sizeof(LNode));
    nd->cnt = 1;
    if (s) {
        nd->s = (char*)calloc(strlen(s) + 1, sizeof(char));
        strcpy(nd->s, s);
    }
    else
        nd->s = NULL;
    nd->next = nd->prev = NULL;
    return nd;
}

typedef struct tnode {
    LNode *lp;
    struct tnode *children[26];
}TrieNode;

TrieNode* newTrieNode() {
    TrieNode *nd = (TrieNode*)malloc(sizeof(TrieNode));
    for (int k = 0; k < 26; ++k)
        nd->children[k] = NULL;
    nd->lp = NULL;
    return nd;
}

void freeTrie(TrieNode *t) {
    for (int k = 0; k < 26; ++k) {
        if (t->children[k])
            freeTrie(t->children[k]);
    }
    free(t);
}

typedef struct {
    TrieNode *trie;
    LNode* lhead;
    LNode* ltail;
}AllOne;


#ifdef QQ
    void printInfo(AllOne *obj) {
        LNode *p = obj->lhead->next;
        while (p->s) {
            printf("|%s|cnt = %d|\n", p->s, p->cnt);
            p = p->next;
        }
        printf("=====================================\n");
    }
#endif


AllOne* allOneCreate() {
    AllOne *obj = (AllOne*)malloc(sizeof(AllOne));
    // a dummy head and a dummy tail
    obj->lhead = newLNode(NULL);
    obj->ltail = newLNode(NULL);
    obj->lhead->next = obj->ltail;
    obj->ltail->prev = obj->lhead;
    obj->trie = newTrieNode();
    return obj;
}

void allOneInc(AllOne* obj, char *key) {
    TrieNode* t = obj->trie;
	int trieIdx;
    for (char *p = key; *p; ++p) {
		trieIdx = *p - 97;
		if (t->children[trieIdx] == NULL)
            t->children[trieIdx] = newTrieNode();
		t = t->children[trieIdx];
	}
    // a new key means its count = 1 and shall be inserted in the very front of the list
    if (!(t->lp)) {
        t->lp = newLNode(key);
        t->lp->next = obj->lhead->next;
        obj->lhead->next->prev = t->lp;
        obj->lhead->next = t->lp;
        t->lp->prev = obj->lhead;
    }
    // move a-tail
    else {
        ++(t->lp->cnt);
        LNode *p = t->lp->next, *q = t->lp;
        while (p->s && p->cnt < t->lp->cnt) {
            q = p;
            p = p->next;
        }
        // insert t->lp between q & p
        if (q != t->lp) {
            t->lp->prev->next = t->lp->next;
            t->lp->next->prev = t->lp->prev;
            t->lp->prev = q;
            q->next = t->lp;
            t->lp->next = p;
            p->prev = t->lp;
        }
    }
    #ifdef QQ
        printf("INC: |%s|\n", key), printInfo(obj);
    #endif
}

void allOneDec(AllOne* obj, char *key) {
    TrieNode* t = obj->trie;
	int trieIdx;
    for (char *p = key; *p; ++p) {
		trieIdx = *p - 97;
        // no need to check if the children exist or not since the problem guarantees the existence of the key
		// if (t->children[trieIdx] == NULL)
        //     t->children[trieIdx] = newTrieNode();
		t = t->children[trieIdx];
	}
    --(t->lp->cnt);
    // do removal of the node from the list
    if (t->lp->cnt == 0) {
        t->lp->prev->next = t->lp->next;
        t->lp->next->prev = t->lp->prev;
        free(t->lp);
        t->lp = NULL;
    }
    // move ahead
    else {
        LNode *p = t->lp->prev, *q = t->lp;
        while (p->s && p->cnt > t->lp->cnt) {
            q = p;
            p = p->prev;
        }
        // insert t->lp between p & q
        if (q != t->lp) {
            t->lp->prev->next = t->lp->next;
            t->lp->next->prev = t->lp->prev;
            t->lp->prev = p;
            p->next = t->lp;
            t->lp->next = q;
            q->prev = t->lp;
        }
    }
    #ifdef QQ
        printf("DEC: |%s|\n", key), printInfo(obj);
    #endif
}

char* allOneGetMaxKey(AllOne* obj) {
    LNode *p = obj->ltail->prev;
    if (p->s)
        return p->s;
    return "";
}

char* allOneGetMinKey(AllOne* obj) {
    LNode *p = obj->lhead->next;
    if (p->s)
        return p->s;
    return "";
}

void allOneFree(AllOne* obj) {
    freeTrie(obj->trie);
    LNode *p = obj->lhead, *q = NULL;
    while (p) {
        q = p;
        p = p->next;
        if (q->s)
            free(q->s);
        free(q);
    }
    free(obj);
}

/**
 * Your AllOne struct will be instantiated and called as such:
 * AllOne* obj = allOneCreate();
 * allOneInc(obj, key);
 
 * allOneDec(obj, key);
 
 * char * param_3 = allOneGetMaxKey(obj);
 
 * char * param_4 = allOneGetMinKey(obj);
 
 * allOneFree(obj);
*/