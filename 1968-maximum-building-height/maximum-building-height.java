class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
      Arrays.sort(restrictions,(a,b)->Integer.compare(a[0],b[0]));
      int len=restrictions.length;
      if(len==0){
        return n-1;
      }  
      boolean isLast=restrictions[len-1][0]==n;
      int m=len+1+(isLast?0:1);
      int height[][]=new int[m][2];
      height[0][0]=1;
      height[0][1]=0;
      for(int i=0;i<len;i++){
        int diff=restrictions[i][0]-height[i][0];
        int ht=height[i][1]+diff;

        height[i+1][0]=restrictions[i][0];
        height[i+1][1]=Math.min(ht,restrictions[i][1]);

      }

      if(!isLast){
        int diff=n-height[len][0];
        int ht=height[len][1]+diff;
        height[len+1][0]=n;
        height[len+1][1]=Math.min(ht,n-1);

      }
      for(int i=m-2;i>=0;i--){
        int diff=height[i+1][0]-height[i][0];
        int ht=height[i+1][1]+diff;
        height[i][1]=Math.min(ht,height[i][1]);
      }
      int ans=0;
      for(int i=1;i<m;i++){
        int left=height[i-1][0];
        int right=height[i][0];
        int h1=height[i-1][1];
        int h2=height[i][1];

        int max=(right-left+h1+h2)/2;
        ans=Math.max(ans,max);
      }
      return ans;
    }
}