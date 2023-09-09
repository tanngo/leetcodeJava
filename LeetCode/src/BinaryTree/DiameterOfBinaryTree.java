package BinaryTree;
//https://leetcode.com/problems/diameter-of-binary-tree/description/

 //Definition for a binary tree node.

public class DiameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws Exception {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root,res);
        return res[0];
    }
    public int dfs(TreeNode root, int []res){
        if (root ==null) return -1;
        int left = dfs(root.left, res);
        int right = dfs(root.right,res);
        res[0] = Math.max(res[0],left+right+2);
        return 1+ Math.max(left,right);
    }
}
