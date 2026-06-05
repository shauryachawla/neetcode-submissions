class Solution {
    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    sinkSurrounding(grid, i, j);
                }
            }
        }
        return result;
    }

    public static void sinkSurrounding(char[][] grid, int i, int j) {
//        if (!validate(grid, i, j))
//            return;
        grid[i][j] = '0';
        if (validate(grid, i, j + 1)) // right
            sinkSurrounding(grid, i, j + 1);
        if (validate(grid, i, j - 1)) // left
            sinkSurrounding(grid, i, j - 1);
        if (validate(grid, i - 1, j)) // top
            sinkSurrounding(grid, i - 1, j);
        if (validate(grid, i + 1, j)) // bottom
            sinkSurrounding(grid, i + 1, j);
    }

    public static boolean validate(char[][] grid, int i, int j) {

        int maxHeight = grid.length - 1;
        int maxWidth = grid[0].length - 1;
        // oopar se
        // neeche se
        if (i < 0 || i > maxHeight) return false;
        // left se
        // right se
        if (j < 0 || j > maxWidth) return false;
        // value
        return grid[i][j] != '0';
    }
}
