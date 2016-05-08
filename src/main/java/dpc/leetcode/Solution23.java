/**
 * @createtime: May 8, 2016 8:54:28 AM
 * @owner: kevin
 */
package dpc.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution23 {
	public ListNode mergeKLists(ListNode[] lists) {
		
		// array is empty
		if(lists.length == 0){
			return null;
		}

		ListNode[] heap = new ListNode[lists.length + 1];
		int index = 0;
		for(ListNode node : lists){
			// whethe list is empty
			if(node != null){
				heap[++index] = node;
			}
		}

		//init heap
		for (int i = index / 2; i > 0; i--) {
			heapify(heap, i, index);
		}

		//merge
		ListNode res = new ListNode(0);
		ListNode tail = res;
		while (heap[1] != null) {
			tail.next = new ListNode(heap[1].val);
			tail = tail.next;
			if (heap[1].next != null) {
				heap[1] = heap[1].next;
			} else if(index != 1){
				heap[1] = heap[index--];
			} else{
				heap[1] = null;
			}
			heapify(heap, 1, index);
		}

		return res.next;
	}

	private void heapify(ListNode[] heap, int i, int l) {
		int left = i << 1;
		int right = (i << 1) + 1;
		int min = i;
		if (left <= l && heap[left].val < heap[min].val) {
			min = left;
		}
		if (right <= l && heap[right].val < heap[min].val) {
			min = right;
		}

		if (min != i) {
			ListNode temp = heap[min];
			heap[min] = heap[i];
			heap[i] = temp;
			heapify(heap, min, l);
		}
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(0);
		head.next = new ListNode(2);
		head.next.next = new ListNode(5);
		Solution23 solution = new Solution23();
		ListNode[] data = new ListNode[]{head};
		ListNode list = solution.mergeKLists(data);
		while(list != null){
			System.out.println(list.val);
			list = list.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}