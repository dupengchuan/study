package kevin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		MinHeap minHeap = new MinHeap(map, k);
		return minHeap.toList();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		Solution347 solution = new Solution347();
		List<Integer> list = solution.topKFrequent(nums, 2);
		System.out.println(list.toString());
	}

}

class MinHeap {
	private ArrayList<Map.Entry<Integer, Integer>> heap;

	public MinHeap(Map<Integer, Integer> map, int k) {
		this.heap = new ArrayList<Map.Entry<Integer, Integer>>(k);
		this.heap.add(null);
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		int i = 1;
		for (Map.Entry<Integer, Integer> element : set) {

			if (i < k) {
				heap.add(i++, element);
				continue;
			}
			if (i == k) {
				heap.add(i++, element);
				this.initHeap();
				continue;
			}
			if (i > k) {
				this.add(element);
			}
		}

	}

	public void add(Map.Entry<Integer, Integer> element) {
		if (element.getValue() <= heap.get(1).getValue()) {
			return;
		} else {
			heap.set(1, element);
			this.MinHeapify(1);
		}
	}

	private void initHeap() {
		for (int i = (heap.size() - 1) / 2; i > 0; i--) {
			MinHeapify(i);
		}
	}

	private void MinHeapify(int i) {
		int l = i << 1;
		int r = (i << 1) + 1;
		int little = i;
		if (l < heap.size() && heap.get(l).getValue() < heap.get(little).getValue()) {
			little = l;
		}
		if (r < heap.size() && heap.get(r).getValue() < heap.get(little).getValue()) {
			little = r;
		}

		if (little != i) {
			Map.Entry<Integer, Integer> entry = heap.get(i);
			heap.set(i, heap.get(little));
			heap.set(little, entry);
			MinHeapify(little);
		}
	}

	public List<Integer> toList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < heap.size(); i++) {
			list.add(i - 1, heap.get(i).getKey());
		}
		return list;
	}
}
