class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;

        while(high - low > 1) {
            mid = (low + high) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] == target) {
            return low;
        }
        else if (nums[high] == target) {
            return high;
        } else return -1;
    }
}