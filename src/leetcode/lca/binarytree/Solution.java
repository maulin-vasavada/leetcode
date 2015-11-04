package leetcode.lca.binarytree;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {

	static class Result {
		boolean foundP;
		boolean foundQ;
		TreeNode lca;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		
		if ( root.val == p.val || root.val == q.val ) {
			return root;
		}
		
		TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
		TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
		
		if ( leftLCA != null && rightLCA != null ) {
			return root;
		}
		
		return (leftLCA != null) ? leftLCA : rightLCA;
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		return lowestCommonAncestor2Helper(root, p, q).lca;
	}

	public Result lowestCommonAncestor2Helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return new Result();
		}
		
		Result leftResult = lowestCommonAncestor2Helper(root.left, p, q);
		if( leftResult.foundP && leftResult.foundQ ) {
			return leftResult;
		}
		Result rightResult = lowestCommonAncestor2Helper(root.right, p, q);
		if( rightResult.foundP && rightResult.foundQ ) {
			return leftResult;
		}
		
		Result rootResult = new Result();
		if ( leftResult.foundP ) {
			rootResult.foundP = true;
		}
		if ( rightResult.foundP ) {
			rootResult.foundP = true;
		}
		if ( leftResult.foundQ ) {
			rootResult.foundQ = true;
		}
		if ( rightResult.foundQ ) {
			rootResult.foundQ = true;
		}
		if ( root.val == p.val ) {
			rootResult.foundP = true;
		}
		if ( root.val == q.val ) {
			rootResult.foundQ = true;
		}
		
		if ( rootResult.foundP && rootResult.foundQ ) {
			rootResult.lca = root;
		}
		
		return rootResult;
	}

	public static void main(String[] args) {
		TreeBuilder b = new TreeBuilder();
		String data = "6,2,8,0,4,7,9,#,#,3,5";
		data = "1,2,3,4,5,6,7";
		TreeNode root = b.build(data);
		b.print();

		TreeNode p = new TreeNode(7);
		TreeNode q = new TreeNode(5);
		Solution s = new Solution();

		TreeNode lca = s.lowestCommonAncestor2(root, p, q);
		System.out.println("lca {" + p + "," + q + "}" + lca);
	}
}
