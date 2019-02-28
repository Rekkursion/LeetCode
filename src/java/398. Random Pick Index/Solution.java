// 398. Random Pick Index
// Accepted 230ms

class Solution {
    int[] numbers;
    Random randGen;

    public Solution(int[] nums) {
        numbers = nums;
        randGen = new Random();
    }
    
    public int pick(int target) {
        int selected = 0;
        
        do {
            selected = randGen.nextInt(numbers.length);
        }while(numbers[selected] != target);
        
        return selected;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
