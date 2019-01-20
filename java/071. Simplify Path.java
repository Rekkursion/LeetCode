// 71. Simplify Path
// Accepted 116ms

class Solution {
    public String simplifyPath(String path) {
        String[] levels = path.split("/{1,}");
        ArrayDeque<String> canonical = new ArrayDeque<>();
        StringBuffer sBuf = new StringBuffer();
        
        for(String level: levels) {
            if(level.equals("..")) {
                if(canonical.peekLast() != null)
                    canonical.pollLast();
            }
            
            else if(level.equals(".") || level.equals("")) {}
            
            else
                canonical.offerLast(level);
        }
        
        canonical.forEach(
            level -> sBuf.append("/" + level)
        );
        
        if(sBuf.length() == 0)
            sBuf.append("/");
        
        return sBuf.toString();
    }
}
