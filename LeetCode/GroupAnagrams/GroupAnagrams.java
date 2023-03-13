class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfLists = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] sArray =  strs[i].toCharArray();
            Arrays.sort(sArray);
            String sortedString = String.valueOf(sArray);
            if(!map.containsKey(sortedString)) {
                List<String> listOfAnagrams = new ArrayList<>();
                listOfAnagrams.add(strs[i]);
                listOfLists.add(listOfAnagrams);
                map.put(sortedString, listOfLists.size() - 1);
            } else {
                int index = map.get(sortedString);
                listOfLists.get(index).add(strs[i]);
            }
        }
        return listOfLists;
    }
}