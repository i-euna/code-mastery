class Solution {
    public boolean isPalindrome(int x) {
        String xStr = Integer.toString(x);
        int pt1 = 0;
        int pt2 = xStr.length() - 1;

        boolean isPalin = true;

        while(pt1 < pt2) {
            if(xStr.charAt(pt1) != xStr.charAt(pt2)) {
                isPalin = false;
                break;
            }
            pt1++;
            pt2--;
        }
        return isPalin;
    }
}