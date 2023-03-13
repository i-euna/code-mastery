class Result {

    public static void plusMinus(List<Integer> arr) {
        int negNumCount = 0;
        int posNumCount = 0;
        int zeroCount = 0;
        // Write your code here
        for(int i = 0; i < arr.size();i++) {
            if(arr.get(i) < 0)
                negNumCount++;
            else if (arr.get(i) > 0)
                    posNumCount++;
                 else zeroCount++;
        }
        float negRatio = (float)negNumCount / arr.size();
        float posRatio = (float)posNumCount / arr.size();
        float zeroRatio = (float)zeroCount / arr.size();
        System.out.printf("%.6f\n", posRatio);
        System.out.printf("%.6f\n", negRatio);
        System.out.printf("%.6f\n", zeroRatio);
    }

}