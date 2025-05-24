class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            if (largest != secondLargest) {
                maxHeap.offer(largest - secondLargest);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
