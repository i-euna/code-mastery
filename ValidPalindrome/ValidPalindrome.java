class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int pt1 = 0;
        int pt2 = s.length() - 1;
        boolean isPalindrome = true;
        while(pt1 < pt2) {
            if(!Character.isLetter(s.charAt(pt1)) && !Character.isDigit(s.charAt(pt1)))
            {
                pt1++;
                continue;
            }
            if(!Character.isLetter(s.charAt(pt2)) && !Character.isDigit(s.charAt(pt2)))
            {
                pt2--;
                continue;
            }
            if(s.charAt(pt1) != s.charAt(pt2))
            {
                isPalindrome = false;
                break;
            }
            pt1++;
            pt2--;

        }
        return isPalindrome;
    }
}