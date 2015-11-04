package leetcode.excelsheetcolumnnumber;

public class Solution {
	/*
	 * A=1 B=2 C=3 .. Z=26
	 * 
	 * ABC = A* pow(26,2) + B* pow(26,1) + C = 1 * 26*26 + 2 * 26 + 3
	 *
	 */
	
	int[] index = new int[128];
	
	public int titleToNumber(String s) {
		
		if ( s == null || s.isEmpty() ) {
			return 0;
		}

		int BASE = 26;
		initIndex();

		int result = getNum(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int n = getNum(s.charAt(i));
			result = result * BASE + n;
		}
		return result;
	}
	
	private void initIndex() {
		for(char c='A'; c <='Z'; c++) {
			index[(int)c]=(int)c-64;
		}
		for(char c='a'; c <='z'; c++) {
			index[(int)c]=(int)c-96;
		}
	}

	private int getNum(char c) {
		return index[(int)c];
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.titleToNumber("ABC"));
	}
}
