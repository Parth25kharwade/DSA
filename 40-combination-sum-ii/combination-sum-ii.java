class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int[] arr, int target,
                           List<Integer> temp,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            if (i > start && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            temp.add(arr[i]);

            backtrack(i + 1, arr, target - arr[i], temp, result);

   
            temp.remove(temp.size() - 1);
        }
    }
}
  