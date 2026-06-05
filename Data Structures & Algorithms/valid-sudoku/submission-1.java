class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rowCool = validateRows(board);
        boolean colCool = validateCols(board);
        boolean boxesCool = validateBoxes(board);
        return rowCool && colCool && boxesCool;
    }

    boolean validateRows(char[][] board) {
        /*
        1. iterate each row. 
        2. maintain a set of seen chars
        3. return false if dupe is found
        4. return true.
        */
        for(int i=0;i<board.length;i++) {
            if(!validateRow(board[i])) {
                System.out.println("row " + i + " is not cool.");
                return false;
            }
        }
        return true;
    }

    boolean validateRow(char[] row) {
        Set<Character> set = new HashSet<>();
        for(char c : row) {
            if(c == '.') continue;
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }

    boolean validateCols(char[][] board) {
        /*
        1. iterate each col. 
        2. maintain a set of seen chars
        3. return false if dupe is found
        4. return true.
        */
        for(int i=0;i<board.length;i++) {
            if(!validateCol(board, i)) {
                System.out.println("col " + i + " is not cool.");
                return false;
            }
        }
        return true;
    }

    boolean validateCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            if(board[i][col] == '.') continue;
            if(set.contains(board[i][col])) return false;
            set.add(board[i][col]);
        }
        return true;
    }

    boolean validateBoxes(char[][] board) {
        /*
        1. iterate each box. 
        2. maintain a set of seen chars
        3. return false if dupe is found
        4. return true.
        */
        for(int i=0;i<board.length;i+=3) {
            for(int j=0;j<board.length;j+=3) {
                // System.out.println("i="+i+ " j="+j);
                if(!validateBox(board, i,j)) return false;
            }
        }
        return true;
    }

    boolean validateBox(char[][] board, int rowStart, int colStart) {
        Set<Character> set = new HashSet<>();
        for(int i=rowStart;i<rowStart+3;i++) {
            for(int j=colStart;j<colStart+3;j++) {
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) {
                    System.out.println("box i="+i + " j="+j+ " is not cool");
                    return false;
                    }
                set.add(board[i][j]);
            }
        }
        return true;
    }
}
