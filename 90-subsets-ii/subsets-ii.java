class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,0,res,new ArrayList<>());
        return res;

    }
    void backtrack(int[] nums,int index,List<List<Integer>> res,List<Integer> temp){
       
            res.add(new ArrayList<>(temp));
        

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums,i+1,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}