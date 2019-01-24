func twoSum(nums []int, target int) []int {
    var ret []int = []int{ 0, 0 }
    var found bool = false
    
    for i, n := range nums {
        for j := i + 1; j < len(nums) && !found; j++ {
            if n + nums[j] == target {
                ret[0], ret[1], found = i, j, true
                break
            }
        }
    }
    
    return ret
}
