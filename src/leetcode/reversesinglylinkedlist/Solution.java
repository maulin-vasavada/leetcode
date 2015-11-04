package leetcode.reversesinglylinkedlist;

import leetcode.ListBuilder;
import leetcode.ListNode;

public class Solution {
	public ListNode reverseList(ListNode head) {
		if ( head == null ) {
			return null;
		}
		ListNode prev = null;
		ListNode p = head;
				
		while ( p != null ) {
			ListNode temp = p.next;
			p.next = prev;
			prev = p;
			p = temp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListBuilder lb = new  ListBuilder();
		ListNode head = lb.build("1");
		lb.print(head);
		ListNode reverseHead = solution.reverseList(head);
		lb.print(reverseHead);
	}
}