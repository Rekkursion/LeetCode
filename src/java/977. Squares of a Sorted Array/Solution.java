// 977. Squares of a Sorted Array
// Accepted 13ms

class Solution {
    public int[] sortedSquares(int[] A) {
        int firstNonnegativeIdx = Arrays.binarySearch(A, 0);
        int i, j, retIdx;
        int[] ret = new int[A.length];
        
        if(firstNonnegativeIdx < 0) {
            if((-firstNonnegativeIdx) - 1 == A.length)
                firstNonnegativeIdx = A.length - 1;
            else if((-firstNonnegativeIdx) - 1 == 0)
                firstNonnegativeIdx = 0;
            else
                firstNonnegativeIdx = A[(-firstNonnegativeIdx) - 1] < -A[(-firstNonnegativeIdx) - 2] ? (-firstNonnegativeIdx) - 1 : (-firstNonnegativeIdx) - 2;
        }
        
        i = j = firstNonnegativeIdx;
        retIdx = 0;
        while(i >= 0 || j < A.length) {
            if(j >= A.length || (i >= 0 && Math.abs(A[i]) < Math.abs(A[j]))) {
                ret[retIdx++] = A[i] * A[i];
                --i;
            }
            else {
                if(i == j)
                    --i;
                ret[retIdx++] = A[j] * A[j];
                ++j;
            }
        }
        
        return ret;
    }
}
