package leetcode.anagram;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram1(String s, String t) {
    	if ( (s == null && t == null) ||
    			(s == null && t != null) ||
    			(s != null && t == null) ||
    			(s.length() != t.length())) {
    		return false;
    	} else {
        	boolean anagram = true;
        	char[] sArray = s.toCharArray();
        	char[] tArray = t.toCharArray();
        	Arrays.sort(sArray);
        	Arrays.sort(tArray);
        	
        	for(int i=0;i<sArray.length;i++) {
        		if ( sArray[i] != tArray[i] ) {
        			anagram = false;
        			break;
        		}
        	}
        	return anagram;	
    	}    	
    }
    
    public boolean isAnagram2(String s, String t) {
    	if ( (s == null && t == null) ||
    			(s == null && t != null) ||
    			(s != null && t == null) ||
    			(s.length() != t.length())) {
    		return false;
    	} else {
        	boolean anagram = true;
        	int[] sindex = new int[26];
        	int[] tindex = new int[26];
        	for(int i=0;i<s.length();i++) {
        		sindex[s.charAt(i)-'a']++;
        		tindex[t.charAt(i)-'a']++;
        	}
        	for(int i=0;i<sindex.length;i++) {
        		if ( sindex[i] != tindex[i] ) {
        			anagram =false;
        			break;
        		}
        	}
        	return anagram;	
    	}    	
    }

    public boolean isAnagram(String s, String t) {
    	if ( (s == null && t == null) ||
    			(s == null && t != null) ||
    			(s != null && t == null) ||
    			(s.length() != t.length())) {
    		return false;
    	} else {
        	boolean anagram = true;
        	int[] sindex = new int[26];
        	for(int i=0;i<s.length();i++) {
        		sindex[s.charAt(i)-'a']++;
        		sindex[t.charAt(i)-'a']--;
        	}
        	for(int i=0;i<sindex.length;i++) {
        		if ( sindex[i] != 0 ) {
        			anagram =false;
        			break;
        		}
        	}
        	return anagram;	
    	}    	
    }

    public static void main(String[] args) {
		Solution s= new Solution();
		System.out.println(s.isAnagram("nagaram", "anagram"));
		System.out.println(s.isAnagram("", ""));
		System.out.println(s.isAnagram("nagaram", "anagra"));
		System.out.println(s.isAnagram("nagaram", ""));
		System.out.println(s.isAnagram("nag", "anagram"));
		System.out.println(s.isAnagram("", "anagram"));
		System.out.println(s.isAnagram("nagaram", null));
		System.out.println(s.isAnagram(null, "anagram"));
	}
}
