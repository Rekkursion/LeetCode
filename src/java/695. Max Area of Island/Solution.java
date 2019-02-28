// 695. Max Area of Island
// Accepted 34ms

class Solution {
    private int calcArea(int[][] map, int k, int j) {
        class Pair {
            int r;
            int c;
            
            Pair() {}
            Pair(int x, int y) { r = x; c = y; }
        }
        
        int area = 0;
        ArrayDeque<Pair> que = new ArrayDeque<>();
        Pair curLoc;
        
        que.offer(new Pair(k, j));
        map[k][j] = 0;
        
        while(!que.isEmpty()) {
            curLoc = que.poll();
            
            ++area;
            
            if(curLoc.r - 1 >= 0 && map[curLoc.r - 1][curLoc.c] == 1) {
                map[curLoc.r - 1][curLoc.c] = 0;
                que.offer(new Pair(curLoc.r - 1, curLoc.c));
            }
            if(curLoc.c + 1 < map[curLoc.r].length && map[curLoc.r][curLoc.c + 1] == 1) {
                map[curLoc.r][curLoc.c + 1] = 0;
                que.offer(new Pair(curLoc.r, curLoc.c + 1));
            }
            if(curLoc.r + 1 < map.length && map[curLoc.r + 1][curLoc.c] == 1) {
                map[curLoc.r + 1][curLoc.c] = 0;
                que.offer(new Pair(curLoc.r + 1, curLoc.c));
            }
            if(curLoc.c - 1 >= 0 && map[curLoc.r][curLoc.c - 1] == 1) {
                map[curLoc.r][curLoc.c - 1] = 0;
                que.offer(new Pair(curLoc.r, curLoc.c - 1));
            }
        }
        
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int maxArea = 0;
        for(int k = 0; k < grid.length; ++k) {
            for(int j = 0; j < grid[k].length; ++j) {
                if(grid[k][j] == 1)
                    maxArea = Math.max(maxArea, calcArea(grid, k, j));
            }
        }
        
        return maxArea;
    }
}
