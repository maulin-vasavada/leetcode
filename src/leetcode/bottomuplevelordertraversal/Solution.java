package leetcode.bottomuplevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	public static void main(String[] args) {
		TreeBuilder treeBuilder = new TreeBuilder();
		TreeNode root = treeBuilder.build("1,2,3,4,5,6,7");

		Solution solution = new Solution();
		List<List<Integer>> output = solution.levelOrderBottom(root);
		print(output);
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