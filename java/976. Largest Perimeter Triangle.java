// 976. Largest Perimeter Triangle
// Accepted 23ms

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        
        for(int k = A.length - 1; k - 2 >= 0; --k) {
            if(A[k - 2] + A[k - 1] > A[k])
                return (A[k - 2] + A[k - 1] + A[k]);
        }
        
        return 0;
    }
}
