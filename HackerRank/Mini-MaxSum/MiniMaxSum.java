class Result {

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long sum = arr.get(0);
        long largest = arr.get(0);
        long smallest = arr.get(0);
    
        for(int i = 1; i < arr.size(); i++) {
            sum += arr.get(i);
            if(arr.get(i) > largest)
                largest = arr.get(i);
            if(arr.get(i) < smallest)
                smallest = arr.get(i);
        }
        long min = sum - largest;
        long max = sum - smallest;
        System.out.print( min + " " + max);
    }

}