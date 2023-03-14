
class Result {

    public static int lonelyinteger(List<Integer> a) {
        HashMap<Integer, Integer> integers = new HashMap<>();
        for(int i = 0; i < a.size(); i++) {
            if(integers.containsKey(a.get(i))) {
                Integer count = integers.get(a.get(i));
                count++;
                integers.put(a.get(i), count);
            } else {
                integers.put(a.get(i), 1);
            }
        }
        return integers.entrySet().stream()
        .filter(x -> x.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList()).get(0);
        
    }

}

