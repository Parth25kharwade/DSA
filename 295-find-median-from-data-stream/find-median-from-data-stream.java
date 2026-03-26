class MedianFinder {

   private PriorityQueue<Integer> low;//max heap
   private PriorityQueue<Integer> high; //min heap
    public MedianFinder() {
        this.low=new PriorityQueue<>((a,b)->(b-a));
        this.high=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.offer(num);

        high.offer(low.poll());

        if(low.size()<high.size()){
            low.offer(high.poll());
        }

    }
    
    public double findMedian() {
        return low.size()>high.size()?low.peek():(low.peek()+high.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */