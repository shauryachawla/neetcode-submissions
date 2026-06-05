class Solution {
    int maxArea = 0;

    boolean validate(int[][] grid, int i, int j) {
        int maxHeight = grid.length-1;
        int maxWidth = grid[0].length - 1;
        if(i<0 || i>maxHeight) return false;
        if(j<0 || j> maxWidth) return false;
        return (grid[i][j] == 1);
    }
    
    int sinkIsland(int[][] grid, int i, int j) {
        if(!validate(grid, i , j)) return 0;
        grid[i][j] = 0;
        int area = 1;
        area += sinkIsland(grid, i-1, j);
        area += sinkIsland(grid, i+1, j);        
        area += sinkIsland(grid, i, j+1);
        area += sinkIsland(grid, i, j-1);
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    int curr = sinkIsland(grid, i, j);
                    maxArea = Math.max(maxArea, curr);
                }
            }
        }
        return maxArea;
    }
}
