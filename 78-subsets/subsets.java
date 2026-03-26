class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(0,nums,new ArrayList<>(),res);
        return res;
    }
    private void dfs(int i,int[] nums,List<Integer> current,List<List<Integer>> res){
        res.add(new ArrayList<>(current));
        for(int j=i;j<nums.length;j++){
            current.add(nums[j]);
            dfs(j+1,nums,current,res);
            current.remove(current.size()-1);
        }
    }
}