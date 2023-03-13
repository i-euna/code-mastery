class Solution {
    public int findMin(int[] nums) {
       int high = nums.length - 1, low = 0;
       int mid = -1;

       while(high - low > 1) {
           mid = (low + high) / 2;
           if(nums[high] > nums[mid])
               high = mid;
           else
               low = mid;
       }
       if(nums.length == 1)
           return nums[0];
       else if(nums.length == 2)
           return Math.min(nums[0], nums[1]);
       else {
           if(nums[mid] > nums[mid + 1])
               return nums[mid+1];
           else if(nums[mid - 1] < nums[mid])
               return nums[mid-1];
           else return nums[mid];
       }
    }
}