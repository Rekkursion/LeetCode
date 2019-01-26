// 49. Group Anagrams
// Accepted 26ms

class Solution {
    private String toSortedString(String s) {
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        
        for(String str: strs) {
            String sortedStr = toSortedString(str);
            
            if(map.containsKey(sortedStr))
                map.get(sortedStr).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        
        for(Map.Entry<String, List<String>> entry: map.entrySet())
            ret.add(entry.getValue());
        
        return ret;
    }
}
