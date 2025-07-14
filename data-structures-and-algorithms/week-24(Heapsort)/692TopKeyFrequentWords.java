class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
          
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (a.getValue() == b.getValue() ? // if frequencies are equal
                       b.getKey().compareTo(a.getKey()) : // put lexicographically larger first
                       a.getValue() - b.getValue()) // otherwise, least frequent to the front
        );
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if (pq.size() == k + 1) { // if priority queue size got to k+1
                // Remove least frequent and lexicographically largest string to leave only k
                pq.poll();
            }
        }
 
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        
        return result;
    }
}
