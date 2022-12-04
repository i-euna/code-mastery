class Solution {
    public int[] productExceptSelf(int[] nums) {
       int product = 1;
       int[] products = new int[nums.length];
       products[0] = 1;
       for(int i = 1; i < nums.length; i++) {
          products[i] = products[i - 1] * nums[i - 1];
       }
       for(int i = products.length - 1; i > -1; i--) {
          products[i] *= product;
          product *= nums[i];
       }
       
       return products;
    }
}