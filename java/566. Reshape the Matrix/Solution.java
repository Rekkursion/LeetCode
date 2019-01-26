// 566. Reshape the Matrix
// Accepted 7ms

class Solution {
    private boolean isLegal(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0 || nums[0].length == 0 || r <= 0 || c <= 0 || r * c != nums.length * nums[0].length)
            return false;
        
        int rowLen = nums[0].length;
        for(int k = 1; k < nums.length; ++k) {
            if(nums[k].length != rowLen)
                return false;
        }
        
        return true;
    }
    
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(!isLegal(nums, r, c))
            return nums;
        
        int[][] reshaped = new int[r][c];
        int rIdx = 0, cIdx = 0;
        
        for(int k = 0; k < nums.length; ++k) {
            for(int j = 0; j < nums[k].length; ++j) {
                reshaped[rIdx][cIdx++] = nums[k][j];
                
                if(cIdx == c) {
                    ++rIdx;
                    cIdx = 0;
                }
            }
        }
        
        return reshaped;
    }
}
