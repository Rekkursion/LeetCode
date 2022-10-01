#define MAX_HEAP_SZ 10001

typedef struct node {
    int h;
    int l;
    int r;
}Node;

void addNode(int, int, int, int*, Node*);
void swapNodes(int, int, Node*);
Node popNode(int*, Node*);

typedef struct interval_node {
    int l;
    int r;
    struct interval_node* next;
}INode;

INode* newIntervalNode(int, int);
int* addInterval(int, int, int*, INode**, INode**);

typedef struct coords_node {
    int x;
    int y;
    struct coords_node* next;
}CNode;

void pushCoordsNode(int, int, CNode**, CNode**);

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** getSkyline(int** buildings, int buildingsSize, int* buildingsColSize, int* returnSize, int** returnColumnSizes) {
    // read in the coordinates into a max-heap with respect to their heights
    Node heap[MAX_HEAP_SZ];
    int hpSz = 0;
    for (int k = 0; k < buildingsSize; ++k) {
        int l = buildings[k][0];
        int r = buildings[k][1];
        int h = buildings[k][2];
        addNode(h, l, r, &hpSz, heap);
    }
    // construct the skyline from the highest height
    INode* ihead = NULL, *itail = NULL;
    CNode* chead = NULL, *ctail = NULL;
    while (hpSz) {
        Node nd = popNode(&hpSz, heap);
        int xCnt = 0;
        int* xList = addInterval(nd.l, nd.r, &xCnt, &ihead, &itail);
        for (int k = 0; k < xCnt; ++k)
            pushCoordsNode(xList[k], nd.h, &chead, &ctail);
        free(xList);
    }
    int* rMosts = (int*)malloc(sizeof(int) * MAX_HEAP_SZ);
    int rMostCnt = 0;
    for (INode* p = ihead, *q = NULL; p;) {
        int k;
        for (k = 0; k < rMostCnt; ++k)
            if (rMosts[k] == p->r)
                break;
        if (k == rMostCnt)
            rMosts[rMostCnt++] = p->r;
        q = p;
        p = p->next;
        free(q);
    }
    for (int k = 0; k < rMostCnt; ++k)
        pushCoordsNode(rMosts[k], 0, &chead, &ctail);
    free(rMosts);
    // build the answers
    int **ret = (int**)malloc(sizeof(int*) * MAX_HEAP_SZ);
    *returnColumnSizes = (int*)malloc(sizeof(int) * MAX_HEAP_SZ);
    int retCnt = 0;
    int curx = -1, cury = -1;
    CNode* p = chead, *q = NULL;
    while (p) {
        if (p->x != curx && p->y != cury) {
            ret[retCnt] = (int*)malloc(sizeof(int) * 2);
            ret[retCnt][0] = p->x;
            ret[retCnt][1] = p->y;
            (*returnColumnSizes)[retCnt] = 2;
            ++retCnt;
            curx = p->x, cury = p->y;
        }
        q = p;
        p = p->next;
        free(q);
    }
    *returnSize = retCnt;
    return ret;
}

void addNode(int h, int l, int r, int* heapSz, Node* heap) {
    int q = *heapSz;
    heap[q].h = h;
    heap[q].l = l;
    heap[q].r = r;
    ++(*heapSz);
    int p = ((q - 1) >> 1);
    while (p >= 0 && p != q) {
        int ph = heap[p].h;
        int qh = heap[q].h;
        if (ph < qh || (ph == qh && heap[p].l > heap[q].l))
            swapNodes(p, q, heap);
        else
            break;
        q = p;
        p = ((p - 1) >> 1);
    }
}

void swapNodes(int idx1, int idx2, Node* heap) {
    int tmp = heap[idx1].h;
    heap[idx1].h = heap[idx2].h;
    heap[idx2].h = tmp;
    tmp = heap[idx1].l;
    heap[idx1].l = heap[idx2].l;
    heap[idx2].l = tmp;
    tmp = heap[idx1].r;
    heap[idx1].r = heap[idx2].r;
    heap[idx2].r = tmp;
}

