class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:stones){
            heap.offer(n);
        }
        int ans=stones[0];
        while(heap.size()>1){
            int a=heap.poll();
            int b=heap.poll();

            if(a!=b){
            ans=Math.abs(a-b);
             heap.offer(ans);
            }
            
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}