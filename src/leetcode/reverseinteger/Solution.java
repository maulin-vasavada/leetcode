package leetcode.reverseinteger;

public class Solution {
	public int reverse(int x) {
		if (x >= -9 && x <= 9) {
			return x;
		}

		boolean isNegative = false;
		if (x < 0) {

			if (x <= Integer.MIN_VALUE) {
				return 0;
			}

			x = x * -1;
			isNegative = true;
		}

		long r = 0;

		while (x != 0) {
			r = r * 10 + (x % 10);
			if (r > Integer.MAX_VALUE) {
				r = 0;
				break;
			}
			x = (int) (x / 10);
		}

		if (isNegative) {
			r = r * -1;
		}
		return (int) r;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(1534236469));
	}
}
