package leetcode.dutchflag.sortcolors;

public class Solution {
	public void sortColors(int[] colors) {
		
		int low = 0;
		int high = colors.length-1;
		int mid = 0;
		
		while ( mid <= high ) {
			int data = colors[mid];
			
			if ( data == 0 ) {
				swap(colors, mid, low);
				low++;
				mid++;
			} else if ( data == 1 ) {
				mid++;
			} else if ( data == 2 ) {
				swap(colors,mid,high);
				high--;
			}
		}
	}
	
	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	static void print(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] colors = new int[]{2,1,2};
		solution.sortColors(colors);
		print(colors);
	}
}
