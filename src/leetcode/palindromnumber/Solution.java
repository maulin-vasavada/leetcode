package leetcode.palindromnumber;

public class Solution {
	public boolean isPalindrome(int x) {
		boolean xNegative = false;
		if ( x < 0 ) {
			xNegative = true;
			x = x*-1;
		}
		
		if ( x == Integer.MIN_VALUE ) {
			x = Integer.MAX_VALUE;
		}
		
		int palindrome = x; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and reverse of number is equal means
        // number is palindrome in Java
        if (x == reverse) {
            return true && !xNegative;
        }
        return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(Integer.MIN_VALUE));
	}
}