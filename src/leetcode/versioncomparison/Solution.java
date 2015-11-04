package leetcode.versioncomparison;

public class Solution {
	public int compareVersion(String version1, String version2) {
		int result = 0;

		String[] version1tokens = version1.split("\\.");
		String[] version2tokens = version2.split("\\.");

		int i = 0, j = 0;
		for (; i < version1tokens.length && j < version2tokens.length; i++, j++) {
			int v1 = Integer.parseInt(version1tokens[i]);
			int v2 = Integer.parseInt(version2tokens[j]);
			if (v1 < v2) {
				result = -1;
				break;
			} else if (v1 > v2) {
				result = 1;
				break;
			}
		}

		if (result == 0) {
			String[] versiontokens = null;
			int startIdx = 0;
			if (i == version1tokens.length && j < version2tokens.length) {
				result = -1;
				versiontokens = version2tokens;
				startIdx = j;
			} else if (i < version1tokens.length && j == version2tokens.length) {
				result = 1;
				versiontokens = version1tokens;
				startIdx =i;
			}
			
			if ( checkRemainingZeros(versiontokens, startIdx)) {
				result=0;
			}
		}
		return result;
	}
	
	private boolean checkRemainingZeros(String[] versiontokens, int startIdx) {
		boolean remainingZeros = true;
		if ( versiontokens == null ) {
			remainingZeros = false;
		} else {
			for(int i=startIdx;i<versiontokens.length;i++) {
				if ( Integer.parseInt(versiontokens[i]) !=0 ) {
					remainingZeros = false;
					break;
				}
			}			
		}
		return remainingZeros;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.compareVersion("2.5.0.0.0.0.0.0", "2.5.0.0"));
		System.out.println(solution.compareVersion("2.5", "2.5.2"));
		System.out.println(solution.compareVersion("2.5", "1.5.2"));
		System.out.println(solution.compareVersion("1.5.10", "1.5.2"));
		System.out.println(solution.compareVersion("1.5.6.7.8", "1.5.6.7.9"));
	}
}
