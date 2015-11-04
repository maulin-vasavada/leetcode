package leetcode.buyandsellstock2;

public class Solution {

	public int maxProfitNTxn(int[] prices) {
		// 30,15,20,12,7,14,18,15,20
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int delta = prices[i] - prices[i - 1];
			if (delta > 0) {
				profit += delta;
			}
		}
		System.out.println("Max profit with N txn:" + profit);
		return profit;
	}

	public int maxProfitTwoTxn(int[] prices) {
		/*
		 * 12,11,13,9,12,8,14,13,15
		 */
		int maxProfit = 0;

		int[] firstTxnProfit = new int[prices.length];

		int minPriceSoFar = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPriceSoFar) {
				minPriceSoFar = prices[i];
			}
			if (prices[i] - minPriceSoFar > maxProfit) {
				maxProfit = prices[i] - minPriceSoFar;
			}

			firstTxnProfit[i] = maxProfit;
		}

		print(firstTxnProfit);

		int maxPriceSoFar = prices[prices.length - 1];
		maxProfit = 0;
		for (int i = prices.length - 1; i > 0; i--) {
			if (prices[i] > maxPriceSoFar) {
				maxPriceSoFar = prices[i];
			}
			maxProfit = Math.max(maxProfit, firstTxnProfit[i - 1]
					+ maxPriceSoFar - prices[i]);
		}

		System.out.println("MaxProfit for two txn:" + maxProfit);
		return maxProfit;
	}

	public int maxProfitTwoTxnConstantSpace(int[] prices) {
		/*
		 * 12,11,13,9,12,8,14,13,15
		 */
		int firstTxnProfit = 0;
		int maxProfit = 0;
		int minPriceSoFar = prices[0];
		int maxPriceSoFar = prices[prices.length - 1];

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPriceSoFar) {
				minPriceSoFar = prices[i];
			}
			if (prices[i] - minPriceSoFar > firstTxnProfit) {
				firstTxnProfit = prices[i] - minPriceSoFar;
			}

			for (int j = prices.length - 1; j > i; j--) {
				if (prices[j] > maxPriceSoFar) {
					maxPriceSoFar = prices[j];
				}
				maxProfit = Math.max(maxProfit, firstTxnProfit
						+ maxPriceSoFar - prices[j]);
			}
		}

		System.out.println("MaxProfit for two txn with O(1) space:" + maxProfit);
		return maxProfit;
	}

	void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " , ");
		}
		System.out.println();
	}

	public int maxProfitSingleTxn(int[] prices) {
		/*
		 * 10,15,20,12,7,14,18,15 0,5,10,2,0,7,11,9
		 * 
		 * 30,15,20,12,7,14,18,15,20 0,0,5,0,0,7,11,9,14
		 */
		int min = prices[0];
		int maxProfit = 0;
		int buyDay = -1;
		int sellDay = -1;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				buyDay = i;
			}
			int profit = prices[i] - min;
			if (profit > maxProfit) {
				maxProfit = profit;
				sellDay = i;
			}
		}

		System.out.println(buyDay + ", " + sellDay + ", profit=" + maxProfit);
		return maxProfit;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = new int[] { 12,11,13,9,12,8,14,13,15 };
		// prices = new int[]{50,55};
		solution.maxProfitTwoTxnConstantSpace(prices);
	}
}