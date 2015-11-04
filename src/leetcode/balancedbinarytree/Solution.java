package leetcode.balancedbinarytree;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {
	public boolean isBalanced(TreeNode root) {
		return getHeight(root).balanced;
	}
	
	private static class Result {
		boolean balanced;
		int height;
	}
	
	private Result getHeight(TreeNode n) {
		if ( n == null ) {
			Result nullResult = new Result();
			nullResult.balanced = true;
			return nullResult;
		}
		
		Result leftHeight = getHeight(n.left);
		if ( !leftHeight.balanced ) {
			return leftHeight;
		}
		Result rightHeight = getHeight(n.right);
		if ( !rightHeight.balanced ) {
			return rightHeight;
		}

		Result myResult = new Result();
		myResult.height = Math.max(leftHeight.height, rightHeight.height)+1;

		int myDelta = leftHeight.height - rightHeight.height;
		if ( myDelta > 1 || myDelta < -1 ) {
			myResult.balanced = false;
		} else {
			myResult.balanced = true;			
		}
		return myResult;
	}
	
	public static void main(String[] args) {
		TreeBuilder treeBuilder = new TreeBuilder();
		TreeNode root = treeBuilder.build("1,#,3,#,#,6,7");//,2,3,4,5,#,#,6,7
		
		Solution solution = new Solution();
		System.out.println(solution.isBalanced(root));
	}
}
