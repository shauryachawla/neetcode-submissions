class Solution {
    int rows = 0;
    int cols = 0;

    void dfs(int row, int col, int prevHeight, Set<List<Integer>> visited, int[][] heights) {
        if(visited.contains(List.of(row, col)) || row < 0 || row == rows || col < 0 || col == cols || heights[row][col] < prevHeight) return;
        visited.add(List.of(row, col));
        dfs(row-1, col, heights[row][col], visited, heights);
        dfs(row+1, col, heights[row][col], visited, heights);
        dfs(row, col-1, heights[row][col], visited, heights);
        dfs(row, col+1, heights[row][col], visited, heights);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        Set<List<Integer>> atl = new HashSet<>();
        Set<List<Integer>> pac = new HashSet<>();
        for(int c=0;c<cols;c++) {
            dfs(0, c, heights[0][c], pac, heights);
            dfs(rows-1, c, heights[rows-1][c], atl, heights);
        }
        for(int r=0;r<rows;r++) {
            dfs(r, 0, heights[r][0], pac, heights);
            dfs(r, cols-1, heights[r][cols-1], atl, heights);
        }
        atl.retainAll(pac);
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> pair: atl) {
            result.add(pair);
        }
        return result;
    }
}
