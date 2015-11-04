package leetcode;

public class ListBuilder {

	public ListNode build(String data) {
		
		if ( data == null || data.trim().isEmpty() ) {
			return null;
		}
		
		ListNode head = null;
		ListNode tail = null;
		String[] input = data.split(",");
		
		for(String i: input) {
			ListNode n = new ListNode(Integer.parseInt(i));
			if ( head == null ) {
				head = n;
				tail = n;
			} else {
				tail.next = n;
				tail = n;				
			}
		}
		
		return head;
	}
	
	public void print(ListNode n) {
		System.out.println();
		while ( n != null ) {
			System.out.print(n.val+" , ");
			n = n.next;
		}
	}
}
