// 42. Trapping Rain Water
// Accepted 

class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        
        int highestIdx = 0, highestHeight = height[0];
        int trappedWater = 0, i, j, obstacle;
        
        // find the highest one and its index
        for(int k = 1; k < height.length; ++k) {
            if(height[k] > highestHeight) {
                highestHeight = height[k];
                highestIdx = k;
            }
        }
        
        // left to right
        obstacle = 0;
        i = -1;
        for(int k = 0; k <= highestIdx; ++k) {
            if(k + 1 <= highestIdx && height[k + 1] < height[k] && i == -1)
                i = k;
            else {
                if(i != -1) {
                    if(height[k] >= height[i]) {
                        trappedWater += ((k - i - 1) * height[i]) - obstacle;
                        i = k;
                        obstacle = 0;
                    }
                    else
                        obstacle += height[k];
                }
            }
        }
        
        // right to left
        obstacle = 0;
        i = -1;
        for(int k = height.length - 1; k >= highestIdx; --k) {
            if(k - 1 >= highestIdx && height[k - 1] < height[k] && i == -1)
                i = k;
            else {
                if(i != -1) {
                    if(height[k] >= height[i]) {
                        trappedWater += ((i - k - 1) * height[i]) - obstacle;
                        i = k;
                        obstacle = 0;
                    }
                    else
                        obstacle += height[k];
                }
            }
        }
        
        return trappedWater;
    }
}
