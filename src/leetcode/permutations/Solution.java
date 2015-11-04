package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		List<List<Integer>> currentOutput = new ArrayList<>();
		permuteHelper(nums, 0, currentOutput);
		return currentOutput;
	}

	private void permuteHelper(int[] nums, int i,
			List<List<Integer>> currentOutput) {
		if (i >= nums.length - 1) {
			List<Integer> list = new ArrayList<>();
			for (int k = 0; k < nums.length; k++) {
				list.add(nums[k]);
			}
			currentOutput.add(list);
			return;
		}

		for (int j = i; j < nums.length; j++) {
			swap(nums, j, i);
			permuteHelper(nums, i + 1, currentOutput);
			swap(nums, j, i);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	static void print(List<List<Integer>> list) {
		for (List<Integer> sublist : list) {
			for (Integer i : sublist) {
				System.out.print(i + " , ");
			}
			System.out.println();
		}
		System.out.println("len=" + list.size());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { 1, 2, 3, 4 };
		print(solution.permute(nums));
	}
}