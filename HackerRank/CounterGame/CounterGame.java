class Result {

    public static String counterGame(long n) {
        String won = (Long.bitCount(n-1) & 1) == 0 ? "Richard" : "Louise";
        return won;
    }

}