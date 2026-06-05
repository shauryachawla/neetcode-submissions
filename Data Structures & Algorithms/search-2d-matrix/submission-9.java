class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] foundRow = foundRow(matrix, target);
        if(foundRow == null) return false;
    
        return findTarget(foundRow, target);
    }

    int[] foundRow(int[][] matrix, int target) {
        // return the row that might contain the target. 
        int start = 0;
        int end = matrix.length-1;
        return foundRow(matrix, target, start, end);
    }

    int[] foundRow(int[][] matrix, int target, int start, int end) {
        int mid = start + ((end-start)/2);
        System.out.println("Start= "+ start + " End= " + end + " Mid= " + mid);
        int[] midRow = matrix[mid];
        if(start == end) {
            if(target >= midRow[0] && target <= midRow[midRow.length-1]){
                System.out.println("Found target between Start=" + start + " End= " + end);
                return midRow;
            }
            System.out.println("Couldn't find target between " + midRow[0] + " and " + midRow[midRow.length-1]);
            return null;
        }
        if(target > midRow[midRow.length-1])
            return foundRow(matrix, target, mid+1, end);
        else return foundRow(matrix, target, start, mid);
    }

    boolean findTarget(int[] row, int target) {
        return findTarget(row, target, 0, row.length-1);
    }

    boolean findTarget(int[] row, int target, int start, int end) {
        int mid = start + ((end-start)/2);
        if(start == end) {
            if(row[mid] == target) 
                return true;
            return false;
        }
        if(target > row[mid]) 
            return findTarget(row, target, mid + 1, end);
        else
            return findTarget(row, target, start, mid);
    }

    
}
