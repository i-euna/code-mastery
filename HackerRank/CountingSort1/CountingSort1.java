class Result {

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> counts = new ArrayList<>(Collections.nCopies(100, 0));
        for(int i = 0; i < arr.size(); i++) {
            int count = counts.get(arr.get(i));
            counts.set(arr.get(i), count + 1);
        }
        return counts;
    }

}