package leetcode.plusone;


public class Solution {
	public int[] plusOne(int[] digits) {
		if ( digits != null && digits.length != 0 ) {			
			int carry = 0;
			int n = 1;
			for(int i=digits.length-1;i>=0;i--) {
				int sum = 0;
				if ( i == digits.length-1 ) {
					sum = digits[i]+n+carry;					
				} else {
					if ( carry == 0 ) {
						break;
					}
					sum = digits[i]+carry;
				}
				if ( sum > 9 ) {
					carry = 1;
					digits[i] = sum-10;
				} else {
					carry = 0;
					digits[i] = sum;
					break;
				}
			}
			
			if ( carry != 0 ) {
				int[] result = new int[digits.length+1];
				System.arraycopy(digits, 0, result, 1, digits.length);
				result[0] = carry;
				digits = result;
			}
		} else {
			digits = new int[]{1};
		}
		return digits;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		print(solution.plusOne(new int[]{2}));
	}
	
	static void print(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" , ");
		}
	}
}