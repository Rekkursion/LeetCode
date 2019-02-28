// 4. Median of Two Sorted Arrays
// Accepted 24ms

func merge(arr1, arr2 []int) (ret []int) {
    ret = make([]int, 0)
    var (
        len1 int = len(arr1)
        len2 int = len(arr2)
    )
    
    for i, j := 0, 0; i < len1 || j < len2; {
        if i < len1 && j < len2 {
            if arr1[i] < arr2[j] {
                ret = append(ret, arr1[i])
                i++
            } else {
                ret = append(ret, arr2[j])
                j++
            }
        } else if i < len1 {
            ret = append(ret, arr1[i])
            i++
        } else {
            ret = append(ret, arr2[j])
            j++
        }
    }
    
    return
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    var (
        nums []int = merge(nums1, nums2)
        median float64 = 0
    )
    
    if (len(nums) & 1) == 1 {
        median = float64(nums[len(nums) >> 1])
    } else {
        if len(nums) == 0 {
            median = 0.0
        } else {
            median = (float64(nums[len(nums) >> 1]) + float64(nums[(len(nums) >> 1) - 1])) / 2.0
        }
    }
    
    return median
}
