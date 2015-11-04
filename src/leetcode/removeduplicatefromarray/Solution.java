package leetcode.removeduplicatefromarray;

public class Solution {
	public int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		if ( nums.length == 1 ) {
			if ( nums[0] == val ) {
				return 0;
			}
		}

		int j = nums.length - 1;
		boolean anyOccuranceOfValFound = false;
		for (int i = 0; i < nums.length && i < j; i++) {
			if (nums[i] == val) {

				while (j > 0 && j > i && nums[j] == val) {
					j--;
				}

				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				anyOccuranceOfValFound = true;
			}
		}
		if (anyOccuranceOfValFound || nums[nums.length-1]==val) {
			return j;
		} else {
			return j + 1;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { 1, 2, 3, 4, 5, 2, 3, 4, 2, 2 };
		nums = new int[]{4,5};
		int val = 5;
		print(nums);
		int len = solution.removeElement(nums, val);
		print(nums);
		System.out.println("len=" + len);
	}

	static void print(int[] nums) {
		System.out.println("****");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ,");
		}
	}
}