class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftTreeLength = maxDepth(root.left);
        int rightTreeLength = maxDepth(root.right);
        if(leftTreeLength > rightTreeLength)
            return 1 + leftTreeLength;
        else return 1 + rightTreeLength;
    }
}