class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int leftProduct = nums[0];
        result[0] = 1;
        int rightProduct = nums[len - 1];
		
        for(int i = 1; i < len; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for(int i = len - 2; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}