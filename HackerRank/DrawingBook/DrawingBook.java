class Result {

    public static int pageCount(int n, int p) {
        int sheets1ToP = p / 2;
        int sheetsNToP = (n / 2) - sheets1ToP;
        return Math.min(sheets1ToP, sheetsNToP);
    }

}