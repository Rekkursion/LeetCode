// 4. Median of Two Sorted Arrays
// Accepted 140ms

function merge(nums1, nums2) {
    let [k, j, i] = [0, 0, 0];
    let [len1, len2] = [nums1.length, nums2.length];
    let ret = Array(nums1.length + nums2.length);
    
    while(k < len1 && j < len2) {
        if(nums1[k] < nums2[j])
            ret[i++] = nums1[k++];
        else
            ret[i++] = nums2[j++];
    }
    while(k < len1)
        ret[i++] = nums1[k++];
    while(j < len2)
        ret[i++] = nums2[j++];
    
    return ret;
}


/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let merged = merge(nums1, nums2);
    let ret = 0;
    
    if(merged.length > 0) {
        if((merged.length & 1) == 1)
            ret = merged[merged.length >> 1];
        else
            ret = (merged[merged.length >> 1] + merged[(merged.length >> 1) - 1]) / 2;
    }
    
    return ret;
};
