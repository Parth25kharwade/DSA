class Solution {
    public void solve(char[][] board) {
     if(board==null || board[0].length==0){
        return;
     }   
     int m=board.length;
     int n=board[0].length;
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O'){
                dfs(board,i,j);
            }
        }
     }
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]=='O'){
                board[i][j]='X';
            }else if(board[i][j]=='T'){
                board[i][j]='O';
            }
        }
     }
    return;

    }
    private void dfs(char[][] board,int m,int n){
        if(m>=board.length || m<0 || n>=board[0].length || n<0 || board[m][n]!='O'){
            return;
        }
       
            board[m][n]='T';
        
        int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int[] dir:directions){
            int i=dir[0]+m;
            int j=dir[1]+n;

            dfs(board,i,j);
        }
        return;
    }
}