// 11. Container With Most Water
// Accepted 8ms

class Solution {
    public int maxArea(int[] height) {
        int k = 0;
        int j = height.length - 1;
        int max_area = 0, area = 0;
        int shortIdx;
        
        while(k < j) {
            shortIdx = (height[k] < height[j]) ? k : j;
            
            area = height[shortIdx] * (j - k);
            if(area > max_area)
                max_area = area;
            
            if(height[k] == height[j]) {
                k++;
                j--;
            }
            else {
                if(shortIdx == k)
                    k++;
                else
                    j--;
            }
        }
        
        return max_area;
    }
}
