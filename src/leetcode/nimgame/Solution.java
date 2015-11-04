package leetcode.nimgame;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	Map<Integer, Boolean> cache = new HashMap<>();
	{
		cache.put(1, true);
		cache.put(2, true);
		cache.put(3, true);
		cache.put(4,  false);
	}

	public boolean canWinNimConst(int n) {
		return n % 4 != 0;
	}
	
	public boolean canWinNim(int n) {

		if (cache.get(n) != null) {
			return cache.get(n).booleanValue();
		}

		if (n < 4) {
			return true;
		}

		if (n == 4) {
			return false;
		}

		if ( cache.get(n-4) != null ) {
			return cache.get(n-4);
		}
		
		boolean canWin = canWinNim(n - 4);
		cache.put(n - 4, canWin);
		return canWin;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		long startTime = System.nanoTime();
		
		for (int i = 1; i <= 10000; i++) {
			//System.out.println(i + " --> " + solution.canWinNim(i));
			if ( solution.canWinNimConst(i) != solution.canWinNim(i) ) {
				System.out.println("mismatch for "+i);
			}
		}
		long endTime = System.nanoTime();
		System.out.println("time = "+(endTime-startTime)/1000+" ms");
	}
}