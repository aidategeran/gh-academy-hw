class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] in_subset = new boolean[nums.length];
        backtrack(0, in_subset, nums, results);
        return results;
    }
 
    // [1, 2, 3]
 
    //  1) [F, F, F, F] -> {}
    //  2) [F, F, F, T] -> {3}
    //  3) [F, F, T, F] -> {2}
    //  4) [F, F, T, T] -> {2, 3}
    //  5) [F, T, F, F] -> {1}
    //  6) [F, T, F, T] -> {1, 3}
    //  7) [F, T, T, F] -> {1, 2}
    //  8) [F, T, T, T] -> {1, 2, 3}
    //  9) [T, F, F, F] -> {0}
    // 10) [T, F, F, T] -> {0, 3}
    // 11) [T, F, T, F] -> {0, 2}
    // 12) [T, F, T, T] -> {0, 2, 3}
    // 13) [T, T, F, F] -> {0, 1}
    // 14) [T, T, F, T] -> {0, 1, 3}
    // 15) [T, T, T, F] -> {0, 1, 2}
    // 16) [T, T, T, T] -> {0, 1, 2, 3}
 
    //              *
    //  0  1  2  3 
    // [a, b, c, d]
    // [_, _, _, _]  
 
    private void backtrack(int position, boolean[] in_subset, int[] nums, List<List<Integer>> results) {
        if (position == nums.length) { // base case
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (in_subset[i]) {
                    currentList.add(nums[i]);
                }
            }
            results.add(currentList);
            return;
        }
        // Looking at nums[position]
        // Case 1: I don't take number nums[position] into the current subset
        in_subset[position] = false;
        backtrack(position + 1, in_subset, nums, results);
        // Case 2: I take number nums[position] into the current subset
        in_subset[position] = true;
        backtrack(position + 1, in_subset, nums, results);
    }
}
