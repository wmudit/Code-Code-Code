package Lists;

import java.util.*;

public class MergeKSortedLists {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode merge(ListNode[] lists) {
		if(lists.length == 0 || lists == null)
			return null;
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int k = lists.length;
		Queue<ListNode> pq = new PriorityQueue<>(k + 1, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
		
		for(int i = 0; i < k; i++) {
			if(lists[i] != null)
				pq.add(lists[i]);
		}
		
		while(!pq.isEmpty()) {
			ListNode temp = pq.poll();
			if(temp.next != null)
				pq.add(temp.next);
			tail.next = temp;
			tail = tail.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		lists[0] = new ListNode(1);
		lists[0].next = new ListNode(4);
		lists[0].next.next = new ListNode(5);
		
		lists[1] = new ListNode(1);
		lists[1].next = new ListNode(3);
		lists[1].next.next = new ListNode(4);
		
		lists[2] = new ListNode(2);
		lists[2].next = new ListNode(6);
		
		ListNode head = merge(lists);
		while(head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		
	}

}
