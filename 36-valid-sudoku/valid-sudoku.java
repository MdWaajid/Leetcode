class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            boolean[] col = new boolean[10];

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    if (row[n]) return false;
                    row[n] = true;
                }

                if (board[j][i] != '.') {
                    int n = board[j][i] - '0';
                    if (col[n]) return false;
                    col[n] = true;
                }
            }
        }

        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {

                boolean[] box = new boolean[10];

                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {

                        if (board[i][j] != '.') {
                            int n = board[i][j] - '0';

                            if (box[n]) return false;

                            box[n] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}