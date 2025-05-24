        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer(x);
            if (pq.size() == k + 1) {
                pq.poll();
            }
        }
        return pq.peek();
