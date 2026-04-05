class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'.');
        }
        List<List<String>> res=new ArrayList<>();
        backtrack(res,board,0);
        return res;
    }
    public void backtrack(List<List<String>> res,char[][] board,int col){
        if(col==board.length){
            res.add(construct(board));
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isVallid(board,i,col)){
                board[i][col]='Q';
                backtrack(res,board,col+1);
                board[i][col]='.';
            }
        }

    }
    private boolean isVallid(char[][] board,int row,int col){
        for(int i=0;i<board.length;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> result=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row=new String(board[i]);
            result.add(row);
        }
        return result;
    }
} 