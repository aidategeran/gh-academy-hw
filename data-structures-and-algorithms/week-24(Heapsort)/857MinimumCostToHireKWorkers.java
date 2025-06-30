class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; i++) {
            workers[i] = new double[]{
                w[i] * 1.0 / q[i],
                q[i] * 1.0
            };
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE;
        double qsum = 0; // the sum of the lowest k qualities
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (double[] worker : workers) {
            qsum += worker[1];
            pq.add(worker[1]);
 
            // Remove highest quality worker to minize price
            if (pq.size() == K + 1) qsum -= pq.poll();
            // total quality of k workers * highest wage/quality ratio = total pay for that group of k workers
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res; 
    }
}
