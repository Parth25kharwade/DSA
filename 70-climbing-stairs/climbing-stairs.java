class Solution {
    static int dp[];
    public int climbStairs(int n) {
        dp=new int[n+1];
        return solve(n);
    }
    int solve(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int left=solve(n-1);
        int right=solve(n-2);
        dp[n]=left+right;
        return dp[n];
    }
}