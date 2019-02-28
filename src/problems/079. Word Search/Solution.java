// 79. Word Search
// Accepted 27ms

class Solution {
    private boolean dfs(int r, int c, int sIdx, boolean[][] visited, char[][] map, String str) {
        if(sIdx == str.length()) {
            return true;
        }
        
        boolean found = false;
        //System.out.println(str.substring(0, sIdx));
        
        if(r - 1 >= 0 && map[r - 1][c] == str.charAt(sIdx) && !visited[r - 1][c]) {
            visited[r - 1][c] = true;
            found = dfs(r - 1, c, sIdx + 1, visited, map, str);
            visited[r - 1][c] = false;
        }
        if(!found && c + 1 < map[r].length && map[r][c + 1] == str.charAt(sIdx) && !visited[r][c + 1]) {
            visited[r][c + 1] = true;
            found = dfs(r, c + 1, sIdx + 1, visited, map, str);
            visited[r][c + 1] = false;
        }
        if(!found && r + 1 < map.length && map[r + 1][c] == str.charAt(sIdx) && !visited[r + 1][c]) {
            visited[r + 1][c] = true;
            found = dfs(r + 1, c, sIdx + 1, visited, map, str);
            visited[r + 1][c] = false;
        }
        if(!found && c - 1 >= 0 && map[r][c - 1] == str.charAt(sIdx) && !visited[r][c - 1]) {
            visited[r][c - 1] = true;
            found = dfs(r, c - 1, sIdx + 1, visited, map, str);
            visited[r][c - 1] = false;
        }
        
        return found;
    }
    
    private boolean findWord(int r, int c, char[][] map, String str) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[r][c] = true;
        
        return dfs(r, c, 1, visited, map, str);
    }
    
    public boolean exist(char[][] board, String word) {
        if(board == null)
            return false;
        if(word.length() == 0)
            return true;
        
        for(int k = 0; k < board.length; ++k) {
            for(int j = 0; j < board[k].length; ++j) {
                if(board[k][j] == word.charAt(0)) {
                    boolean isFound = findWord(k, j, board, word);
                    if(isFound)
                        return true;
                }
            }
        }
        
        return false;
    }
}
