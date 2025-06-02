class KthLargest {
    PriorityQueue<Integer> topK;
    int K;

    public KthLargest(int k, int[] nums) {
        topK = new PriorityQueue<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= Math.max(n - k, 0); i--) {
            topK.offer(nums[i]);
        }
        K = k;
        // k = 1, []
        // add(2)
    }
    
    public int add(int val) {
        if (topK.size() < K) {
            topK.offer(val);
        } else if (val >= topK.peek()) {
            topK.poll();
            topK.offer(val);
        }
        return topK.peek();
    }
}
