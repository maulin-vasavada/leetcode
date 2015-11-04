package leetcode.symmetricbinarytree;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {

	public boolean isSymmetric(TreeNode root) {
		
		if ( root == null ) {
			return true;
		}
		
		boolean symmetric = true;
		
		List<TreeNode> queue = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			if (size != 1) {
				for (int i = 0, j = size - 1; i < size / 2 && j >= size / 2; i++, j--) {
					TreeNode n1 = queue.get(i);
					TreeNode n2 = queue.get(j);
					if (!continueMatching(n1, n2)) {
						return false;
					}
				}
			}

			for (int i = 0; i < size; i++) {
				TreeNode tn = queue.get(0);
				if ( tn != null ) {
					queue.add(tn.left);
					queue.add(tn.right);					
				}
				queue.remove(0);
			}
		}
		return symmetric;
	}

	private boolean continueMatching(TreeNode n1, TreeNode n2) {
		return (n1 == n2) || (n1 != null && n2 != null && n1.val == n2.val);
	}
	
	public static void main(String[] args) {
		TreeBuilder treeBuilder = new TreeBuilder();
		TreeNode root = treeBuilder.build("1,2,2,#,3,#,3");
		Solution solution = new Solution();
		System.out.println(solution.isSymmetric(root));
	}
}