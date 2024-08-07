class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        //Empty nums.
        if (nums==null || n==0) return 0;

        // Just a single element.
        if (n==1) return nums[0];

        //Arrays was rotated n times => same as not rotated 
        if(nums[0]<nums[n-1]) return nums[0];


        int left = 0;
        int right = nums.length-1; 

        while (left<=right){
           int middle = (left+right)/2;

           if(middle > 0 && nums[middle-1]>nums[middle]) return nums[middle];
           
           if (nums[middle]>nums[right]) left = middle+1;
           else right = middle - 1;

        }
         return -1;
    }
}
