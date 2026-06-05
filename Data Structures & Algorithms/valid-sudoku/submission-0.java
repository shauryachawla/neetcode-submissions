class Solution {

    public boolean isValidSudoku(char[][] board) {

        boolean validRow = validateRowCondition(board);
        boolean validCol = validateColumnCondition(board);
        boolean validBox = validateBoxCondition(board);

        return validRow && validCol && validBox;
    }

    boolean validateRowCondition(char[][] board) {
        for(char[] row : board) {
            if(!validateRowCondition(row)) return false;
        }
        return true;
    }

    boolean validateRowCondition(char[] row) {
        Set<Character> set = new HashSet<>();
        for(var c : row) {
            if(set.contains(c)) {
                System.out.println("Found dupe: " + c + " during row validation.");
                return false;
            }
            if(c != '.')
                set.add(c);
        }
        return true;
    }

    boolean validateColumnCondition(char[][] board) {
        for(int j=0;j<9;j++) {
            Set<Character> set = new HashSet<>();
            for(int i=0;i<9;i++) {
                if(set.contains(board[i][j])) {
                    System.out.println("Found dupe: " + board[i][j] + " during col validaiton.");
                    return false;
                }
                if(board[i][j] != '.')
                    set.add(board[i][j]);
            }
        }
        return true;
    }

    boolean validateBoxCondition(char[][] board) {
        for(int i=0;i<9;i+=3) {
            for(int j=0;j<9;j+=3) {
                if(!validateBoxCondition(board, i, j)) return false;
            }
            
        }
        return true;
    }

    boolean validateBoxCondition(char[][] board, int rowStartIndex, int colStartIndex) {
        int rowEndIndex = rowStartIndex + 3;
        int colEndIndex = colStartIndex + 3;
        Set<Character> set = new HashSet<>();
        for(int i=rowStartIndex;i<rowEndIndex;i++) {
            for(int j=colStartIndex;j<colEndIndex;j++) {
                if(set.contains(board[i][j])) return false;
                if(board[i][j] != '.') set.add(board[i][j]);
            }
        }
        return true;
    }
}
