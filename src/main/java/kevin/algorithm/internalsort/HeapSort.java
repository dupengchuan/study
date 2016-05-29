/**
 * @createtime: May 7, 2016 2:14:08 PM
 * @owner: kevin
 */
package kevin.algorithm.internalsort;

import kevin.algorithm.interfaces.Sort;
import kevin.util.AlgorithmName;

/**
 * @author kevin
 * @version 1.1
 */
public class HeapSort implements Sort {

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#sort(int[])
	 */
	public int[] sort(int[] data) {
		// TODO Auto-generated method stub
		int[] temp = new int[data.length+1];
		System.arraycopy(data,0,temp,1,data.length);
		
		int i = (temp.length - 1)/2;
		while(i > 0){
			heapify(temp,i--,temp.length);
		}
		
		i = temp.length - 1;
		while(i > 0){
			if(temp[i] < temp[1]){
				int t = temp[i];
				temp[i] = temp[1];
				temp[1] = t;
				heapify(temp,1,i);
			}
			i--;
		}
		
		System.arraycopy(temp,1,data,0,data.length);
		return data;
	}
	
	private void heapify(int data[],int pos,int end){
		int left = pos << 2;
		int right = (pos << 2) + 1;
		
		int p = pos;
		if(left < end && data[left] > data[p]){
			p = left;
		}
		if(right < end && data[right] > data[p]){
			p = right;
		}
		if(p != pos){
			int temp = data[pos];
			data[pos] = data[p];
			data[p] = temp;
			heapify(data,p,end);
		}
	}

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Sort#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return AlgorithmName.HEAP_SORT;
	}
}