Node popNode(int* heapSz, Node* heap) {
    --(*heapSz);
    int sz = *heapSz;
    Node ret;
    ret.h = heap[0].h;
    ret.l = heap[0].l;
    ret.r = heap[0].r;
    swapNodes(0, *heapSz, heap);
    int p = 0, ql = 1, qr = 2;
    while (ql < sz || qr < sz) {
        if (ql < sz && qr < sz && heap[ql].h < heap[qr].h) {
            if (heap[p].h < heap[qr].h) {
                swapNodes(p, qr, heap);
                p = qr;
            }
            else
                break;
        }
        else {
            if (heap[p].h < heap[ql].h) {
                swapNodes(p, ql, heap);
                p = ql;
            }
            else
                break;
        }
        ql = (p << 1) + 1;
        qr = (p << 1) + 2;
    }
    return ret;
}

INode* newIntervalNode(int l, int r) {
    INode* nd = (INode*)malloc(sizeof(INode));
    nd->l = l;
    nd->r = r;
    nd->next = NULL;
    return nd;
}

int* addInterval(int l, int r, int* retCnt, INode** ihead, INode** itail) {
    int* retXs = (int*)malloc(sizeof(int) * MAX_HEAP_SZ);
    if (!(*ihead)) {
        *ihead = *itail = newIntervalNode(l, r);
        retXs[(*retCnt)++] = l;
    }
    else {
        INode* p = *ihead, *q = NULL;
        int applied = 0, enshrouded = 0;
        while (p) {
            int il = p->l, ir = p->r;
            if (l < il && r >= il && (!q || l > q->r)) {
                p->l = l;
                retXs[(*retCnt)++] = l;
                applied = 1;
            }
            if (l <= ir && r > ir) {
                p->r = r;
                retXs[(*retCnt)++] = ir;
                applied = 1;
            }
            if (l >= il && r <= ir)
                enshrouded = 1;
            q = p;
            p = p->next;
        }
        if (!applied && !enshrouded) {
            INode* nd = newIntervalNode(l, r);
            INode* p = *ihead, *q = NULL;
            while (p) {
                if (p->l > l) {
                    if (p == *ihead)
                        *ihead = nd, (*ihead)->next = p;
                    else
                        q->next = nd, nd->next = p;
                    break;
                }
                q = p;
                p = p->next;
            }
            if (!p) {
                (*itail)->next = nd;
                *itail = nd;
            }
            retXs[(*retCnt)++] = l;
        }
    }
    // merge intervals if overlappings ensued after adding the new ones
    int totallyMerged = 1;
    do {
        totallyMerged = 1;
        INode* q = *ihead, *p = q ? q->next : NULL;
        while (p && q) {
            int qr = q->r, ql = q->l, pr = p->r, pl = p->l;
            if (qr >= pl && ql <= pr) {
                q->l = pl < ql ? pl : ql;
                q->r = pr > qr ? pr : qr;
                if (p->next)
                    q->next = p->next;
                else {
                    q->next = NULL;
                    *itail = q;
                }
                free(p);
                totallyMerged = 0;
                break;
            }
            q = p;
            p = p->next;
        }
        if (!p || !q)
            break;
    } while (totallyMerged);
    return retXs;
}

void pushCoordsNode(int x, int y, CNode** chead, CNode** ctail) {
    CNode* nd = (CNode*)malloc(sizeof(CNode));
    nd->x = x, nd->y = y;
    nd->next = NULL;
    if (!(*chead))
        *chead = *ctail = nd;
    else {
        int dup = 0;
        CNode* p = *chead, *q = NULL;
        while (p) {
            if (p->x > x) {
                if (!q)
                    *chead = nd;
                else
                    q->next = nd;
                nd->next = p;
                break;
            }
            if (p->x == x)
                dup = 1;
            q = p;
            p = p->next;
        }
        if (!p && !dup)
            q->next = nd, *ctail = nd;
    }
}