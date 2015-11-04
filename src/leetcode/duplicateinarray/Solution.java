package leetcode.duplicateinarray;

import java.util.HashMap;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean contains = false;
        
        if ( nums != null && nums.length != 0 ) {
        	Object o = new Object();
            HashMap<Integer,Object> cache = new HashMap<>();
            for(int i=0;i<nums.length;i++) {
            	if (cache.get(nums[i]) != null) {
            		contains = true;
            		break;
            	} else {
            		cache.put(nums[i],o);
            	}
            }        	
        }
        return contains;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.containsDuplicate(new int[]{-4,2,3,4,5,8,-4}));
	}
}
