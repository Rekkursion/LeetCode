// 383. Ransom Note
// Accepted 14ms

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphas = new int[26];
        int total = ransomNote.length();
        
        for(int k = 0; k < ransomNote.length(); k++)
            alphas[ransomNote.charAt(k) - 'a']++;
        
        for(int k = 0; k < magazine.length(); k++) {
            if(alphas[magazine.charAt(k) - 'a'] > 0) {
                alphas[magazine.charAt(k) - 'a']--;
                total--;
            }
            
            if(total == 0)
                break;
        }
        
        return (total == 0);
    }
}
