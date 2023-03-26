class Result {

    public static long sumXor(long n) {
        long count = 1;
        
        while(n > 0) {
            if((n & 1) == 0) {
                count = count << 1;
            }
            n = n >> 1;
        }
        
        return count;
    }

}