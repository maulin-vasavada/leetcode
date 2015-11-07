package leetcode.bottomuplevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.TreeBuilder;
import leetcode.TreeNode;

public class Solution {

	private static class TreeNodeData {
		TreeNode node;
		int level;

		public TreeNodeData(TreeNode n, int level) {
			super();
			this.node = n;
			this.level = level;
		}

		@Override
		public String toString() {
			return "" + node + ", level=" + level + "";
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> output = new ArrayList<>();
		if (root == null) {
			return null;
		}

		List<TreeNodeData> list = new LinkedList<>();

		Queue<TreeNodeData> queue = new LinkedList<>();
		queue.add(new TreeNodeData(root, 1));

		while (!queue.isEmpty()) {
			TreeNodeData nodeData = queue.remove();
			list.add(nodeData);
			if (nodeData.node.left != null) {
				queue.add(new TreeNodeData(nodeData.node.left,
						nodeData.level + 1));
			}
			if (nodeData.node.right != null) {
				queue.add(new TreeNodeData(nodeData.node.right,
						nodeData.level + 1));
			}
		}

		int lastLevel = list.get(0).level;
		List<Integer> sublist = new ArrayList<>();
		for (TreeNodeData nodeData : list) {
			if (nodeData.level != lastLevel) {
				output.add(0, sublist);
				sublist = new ArrayList<>();
				lastLevel = nodeData.level;
			}
			if (nodeData.node != null) {
				sublist.add(nodeData.node.val);
			}
		}
		if (!sublist.isEmpty()) {
			output.add(0, sublist);
		}
		return output;
	}
	
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();
		if (root == null) {
			return null;
		}

		int level = 1;
		Queue<TreeNodeData> queue = new LinkedList<>();
		queue.offer(new TreeNodeData(root, level));
		
		Stack<TreeNodeData> stack = new Stack<>();
		
		while( !queue.isEmpty() ) {
			TreeNodeData n = queue.poll();
			stack.push(n);
			
			level = n.level;
			if ( n.node.right != null ) {
				queue.offer(new TreeNodeData(n.node.right, level+1));
			}
			
			
			if ( n.node.left != null ) {
				queue.offer(new TreeNodeData(n.node.left, level+1));
			}
		}
		
		List<Integer> list = new ArrayList<>();
		while( !stack.isEmpty()) {
			TreeNodeData n = stack.pop();
			if ( n.level != level ) {
				output.add(list);
				list = new ArrayList<>();
				level = n.level;
			}
			list.add(n.node.val);
		}
		output.add(list);
		return output;
	}
	
	public void spiralLevelOrder(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		
		stack1.push(root);
		
		boolean direction = true; // true = --> , false = <--
		while ( true ) {
			while ( !stack1.isEmpty() ) {
				TreeNode n = stack1.pop();
				System.out.print(n.val+",");
				
				if ( direction ) {
					if ( n.right != null ) {
						stack2.push(n.right);
					}
					if ( n.left != null ) {
						stack2.push(n.left);
					}
				} else {
					if ( n.left != null ) {
						stack2.push(n.left);
					}
					if ( n.right != null ) {
						stack2.push(n.right);
					}
				}
			}
			
			if ( stack1.isEmpty() && stack2.isEmpty() ) {
				break;
			} else {
				Stack<TreeNode> temp = stack1;
				stack1 = stack2;
				stack2 = temp;
				direction = !direction;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeBuilder treeBuilder = new TreeBuilder();
		TreeNode root = treeBuilder.build("1,2,3,4,5,6,7");

		Solution solution = new Solution();
		List<List<Integer>> output = solution.levelOrderBottom(root);
		print(output);
		List<List<Integer>> output2 = solution.levelOrderBottom2(root);
		print(output2);
		solution.spiralLevelOrder(root);
	}

	private static void print(List<List<Integer>> output) {
		for (List<Integer> subList : output) {
			System.out.print("[");
			for (Integer i : subList) {
				System.out.print(i + " , ");
			}
			System.out.println("]");
		}
	}
}