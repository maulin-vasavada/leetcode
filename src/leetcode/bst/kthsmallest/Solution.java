package leetcode.bst.kthsmallest;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {
	
	private static class Result {
		int nodesLeft;
		TreeNode n;
		public Result(int nodesLeft) {
			this.nodesLeft = nodesLeft;
		}
		public Result(int nodesLeft, TreeNode n ) {
			this.nodesLeft = nodesLeft;
			this.n = n;
		}
	}
	public int kthSmallest(TreeNode root, int k) {
		Result result = kthSmallestHelper(root, k);
		if ( result.n != null && result.nodesLeft == 0) {
			return result.n.val;			
		} else {
			return 0;
		}
	}
	
	private Result kthSmallestHelper(TreeNode root, int k) {
		
		if ( root == null ) {
			return new Result(k);
		}
		
		if ( isLeaf(root) ) {
			return new Result(k-1,root);
		}
		
		Result leftResult = kthSmallestHelper(root.left, k);
		if ( leftResult.nodesLeft == 0 ) {
			return leftResult;
		}
		k = leftResult.nodesLeft-1;
		if ( k == 0 ) {
			return new Result(0,root);
		}
		return kthSmallestHelper(root.right, k);
	}
	
	private boolean isLeaf(TreeNode n) {
		return n != null && n.left == null && n.right == null;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int k = 2;
		TreeNode root = new TreeBuilder().build("20,15,30,10,18,#,#,6,12,16,19");
		System.out.println(solution.kthSmallest(root, k));
	}
}
