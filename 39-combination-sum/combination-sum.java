class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0,candidates, target, new ArrayList<>(), res);
        return res;        
    }

    private void backtrack(int start, int[] arr, int target, List<Integer> temp, List<List<Integer>> result) {
    if (target == 0) {
        result.add(new ArrayList<>(temp));
        return;
    }

    for (int i = start; i < arr.length; i++) {
        if (arr[i] > target) continue;

        temp.add(arr[i]);
        backtrack(i, arr, target - arr[i], temp, result); // reuse allowed
        temp.remove(temp.size() - 1);
    }
}
}