package leetcode.movezeros;

public class Solution {
    public void moveZeroes(int[] nums) {
        
        if ( nums != null && nums.length!=0 ) {
            int idx = 0;
            for(int i=0; i < nums.length; i++) {
                if ( nums[i] != 0 ) {
                    nums[idx] = nums[i];
                    idx++;
                }
            }
            
            while ( idx < nums.length ) {
                nums[idx] = 0;
                idx++;
            }
        }
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[]{0,1,0,3,12};
		s.moveZeroes(nums);
	}
}