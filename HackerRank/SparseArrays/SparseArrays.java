
class Result {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> counts = new ArrayList<>();
        
        for(int i = 0; i < queries.size(); i++) {
            String query = queries.get(i);
            int count = 0;
            for(int j = 0; j < strings.size(); j++) {
                if(strings.get(j).compareTo(query) == 0)
                    count++;
            }
            counts.add(count);
        }
        
        return counts;
    }

}