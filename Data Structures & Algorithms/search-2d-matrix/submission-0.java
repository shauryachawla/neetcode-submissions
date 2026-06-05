class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // row identification. 
        // finding the target if row found. 
        boolean exists = false;
        int[] foundRow = findRow(matrix, target);
        if(foundRow != null)
            exists = findTarget(foundRow, target);
        return exists;
    }

    public int[] findRow(int[][] matrix, int target) {
        int x=0, y=matrix[0].length-1;
        for(int[] row : matrix) {
            if(row[x] <= target && row[y] >= target)
                return row;
        }
        return null;
    }

    public boolean findTarget(int[] row, int target) {
        // int x=0, y = row.length;
        for(int x: row) {
            if(x == target) return true;
        }
        return false;
    }
}
