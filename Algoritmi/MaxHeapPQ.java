package Algoritmi;


public class MaxHeapPQ implements CoadaDePrioritate {
	private static final int INITIAL_SIZE = 10;
	private int[] heap;
	private int size;
	private int maxsize;
	
	public MaxHeapPQ() {
		this.size = 0;
		this.maxsize = INITIAL_SIZE;
		heap = new int[INITIAL_SIZE];
	}
	
	@Override
	public Integer getMax() {
		if(size > 0)
			return heap[0];
		else
			return -1;
	}

	@Override
	public Integer removeMax() {
		if(size == 0)
			return -1;
		
		Integer max = this.getMax();
		heap[0] = heap[size - 1];
		size--;
		heapify(0);
		return max;
	}

	@Override
	public void insert(int element) {
		if(maxsize == size) {
			int[] newHeap = new int[maxsize * 2];
			System.arraycopy(heap, 0, newHeap, 0, heap.length);
			this.heap = newHeap;
			this.maxsize *= 2;
		}
		
		this.size++;
		int pos = this.size - 1;
		heap[pos] = element;
		while(heap[pos] > heap[pos/2]) {
			swap(pos, pos/2);
			pos = pos/2;
		}
	}

	public void heapify(int pos) {
		if(pos >= size/2)
			return;
		if(heap[pos] < heap[pos * 2] || heap[pos] < heap[pos * 2 + 1]) {
			if(heap[pos * 2] > heap[pos * 2 + 1]) {
				swap(pos, pos * 2);
				heapify(pos * 2);
			}
			else {
				swap(pos, pos * 2 + 1);
				heapify(pos * 2 + 1);
			}
		}
	}
	
	public void swap(int pos1, int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
}
