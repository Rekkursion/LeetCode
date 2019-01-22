// 58. Length of Last Word
// Accepted 3ms

class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - (s.trim().lastIndexOf(' ') + 1);
    }
}
