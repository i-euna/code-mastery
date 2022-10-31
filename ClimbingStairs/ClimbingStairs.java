class Solution {
    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int step1 = 1;
        int step2 = 2;
        int noOfSteps = 0;
        for(int i = 3; i <= n; i++) {
            noOfSteps = step1;
            step1 = step2;
            step2 += noOfSteps;
        }
        return step2;
    }
}