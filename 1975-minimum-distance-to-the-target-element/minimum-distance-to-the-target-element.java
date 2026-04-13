class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int out=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                out=Math.min(out,Math.abs(i-start));
                
            }
        }
        return out;
    }
}