// 15. 3Sum
// Accepted 4543ms

class Solution {
    List<List<Integer>> ret = new ArrayList();
    
    // neg neg pos
    private void nnp(List<Integer> negs, List<Integer> poss) {
        int sum = 0, neg1, neg2;
        boolean dup = false;
        
        for(int k = 0; k < negs.size(); k++) {
            for(int j = k + 1; j < negs.size(); j++) {
                neg1 = negs.get(k);
                neg2 = negs.get(j);
                
                sum = -(neg1 + neg2);
                
                if(poss.contains(sum)) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(neg1);
                    newList.add(neg2);
                    newList.add(sum);
                    
                    dup = false;
                    for(List<Integer> it: ret) {
                        if(it.get(0) == neg1 && it.get(1) == neg2) {
                            dup = true;
                            break;
                        }
                    }
                    
                    if(!dup)
                        ret.add(newList);
                }
            }
        }
        
        return;
    }
    
    // neg pos pos
    private void npp(List<Integer> negs, List<Integer> poss) {
        int sum = 0, pos1, pos2;
        boolean dup = false;
        
        for(int k = 0; k < poss.size(); k++) {
            for(int j = k + 1; j < poss.size(); j++) {
                pos1 = poss.get(k);
                pos2 = poss.get(j);
                
                sum = -(pos1 + pos2);
                
                if(negs.contains(sum)) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(sum);
                    newList.add(pos1);
                    newList.add(pos2);
                    
                    dup = false;
                    for(List<Integer> it: ret) {
                        if(it.get(1) == pos1 && it.get(2) == pos2) {
                            dup = true;
                            break;
                        }
                    }
                    
                    if(!dup)
                        ret.add(newList);
                }
            }
        }
        
        return;
    }
    
    // neg zero pos
    private void nzp(List<Integer> negs, List<Integer> poss) {
        Set<Integer> used = new HashSet();
        
        for(int k = 0; k < negs.size(); k++) {
            if(poss.contains(-(negs.get(k))) && used.contains(negs.get(k)) == false) {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(negs.get(k));
                newList.add(0);
                newList.add(-negs.get(k));
                
                ret.add(newList);
                used.add(negs.get(k));
            }
        }
        
        return;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<Integer> negs = new ArrayList();
        List<Integer> poss = new ArrayList();
        int ans = 0;
        int zeroNum = 0;
        
        for(int k = 0; k < nums.length; k++) {
            if(nums[k] < 0)
                negs.add(nums[k]);
            else if(nums[k] > 0)
                poss.add(nums[k]);
            else
                zeroNum++;
        }
        
        // neg neg pos
        nnp(negs, poss);
        // neg pos pos
        npp(negs, poss);
        // neg zero pos
        if(zeroNum > 0)
            nzp(negs, poss);
        // { 0, 0, 0 }
        if(zeroNum >= 3) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(0);
            newList.add(0);
            newList.add(0);
            
            ret.add(newList);
        }
        
        return ret;
    }
}
