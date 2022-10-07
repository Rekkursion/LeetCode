


typedef struct {
    int len;
    int p;
    int* enc;
} RLEIterator;


RLEIterator* rLEIteratorCreate(int* encoding, int encodingSize) {
    RLEIterator* obj = (RLEIterator*)malloc(sizeof(RLEIterator));
    obj->enc = (int*)malloc(sizeof(int) * encodingSize);
    obj->p = 0;
    obj->len = encodingSize;
    for (int k = 0; k < encodingSize; ++k)
        obj->enc[k] = encoding[k];
    return obj;
}

int rLEIteratorNext(RLEIterator* obj, int n) {
    while (obj->p < obj->len && obj->enc[obj->p] < n) {
        n -= obj->enc[obj->p];
        obj->p += 2;
    }
    if (obj->p >= obj->len)
        return -1;
    obj->enc[obj->p] -= n;
    return obj->enc[obj->p + 1];
}

void rLEIteratorFree(RLEIterator* obj) {
    free(obj->enc);
    free(obj);
}

/**
 * Your RLEIterator struct will be instantiated and called as such:
 * RLEIterator* obj = rLEIteratorCreate(encoding, encodingSize);
 * int param_1 = rLEIteratorNext(obj, n);
 
 * rLEIteratorFree(obj);
*/