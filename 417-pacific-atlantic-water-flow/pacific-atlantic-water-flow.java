class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==0 || heights[0].length==0){
            return new ArrayList<>();
        }
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] atlantic=new boolean[row][col];
        boolean[][] pacific=new boolean[row][col];

        for(int i=0;i<row;i++){
            dfs(i,0,pacific,heights);
            dfs(i,col-1,atlantic,heights);
        }
        for(int i=0;i<col;i++){
            dfs(0,i,pacific,heights);
            dfs(row-1,i,atlantic,heights);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(List.of(i,j));
                }
            }

        }
         return res;
    }
    private static void dfs(int row,int col,boolean[][] reach,int[][] heights){
       int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
       reach[row][col]=true;

       for(int[] dir:dirs){
       int newRow=row+dir[0];
       int newCol=col+dir[1];
          if(newRow<0 || newRow>=heights.length || newCol<0 || newCol>=heights[0].length){
            continue;
          }
          if(reach[newRow][newCol]){
            continue;
          }
          if(heights[newRow][newCol]>=heights[row][col]){
            dfs(newRow,newCol,reach,heights);
          }

       }
    }
}