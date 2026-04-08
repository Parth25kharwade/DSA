class Solution {
    static int dp[][];
    public String longestPalindrome(String s) {
        int index=0;
        int maxLen=0;
        String rev=new StringBuilder(s).reverse().toString();
        int n=s.length();
        if(n==1){
            return s;
        }
        dp=new int[n+1][n+1];
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    int originalIndex=i-1;
                    int reversedIndex=n-j;

                    if(originalIndex-dp[i][j]+1==reversedIndex){
                        if(dp[i][j]>maxLen){
                            maxLen=dp[i][j];
                            index=i-1;
                        }
                    }

                }else{
                    dp[i][j]=0;
                }
            }
        }
        return s.substring(index-maxLen+1,index+1);
    }
}