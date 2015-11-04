package leetcode.majorityelement;

import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
    	int majority = Integer.MIN_VALUE;
    	
    	int expectedFrequency = (int)(nums.length/2);
    	HashMap<Integer, Integer> countMap = new HashMap<>();
    	
    	for(int i=0;i<nums.length;i++) {
    		Integer currentCount = countMap.get(nums[i]);
    		if ( currentCount == null ) {
    			currentCount = 1;
    		} else {
    			currentCount++;
    		}
			countMap.put(nums[i],currentCount);
			if ( currentCount > expectedFrequency ) {
				majority = nums[i];
				break;
			}
    	}
    	return majority;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.majorityElement(new int[]{1,2,2,2,3,3,3,2,2,2}));
	}
}
