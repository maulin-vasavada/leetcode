package leetcode.duplicatefromsortedlist;

import leetcode.ListBuilder;
import leetcode.ListNode;

public class Solution {
	
	//1,2,3,3
	public ListNode deleteDuplicates(ListNode head) {
        if ( head == null ) {
        	return null;
        }
        
        ListNode latest = head;
        ListNode n = latest.next;
        while ( n != null ) {
        	while ( n != null && n.val == latest.val ) {
        		n = n.next;
        	}
        	
        	latest.next = n;
        	latest = n;
        	if ( n != null ) {
            	n = n.next;        		
        	}
        }
        return head;
    }
	
	public static void main(String[] args) {
		ListBuilder listBuilder = new ListBuilder();
		ListNode head = listBuilder.build("1,2,2,3,4,5,5,5,6");
		listBuilder.print(head);
		Solution solution = new Solution();
		solution.deleteDuplicates(head);
		listBuilder.print(head);
	}
}