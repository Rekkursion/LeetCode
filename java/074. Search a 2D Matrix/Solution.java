// 74. Search a 2D Matrix
// Accepted 5ms

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int head = 0, tail = (matrix.length * matrix[0].length) - 1;
        int mid, lastMid = -1;
        int r, c;
        
        while(head <= tail) {
            mid = ((head + tail) >>> 1);
            if(mid == lastMid)
                break;
            lastMid = mid;
            
            r = mid / matrix[0].length;
            c = mid % matrix[0].length;
            
            if(matrix[r][c] > target)
                tail = mid - 1;
            else if(matrix[r][c] < target)
                head = mid + 1;
            else
                return true;
        }
        
        return false;
    }
}
