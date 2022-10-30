class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if((p == null && q != null) ||
          (q == null && p != null) ||
          p.val != q.val)
            return false;
        if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        else return false;
    }
}