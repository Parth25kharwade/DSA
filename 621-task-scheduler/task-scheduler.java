class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->(b-a));
        minHeap.addAll(map.values());

        int time=0;
        while(!minHeap.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!minHeap.isEmpty()){
                    temp.add(minHeap.poll());
                }
            }
            for(int freq:temp){
                if(--freq>0){
                    minHeap.offer(freq);
                }
            }
            time+=minHeap.isEmpty()?temp.size():n+1;
        }
        return time;
    }
}