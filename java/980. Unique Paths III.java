// 980. Unique Paths III
// Accepted 8ms

class Solution {
    private class Node {
        int step;
        int r;
        int c;
        boolean[][] visited;
        
        Node() {}
        Node(int r, int c, int m, int n) { this.r = r; this.c = c; visited = new boolean[m][n]; visited[r][c] = true; step = 1; }
        Node(int r, int c, boolean[][] v, int s) {
            this.r = r; this.c = c; visited = new boolean[v.length][v[0].length]; step = s;
            for(int k = 0; k < v.length; ++k) {
                for(int j = 0; j < v[k].length; ++j)
                    visited[k][j] = v[k][j];
            }
            visited[r][c] = true;
        }
    }
    
    private int findPath(ArrayDeque<Node> que, final int PATHLEN, final int[][] MAP) {
        int ret = 0;
        Node cur;
        
        while(!que.isEmpty()) {
            cur = que.poll();
            
            if(cur.step == PATHLEN) {
                if(MAP[cur.r][cur.c] == 2)
                    ++ret;
                continue;
            }
            
            if(cur.r - 1 >= 0 && !cur.visited[cur.r - 1][cur.c]) {
                // general road
                if(MAP[cur.r - 1][cur.c] == 0) {
                    que.offer(new Node(cur.r - 1, cur.c, cur.visited, cur.step + 1));
                }
                // end point
                else if(MAP[cur.r - 1][cur.c] == 2 && cur.step + 1 == PATHLEN)
                    ++ret;
            }
            if(cur.c + 1 < MAP[cur.r].length && !cur.visited[cur.r][cur.c + 1]) {
                // general road
                if(MAP[cur.r][cur.c + 1] == 0) {
                    que.offer(new Node(cur.r, cur.c + 1, cur.visited, cur.step + 1));
                }
                // end point
                else if(MAP[cur.r][cur.c + 1] == 2 && cur.step + 1 == PATHLEN)
                    ++ret;
            }
            if(cur.r + 1 < MAP.length && !cur.visited[cur.r + 1][cur.c]) {
                // general road
                if(MAP[cur.r + 1][cur.c] == 0) {
                    que.offer(new Node(cur.r + 1, cur.c, cur.visited, cur.step + 1));
                }
                // end point
                else if(MAP[cur.r + 1][cur.c] == 2 && cur.step + 1 == PATHLEN)
                    ++ret;
            }
            if(cur.c - 1 >= 0 && !cur.visited[cur.r][cur.c - 1]) {
                // general road
                if(MAP[cur.r][cur.c - 1] == 0) {
                    que.offer(new Node(cur.r, cur.c - 1, cur.visited, cur.step + 1));
                }
                // end point
                else if(MAP[cur.r][cur.c - 1] == 2 && cur.step + 1 == PATHLEN)
                    ++ret;
            }
        }
        
        return ret;
    }
    
    public int uniquePathsIII(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        ArrayDeque<Node> que = new ArrayDeque<>();
        int pathLen = 2, ret;
        
        for(int k = 0; k < grid.length; ++k) {
            for(int j = 0; j < grid[k].length; ++j) {
                if(grid[k][j] == 1)
                    que.offer(new Node(k, j, grid.length, grid[k].length));
                else if(grid[k][j] == 2) {}
                else if(grid[k][j] == 0)
                    ++pathLen;
            }
        }
        
        ret = findPath(que, pathLen, grid);
        
        return ret;
    }
}
