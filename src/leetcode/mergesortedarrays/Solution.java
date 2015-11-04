package leetcode.mergesortedarrays;

public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m-1;
		int p2 = n-1;
		
		int j = m+n-1;
		while( p1 >= 0 && p2 >=0 ) {
			while ( p2 >=0 && p1 >=0  && nums1[p1] > nums2[p2] ) {
				nums1[j] = nums1[p1];
				p1--;
				j--;
			}
			while( p2 >=0 && p1 >=0  && nums2[p2] > nums1[p1] ) {
				nums1[j] = nums2[p2];
				p2--;
				j--;
			}
		}
	}
	
	public void merge2(int[] A, int m, int[] B, int n) {
		 while(m > 0 && n > 0){
	            if(A[m-1] > B[n-1]){
	                A[m+n-1] = A[m-1];
	                m--;
	            }else{
	                A[m+n-1] = B[n-1];
	                n--;
	            }
	        }
	 
	        while(n > 0){
	            A[m+n-1] = B[n-1];
	            n--;
	        }
	}
	
	/*
	 * 2,6,9, 18
	 * 3,4,7,8,11,12,17
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = new int[]{2,6,9,18,-1,-1,-1,-1,-1,-1,-1};
		int m = 4;
		int[] nums2 = new int[]{3,4,7,8,11,12,17};
		int n = 7;
		long startTime = System.nanoTime();
		solution.merge2(nums1, m, nums2, n);
		long endTime = System.nanoTime();
		System.out.println("time="+(endTime-startTime));
		for(int i=0;i<nums1.length;i++) {
			System.out.print(nums1[i]+" , ");
		}
	}
}
