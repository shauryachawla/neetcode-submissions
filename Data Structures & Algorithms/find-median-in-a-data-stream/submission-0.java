class MedianFinder {
    PriorityQueue <Integer> smallHeap;
    PriorityQueue <Integer> largeHeap;
    

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        /*
        1. add to small help.
        2. check if a) sizes are approx equal b) max(small) <= min(large)
        3. if
        */
        smallHeap.add(num);
        if(!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            int temp = largeHeap.poll();
            largeHeap.add(smallHeap.poll());
            smallHeap.add(temp);
        }
        if(smallHeap.size() - largeHeap.size() > 1) {
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()) {
            return (double) ((smallHeap.peek() + largeHeap.peek()) / 2.0);
        } 
        if(smallHeap.size() < largeHeap.size()) {
            return (double) largeHeap.peek();
        }
        if(largeHeap.size() < smallHeap.size()) {
            return (double) smallHeap.peek();
        }
        return 0.0;
    }
}
