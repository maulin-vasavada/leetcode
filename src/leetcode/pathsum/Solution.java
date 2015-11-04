package leetcode.pathsum;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, sum, 0);
	}

	private boolean hasPathSum(TreeNode root, int sum, int sumSoFar) {
		if (root == null) {
			return false;
		}

		sumSoFar += root.val;
		if (sumSoFar == sum && isLeaf(root)) {
			return true;
		}

		boolean hasPathSumLeft = hasPathSum(root.left, sum, sumSoFar);
		if (hasPathSumLeft) {
			return true;
		}
		boolean hasPathSumRight = hasPathSum(root.right, sum, sumSoFar);
		if (hasPathSumRight) {
			return true;
		}
		return false;
	}

	private boolean isLeaf(TreeNode n) {
		return n != null && n.left == null && n.right == null;
	}
	
	public static void main(String[] args) {
		
		TreeBuilder treeuilder = new TreeBuilder();
		TreeNode root = treeuilder.build("8,9,-6,#,#,5,9");//5,4,8,11,#,13,4,7,2,#,#,1
		//[8,9,-6,null,null,5,9],7
		int sum = 7;
		Solution solution = new Solution();
		System.out.println(solution.hasPathSum(root, sum));
	}
}