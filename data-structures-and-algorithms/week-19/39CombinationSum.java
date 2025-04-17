class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int j = nums.length - 1 - i;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, target, nums, currentList, results);
        return results;
    }
 
    private void backtrack(
        int position, int target,
        int[] nums,
        List<Integer> currentList, 
        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        if (position == nums.length) {
            return;
        }

        // Case 1: Don't use the current number, move forward
        backtrack(position + 1, target, nums, currentList, results);
        // Case 2: Use the current number X times, move forward
        int currentNumber = nums[position];
        for (int x = 1; x <= target / currentNumber; x++) {
            for (int i = 0; i < x; i++) {
                currentList.add(currentNumber);
            }
            backtrack(position + 1, target - x * currentNumber, nums, currentList, results);
            for (int i = 0; i < x; i++) {
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
 
