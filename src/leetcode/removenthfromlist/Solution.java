package leetcode.removenthfromlist;

import leetcode.ListBuilder;
import leetcode.ListNode;

public class Solution {
	/*
	 * 1,2,3,4
	 * n=3
	 * 
	 * 1
	 * n=1
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if ( n <= 0 ) {
			return null;
		} else {
			ListNode p1 = head;
			ListNode p2 = head;

			while (n > 0 && p2 != null) {
				p2 = p2.next;
				n--;
			}

			if (p2 != null) {
				while (p2.next != null) {
					p1 = p1.next;
					p2 = p2.next;
				}

				p1.next = p1.next.next;
				return head;
			} else {
				if ( n == 0 ) {
					return head.next;
				} else {
					return null;		
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ListBuilder lb = new  ListBuilder();
		ListNode head = lb.build("1,2,3,4");
		int n = 5;
		Solution solution = new Solution();
		lb.print(solution.removeNthFromEnd(head, n));
	}
}