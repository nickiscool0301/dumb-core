//Given the root of a binary tree, return the inorder traversal of its nodes' values.

// recursive
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
  }

  public void helper(TreeNode root, List<Integer> listNode) {
    if(root != null) {
      helper(root.left, listNode);
      listNode.add(root.val);
      helper(root.right, listNode);
    }
  }
}


class IterativeSolution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();

  }

//iterative
