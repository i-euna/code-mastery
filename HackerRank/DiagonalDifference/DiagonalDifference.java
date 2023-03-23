
class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftPointer = 0;
        int rightPointer = arr.size() - 1;
        int leftSum = 0;
        int rightSum = 0;
        
        for(int i = 0; i < arr.size(); i++) {
            List<Integer> innerArray = arr.get(i);
            leftSum += innerArray.get(leftPointer);
            rightSum += innerArray.get(rightPointer);
            
            leftPointer++;
            rightPointer--;
        }
        
        if(leftSum > rightSum)
            return leftSum - rightSum;
        else return rightSum - leftSum;
    }

}
