class Solution {
    
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        if (left[0] == 1 && right[0] == 1 && left[1] < node.val && node.val < right[2]) {
            int sum = left[3]+right[3]+node.val;
            maxSum = Math.max(maxSum, sum);
            return new int[]{1, Math.max(right[1], node.val), Math.min(left[2], node.val), sum}; 
        }
        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}
