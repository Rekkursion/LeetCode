// 30. Substring with Concatenation of All Words
// Accepted 147ms

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words == null || words.length == 0)
            return new ArrayList<Integer>();
        if(Arrays.stream(words).anyMatch(""::equals))
            return Stream.iterate(0, i -> i + 1).limit(s.length() + 1).collect(Collectors.toList());
        
        int wordLen = words[0].length();
        int wordsLen = words.length;
        int totalWordsLen = wordLen * wordsLen;
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> dict = Arrays.stream(words).collect(Collectors.toMap(str -> str, 
                                                                                  str -> 1,
                                                                                  (odd, news) -> odd + news));
        Map<String, Integer> used = new HashMap<>(dict);
        
        for(int k = 0; k < s.length() - totalWordsLen + 1; ++k) {
            int cnt = 0, i = k, result;
            String sub = "";
            while(cnt < wordsLen) {
                sub = s.substring(i, i + wordLen);
                result = used.getOrDefault(sub, -1);
                if(result > 0)
                    used.put(sub, result - 1);
                else
                    break;
                ++cnt;
                i += wordLen;
            }
            
            if(used.values().stream().reduce(0, (x, y) -> x + y) == 0)
                ret.add(k);
            used = new HashMap<>(dict);
        }
        
        return ret;
    }
}
