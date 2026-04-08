class Solution {
    static int max;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        max=0;
        int row=grid.length;
        int col=grid[0].length;
    
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    
                    int area=dfs(i,j,grid);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
    public int dfs(int row,int col,int[][] grid){
        int newRow=grid.length;
        int newCol=grid[0].length;

        int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        if(row<0 || col<0 || row>=newRow || col>=newCol || grid[row][col]==0){
            return 0;
        }
        int area=1;
        grid[row][col]=0;
        for(int[] dir:directions){
           area+=dfs(row+dir[0],col+dir[1],grid);
        }
        return area;
    }
}