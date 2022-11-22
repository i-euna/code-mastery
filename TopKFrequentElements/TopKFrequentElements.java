class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] numbers = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(Integer.valueOf(nums[i]));
                count++;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }

        map = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Object[] keys = map.keySet().toArray();
        for(int i = 0; i < k; i++)
            numbers[i] = (int) keys[i];
        return numbers;
    }
}