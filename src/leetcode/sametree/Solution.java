package leetcode.sametree;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q != null ) {
            return false;
        } else if ( p != null && q == null ) {
            return false;
        } else {
            if ( p == q ) {
                return true;
            } else {
                if ( p.val == q.val ) {
                    boolean leftSame = isSameTree(p.left, q.left);
                    if ( leftSame ) {
                        return isSameTree(p.right,q.right);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
		TreeBuilder b1 = new TreeBuilder();
		TreeNode p = b1.build("1,#,3");
		TreeBuilder b2 = new TreeBuilder();
		TreeNode q = b2.build("1,#,3");
		
		Solution s = new Solution();
		System.out.println(s.isSameTree(p, q));
	}
}
