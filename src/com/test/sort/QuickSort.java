package com.test.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = { 3, 5, 2, 4, 1 };

		QuickSort qs = new QuickSort();
		
		// 快排
		// qs.quickSort(data, 0, data.length - 1);

		// 查找第k小的数
		int k = 3;
		int kTh = qs.getKthDataInArray(data, 0, data.length - 1, k);
		System.out.println(kTh);
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

	private void swap(int[] array, int i, int j) {
		if (array == null) {
			return;
		}

		int arrayLen = array.length;

		if (i < 0 || i >= arrayLen || j < 0 || j >= arrayLen) {
			return;
		}

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private int partition(int[] array, int start, int end) {
		int p = start;
		int index = start + 1;
		while (index <= end) {
			if (array[index] < array[p]) {
				p++;
				swap(array, p, index);
			}
			index++;
		}
		swap(array, start, p);
		return p;
	}

	private void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int p = partition(array, start, end);
			quickSort(array, start, p - 1);
			quickSort(array, p + 1, end);
		}
	}
	
	private int getKthDataInArray(int[] array, int start, int end, int k){
		if(start == end){
			return array[start];
		}
		
		int povit = partition(array, start, end);
		
		int i = povit - start + 1;
		
		if(i == k){
			return array[povit];
		} else if (i < k){
			return getKthDataInArray(array, povit + 1, end, k - i);
		} else {
			return getKthDataInArray(array, start, povit - 1, k);
		}
	}
}
