class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ret = new int[2];
        maxPathSum(root, ret);
        return ret[0];
    }
    /**
     * get max path sum
     * @param node
     * @param ret, mutable array for return values
     *      ret[0] any path
     *      ret[1] path that ends at current node
     */
    private void maxPathSum(TreeNode node, int[] ret) {
        int[] leftRet = new int[2];
        int[] rightRet = new int[2];
        if (node == null) return;
        ret[0] = ret[1] = node.val;
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            maxPathSum(node.left, leftRet);
            ret[0] = Math.max(ret[0], leftRet[0]);
            ret[1] = Math.max(ret[1], node.val + leftRet[1]);
        }
        if (node.right != null) {
            maxPathSum(node.right, rightRet);
            ret[0] = Math.max(ret[0], rightRet[0]);
            ret[1] = Math.max(ret[1], node.val + rightRet[1]);
        }
        ret[0] = Math.max(ret[0], leftRet[1] + rightRet[1] + node.val);
        ret[0] = Math.max(ret[0], ret[1]);
        return;
    }
}