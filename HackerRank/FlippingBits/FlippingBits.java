
class Result {

    public static long flippingBits(long n) {
        String bin = Long.toBinaryString(n);
        if(bin.length() < 32) {
             StringBuilder sb = new StringBuilder();
             int zeros = 32 - bin.length();
             while (zeros > 0) {
                 sb.append("0");
                 zeros--;
             }
             bin  = sb.append(bin).toString();
        }
        bin = bin.replace('0', 'x').replace('1', '0').replace('x', '1');
        return Long.parseLong(bin, 2);
    }

}