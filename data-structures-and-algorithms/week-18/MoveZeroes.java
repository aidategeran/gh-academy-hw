class Solution {
    public void moveZeroes(int[] nums) {
        if (nums==null || nums.length==0) {
            return;
        }

        int insertPosition = 0;
        for (int x:nums){
            if (x!=0){
                nums[insertPosition]=x;
                insertPosition ++;
            }
        }

        for(; insertPosition < nums.length; insertPosition ++){
            nums[insertPosition]=0;

        }
        
    }
}
