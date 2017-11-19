/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SolutionSubtract {
	public ListNode subtract(ListNode a) {
		ListNode pCur = a; // primary cursor
		ListNode midCur = a; // seconday cursor
		int len = 1;
					
		// Find len of list
		while (midCur.next != null) {
			midCur = midCur.next;
			len++;
		}
		
		// Iterate find midpoint
		int midIndex = len / 2 - 1; // one less mid
		int pIndex = 0;
		// iterate to one less midpoint
		while (pIndex < midIndex) {
			pCur = pCur.next;
			pIndex++;
		}
		midCur = pCur; // midpoint
		
		// Reverse 2nd half of list
		ListNode rNode = reverse(midCur.next);
		midCur.next = rNode; // reconnect two halfs

        // Reset primary cursor to beginning
		pCur = a;
		pIndex = 0;
		while (pIndex <= midIndex) {
			calcDifference(pCur, rNode);
			pCur = pCur.next;
			rNode = rNode.next;
			pIndex++;
		}
		rNode = reverse(midCur.next); // reverse back 2nd half
		midCur.next = rNode; // reconnect
		return a;
	}
	
	/* Function to reverse the linked list */
	public ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	public void calcDifference(ListNode first, ListNode second) {
		first.val = second.val - first.val;
	}
}
