package leetcode.singlenumber;

import java.util.HashMap;

public class Solution {
	public int singleNumber(int[] nums) {
		
		if ( nums == null || nums.length == 0 ) {
            return 0;
        }
		
		HashMap<Integer, Object> existingNumbers = new HashMap<>();
		Object dummyValue = new Object();
		for (int i = 0; i < nums.length; i++) {
			if (existingNumbers.get(nums[i]) != null) {
				existingNumbers.remove(nums[i]);
			} else {
				existingNumbers.put(nums[i], dummyValue);
			}
		}
		if (existingNumbers.isEmpty()) {
			return 0;
		} else {
			if (existingNumbers.size() != 1) {
				return 0;
			} else {
				return existingNumbers.keySet().iterator().next();
			}
		}
	}
	
	public int singleNumberWithXOR(int[] nums) {
		int x = 0;
		for(int i=0;i<nums.length;i++) {
			x ^= nums[i];
		}
		return x;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { 2, -3, 4, 5, 2, 4, -3 };
		System.out.println(solution.singleNumber(nums));
		System.out.println(solution.singleNumberWithXOR(nums));
	}
}