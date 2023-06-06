class Result {

    public static int[] selectionSort(int[] n) {
         for(int i = 0; i < nums.length - 1; i++) {
            int minPointer = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minPointer]) {
                    minPointer = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minPointer];
            nums[minPointer] = temp;
        }
        return nums;
    }

}