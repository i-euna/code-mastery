class Result {

    public static int[] sort(int[] n) {
         for(int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key) {
                nums[j+1]=nums[j];
                j--;
            }

            nums[j+1] = key;
        }
        return nums;
    }

}