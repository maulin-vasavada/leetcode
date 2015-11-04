package leetcode.reversebits;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	Map<Integer, Integer> bitMaskMap = new HashMap<>();
	Map<Integer, Integer> maskComplementMap = new HashMap<>();
	{
		for (int i = 0; i < 32; i++) {
			int mask = 1 << i;
			bitMaskMap.put(i, mask);
			maskComplementMap.put(i, ~mask);
		}
	}

	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			boolean iBit = getBit(n, i);
			boolean jBit = getBit(n, 31 - i);
			if (iBit != jBit) {
				n = swap(n, i, 31 - i, iBit, jBit);
			}
		}
		return n;
	}

	int swap(int n, int i, int j, boolean iBit, boolean jBit) {
		n = setBit(n, i, jBit);
		n = setBit(n, j, iBit);
		return n;
	}

	int setBit(int n, int i, boolean value) {
		if (value) {
			n = n | getMask(i);
		} else {
			n = n & maskComplementMap.get(i);
		}
		return n;
	}

	boolean getBit(int n, int i) {
		int x = getMask(i);
		return (x & n) == x;
	}

	int getMask(int i) {
		return bitMaskMap.get(i);
	}

	void testGetBit() {
		System.out.println(getBit(6, 0));
		System.out.println(getBit(6, 1));
		System.out.println(getBit(6, 2));
		System.out.println(getBit(6, 3));
	}

	void testSetBit() {
		System.out.println(setBit(6, 0, true));
		System.out.println(setBit(6, 1, false));
		System.out.println(setBit(6, 2, false));
	}

	void testSwap() {
		System.out.println(swap(6, 0, 2, false, true));
		System.out.println(swap(6, 0, 1, false, true));
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseBits(43261596));
	}
}