class Result {
	
    public static int sockMerchant(int n, List<Integer> ar) {
        int pairCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < ar.size(); i++) {
            if(map.containsKey(ar.get(i))) {
                pairCount++;
                map.remove(ar.get(i));
            } else
            map.put(ar.get(i), ar.get(i));
        }
        
        return pairCount;
    }

}