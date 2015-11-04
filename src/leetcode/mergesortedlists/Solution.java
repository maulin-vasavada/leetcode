package leetcode.mergesortedlists;

import leetcode.ListBuilder;
import leetcode.ListNode;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if ( l1 == null ) {
			return l2;
		}
		
		if ( l2 == null ) {
			return l1;
		}
		
		ListNode p1 = l1;
		ListNode p2 = l2;
		
		ListNode mergedHead = null;
		if ( p1.val <= p2.val ) {
			mergedHead = new ListNode(p1.val);
			p1 = p1.next;
		} else {
			mergedHead = new ListNode(p2.val);
			p2 = p2.next;
		}
		
		ListNode p3 = mergedHead;
		
		while ( p1 != null && p2 != null ) {
			while ( (p1 != null && p2 != null) && (p1.val <= p2.val) ) {
				p3.next = new ListNode(p1.val);
				p1 = p1.next;
				p3 = p3.next;
			}
			while( (p1 != null && p2 != null) && (p2.val < p1.val) ) {
				p3.next = new ListNode(p2.val);
				p2 = p2.next;
				p3 = p3.next;
			}
		}
		
		if ( p1 == null ) {
			while ( p2 != null ) {
				p3.next = new ListNode(p2.val);
				p2 = p2.next;
				p3 = p3.next;
			}
		}
		if ( p2 == null ) {
			while ( p1 != null ) {
				p3.next = new ListNode(p1.val);
				p1 = p1.next;
				p3 = p3.next;
			}
		}
				
		return mergedHead;
    }

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if ( l1 == null ) {
			return l2;
		}
		
		if ( l2 == null ) {
			return l1;
		}
		
		ListNode p1 = null;
		ListNode p2 = null;
		if ( l1.val <= l2.val ) {
			p1 = l1;
			p2 = l2;
		} else {
			p1 = l2;
			p2 = l1;
		}
		
		ListNode mergedHead = p1;
		ListNode prev = null;
		while ( p1 != null && p2 != null ) {
			while ( p1 != null && p1.val <= p2.val ) {
				prev = p1;
				p1 = p1.next;
			}
			prev.next = p2;
			prev = p2;
			ListNode temp = p1;
			p1 = p2;
			p2 = temp;
		}
		return mergedHead;
	}
	
	public static void main(String[] args) {
		ListBuilder lb = new ListBuilder();
		ListNode l1 = lb.build("2,6,10,15,20,30,35");
		ListNode l2 = lb.build("7,8,12,14,18,25");
		
		Solution solution = new Solution();
		ListNode merged = solution.mergeTwoLists2(l1, l2);
		lb.print(merged);
	}
}