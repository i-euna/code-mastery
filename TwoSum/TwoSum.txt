class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            int diff = target - nums[i];
            if(hm.containsKey(diff)) {
                return new int[]{i, hm.get(diff)};
            }
            hm.put(nums[i], i);
        }
        return new int[2];
    }
}