#define PI 3.14159265358979323846
#define DEG2RAD(deg) ((deg) * PI / 180.0)

int cmp(void const*, void const*);
int binarySearch(double*, int, double);

int visiblePoints(int **points, int pointsSize, int *pointsColSize, int angle, int *location, int locationSize) {
    double *radList = (double*)malloc(sizeof(double) * pointsSize);
    double rad;
    int radCnt = 0, atOriCnt = 0;
    for (int k = 0; k < pointsSize; ++k) {
        int ptY = points[k][1], ptX = points[k][0];
        if (ptY == location[1] && ptX == location[0])
            ++atOriCnt;
        else {
            rad = atan2(ptY - location[1], ptX - location[0]);
            if (rad < 0.0)
                rad += PI * 2.0;
            radList[radCnt++] = rad;
        }
    }
    qsort(radList, radCnt, sizeof(double), cmp);
    
    double const rangeRad = DEG2RAD((double)angle);
    double const RAD360 = 2.0 * PI;
    double radEnd, lastRad = -1.0;
    int visibleCnt = 0, maxVisibleCnt = 0;
    for (int k = 0; k < radCnt; ++k) {
        rad = radList[k];
        if (lastRad != rad) {
            radEnd = rad + rangeRad;
            if (radEnd <= RAD360) {
                visibleCnt = binarySearch(radList, radCnt, radEnd);
                visibleCnt -= k;
            }
            else {
                visibleCnt = binarySearch(radList, radCnt, RAD360);
                visibleCnt -= k;
                visibleCnt += binarySearch(radList, radCnt, radEnd - RAD360);
            }
            
            if (visibleCnt > maxVisibleCnt)
                maxVisibleCnt = visibleCnt;
        }
        lastRad = rad;
    }
    
    free(radList);
    return maxVisibleCnt + atOriCnt;
}

int cmp(void const *a, void const *b) {
    double da = *(double*)a;
    double db = *(double*)b;
    if (da < db)
        return -1;
    else if (da > db)
        return 1;
    return 0;
}

int binarySearch(double* arr, int arrLen, double x) {
    if (arrLen == 0)
        return 0;
    int p = 0, q = arrLen - 1;
    int mid;
    while (p < q) {
        mid = (p + q) / 2;
        if (arr[mid] <= x)
            p = mid + 1;
        else /* if (arr[mid] > x) */
            q = mid - 1;
    }
    return arr[p] > x ? p : p + 1;
}