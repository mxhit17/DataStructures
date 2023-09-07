public class BackTracking {
    
    public static void printAry(int ary[]){
        for(int i = 0; i < ary.length; i++){
            System.out.print(ary[i] + " ");
        }
        System.out.println();
    }
    public static void changeAry(int ary[], int i, int val){
        if(i == ary.length){
            printAry(ary);
            return;
        }

        //recurrsion
        ary[i] = val;
        changeAry(ary, i+1, val+1);

        //backtracking
        ary[i] = ary[i] - 2;
    }


    public static void findSubsets(String str, String ans, int i){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        //recurrsion
        //Yes Choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //NO Choice
        //backtracking
        findSubsets(str, ans, i+1);

    }


    public static void findPermutation(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //recursion
        for(int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            //"abcde" => "ab" + "de" = "abde"
            String newStr = str.substring(0, i) + str.substring(i+1, str.length());
            findPermutation(newStr, ans+current);
            
        }
    }


    public static void print2DAry(char[][] board){
        System.out.println("----------Chess Board----------");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        //vertically up
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonally left
        for(int i = row - 1, j = col - 1; i >= 0 && j >=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonally right
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
        }
        return true;
    }

    static int countWays = 0;

    public static boolean nQueens(char board[][], int row){
        //base case
        if(row == board.length){
            // print2DAry(board);
            countWays++;
            return true;
        }

        for(int j = 0; j < board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueens(board, row+1)){
                    return true;
                }
                board[row][j] = 'x';//backtracking step
            }
        }
        return false;

    }


    public static int gridWays(int i, int j, int n, int m){
        //base case, corner cases
        if(i == n-1 && j == m-1){
            return 1;
        }else if(i == n || j == m){
            return 0;
        }

        //recursion
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;

    }


    public static void printSudoku(int ary[][]){
        System.out.println("--------Sudoku Solution--------");
        for(int i = 0; i < ary.length; i++){
            for(int j = 0; j < ary.length; j++){
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit){
        //chking row
        for(int i = 0; i <= 8; i++){
            if(sudoku[row][i] == digit){
                return false;
            }
        }

        //chking col
        for(int i = 0; i <= 8; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        //chking grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for(int i = sr; i <= sr+2; i++){
            for(int j = sc; j <= sc+2; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean solSudoku(int sudoku[][], int row, int col){
        //base case
        if(row == 9){
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if(nextCol == 9){
            nextRow = row + 1;
            nextCol = 0;
        }
        //recursion

        if(sudoku[row][col] != 0){
            return solSudoku(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9; digit++){
            if(isSafeSudoku(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(solSudoku(sudoku, nextRow, nextCol)){// solution exists
                    return true;
                } else {
                    sudoku[row][col] = 0;
                }

            }
        }
        return false;
    }


    public static void print2DAry(int ary[][], int n, int m){
        System.out.println("----------Rat in a Maze----------");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveMaze(int maze[][], int solutionMaze[][], int row, int col, int n, int m){
        //base corner cases
        if(row == n - 1 && col == m - 1){
            solutionMaze[row][col] = 1;
            print2DAry(solutionMaze, n, m);
            return;
        }else if(row == n || col == m || maze[row][col] == 0){
            return;
        }

        //recursion
        solutionMaze[row][col] = 1;

        solveMaze(maze, solutionMaze, row+1, col, n, m);
        solveMaze(maze, solutionMaze, row, col+1, n, m);

        solutionMaze[row][col] = 0;
    }
    public static void main(String[] args) {
        // int ary[] = new int[5];
        // changeAry(ary, 0, 1);
        // printAry(ary);


        // String str = "abcd";
        // String ans = "";
        // findSubsets(str, ans, 0);


        // String str = "abc";
        // String ans = "";
        // findPermutation(str, ans);


        // int n = 4;
        // char board[][] = new char[n][n];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         board[i][j] = 'x';
        //     }
        // }
        // if(nQueens(board, 0)){
        //     System.out.println("Solutions exist.");
        //     print2DAry(board);
        // }else{
        //     System.out.println("No Solutions");
        // }
        // System.out.println("Total solutions of N-Queens : " + countWays);


        // int n = 3, m = 3;
        // System.out.println(gridWays(0, 0, n, m));


        // int sudoku[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
        //                   {5, 2, 0, 0, 0, 0, 0, 0, 0},
        //                   {0, 8, 7, 0, 0, 0, 0, 3, 1},
        //                   {0, 0, 3, 0, 1, 0, 0, 8, 0},
        //                   {9, 0, 0, 8, 6, 3, 0, 0, 5},
        //                   {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        //                   {1, 3, 0, 0, 0, 0, 2, 5, 0},
        //                   {0, 0, 0, 0, 0, 0, 0, 7, 4},
        //                   {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        // if(solSudoku(sudoku, 0, 0)){
        //     System.out.println("Solution Possible.");
        //     printSudoku(sudoku);
        // }else{
        //     System.out.println("Solution doesnt exists.");
        // }


        //Rat in a maze problem
        // int maze[][] = {{1, 0, 0, 0},
        //                 {1, 1, 1, 1},
        //                 {0, 0, 1, 0},
        //                 {1, 1, 1, 1}};

        // int m = maze[0].length;
        // int n = maze.length;

        // int solutionMaze[][] = new int[n][m];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         solutionMaze[i][j] = 0;
        //     }
        // }

        // solveMaze(maze, solutionMaze, 0, 0, n, m);
    }
}
