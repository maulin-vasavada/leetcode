package leetcode.intersectionoflinkedlists;

import leetcode.ListBuilder;
import leetcode.ListNode;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode intersection = null;
		if (headA == null && headB == null) {
			return intersection;
		}

		if ((headA == null && headB != null)
				|| (headA != null && headB == null)) {
			return intersection;
		}

		if (headA == headB || headA.val == headB.val) {
			intersection = headMatchingCase(headA, headB);
		} else {
			intersection = tailMatchingCase(headA, headB);
		}
		return intersection;
	}

	private ListNode headMatchingCase(ListNode headA, ListNode headB) {
		ListNode intersection = null;
		ListNode pointerA = headA;
		ListNode pointerB = headB;
		ListNode previous = null;
		while ((pointerA != null && pointerB != null)
				&& (pointerA == pointerB || pointerA.val == pointerB.val)) {
			previous = pointerA;
			pointerA = pointerA.next;
			pointerB = pointerB.next;
		}
		if ( pointerA == null ) {
			intersection = headA;
		} else {
			intersection = previous;			
		}
		return intersection;
	}

	private ListNode tailMatchingCase(ListNode headA, ListNode headB) {
		ListNode intersection = null;

		int lenA = len(headA);
		int lenB = len(headB);
		int delta = 0;

		ListNode biggerListHead = null;
		ListNode smallerListHead = null;
		if (lenA >= lenB) {
			biggerListHead = headA;
			smallerListHead = headB;
			delta = lenA - lenB;
		} else {
			biggerListHead = headB;
			smallerListHead = headA;
			delta = lenB - lenA;
		}

		ListNode biggerListPointer = biggerListHead;
		int skipPointer = delta;
		while (skipPointer != 0) {
			biggerListPointer = biggerListPointer.next;
			skipPointer--;
		}

		ListNode smallerListPointer = smallerListHead;
		while (biggerListPointer != null && smallerListPointer != null) {
			if (biggerListPointer == smallerListPointer
					|| biggerListPointer.val == smallerListPointer.val) {
				intersection = biggerListPointer;
				break;
			} else {
				biggerListPointer = biggerListPointer.next;
				smallerListPointer = smallerListPointer.next;
			}
		}

		return intersection;
	}

	private int len(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListBuilder lb = new ListBuilder();
		ListNode headA = lb.build("1,10,15,20");
		ListNode headB = lb.build("1,10,15,20");

		Solution solution = new Solution();
		ListNode intersection = solution.getIntersectionNode(headA, headB);
		System.out.println(intersection != null ? intersection.val : "null");
	}
}
