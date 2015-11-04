package leetcode.mindepthbinarytree;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {
	
	private static class LeafData {
		int nodes;
		TreeNode leaf;
	}
	
	public int minDepth(TreeNode root) {
		return minDepthHelper(root,0).nodes;
	}
	
	private LeafData minDepthHelper(TreeNode root, int nodesSoFar) {
		if ( root == null ) {
			return new LeafData();
		}
		
		if ( root.left == null && root.right == null ) {
			LeafData leafData = new LeafData();
			leafData.nodes = nodesSoFar+1;
			leafData.leaf = root;
			return leafData;
		}
		
		LeafData leftLeaf = minDepthHelper(root.left,nodesSoFar+1);
		LeafData rightLeaf = minDepthHelper(root.right,nodesSoFar+1);
		
		if ( leftLeaf.leaf != null && rightLeaf.leaf == null ) {
			return leftLeaf;
		}
		if ( leftLeaf.leaf == null && rightLeaf.leaf != null ) {
			return rightLeaf;
		}
		if ( leftLeaf.nodes < rightLeaf.nodes ) {
			return leftLeaf;
		} else {
			return rightLeaf;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeBuilder().build("1");
		System.out.println(solution.minDepth(root));
	}
}