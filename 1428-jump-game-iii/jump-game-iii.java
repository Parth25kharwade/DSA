class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // already visited
            if (arr[curr] < 0) {
                continue;
            }

            // found zero
            if (arr[curr] == 0) {
                return true;
            }

            int jump = arr[curr];

            // mark visited
            arr[curr] = -arr[curr];

            // forward jump
            if (curr + jump < arr.length) {
                queue.add(curr + jump);
            }

            
            if (curr - jump >= 0) {
                queue.add(curr - jump);
            }
        }

        return false;
    }
}