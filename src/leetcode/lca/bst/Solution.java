package leetcode.lca.bst;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if ( root == null ) {
			return null;
		}
		
        if ( determineBothOnLeft(root, p, q) ) {
            return lowestCommonAncestor(root.left, p, q);
        } else if ( determineBothOnRight(root, p, q) ) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		
		while( root != null ) {
			if ( determineBothOnLeft(root,p,q)) {
				root = root.left;
			} else if ( determineBothOnRight(root, p, q)) {
				root = root.right;
			} else {
				break;
			}
		}
		
		return root;
	}
    
    private boolean determineBothOnLeft(TreeNode root, TreeNode p, TreeNode q) {
        return (p != null && p.val < root.val) && ( q != null && q.val < root.val);
    }
    
    private boolean determineBothOnRight(TreeNode root, TreeNode p, TreeNode q) {
        return (p != null && p.val > root.val) && ( q != null && q.val > root.val);
    }
    
    
    
    public static void main(String[] args) {
		TreeBuilder b = new TreeBuilder();
		TreeNode root = b.build("6,2,8,0,4,7,9,#,#,3,5");
		b.print();
		
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		Solution s = new Solution();
		
		TreeNode lca = s.lowestCommonAncestor2(root, p, q);
		System.out.println("lca {"+p+","+q+"}"+lca);
	}
}