package leetcode.hammingweight;

public class Solution {
    public int hammingWeight1(int n) {
    	int weight = 0;
        while( n != 0 ) {
        	weight = ((n & 1) == 1) ? weight+1 : weight;
        	n >>= 1;
        }
        return weight;
    }
    
    public int hammingWeight2(int n) {
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i) == true){
                count++;
            }
        }
        return count;
    }
     
    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
		System.out.println(s.hammingWeight2(452));
		System.out.println(s.hammingWeight2(11));
	}
}