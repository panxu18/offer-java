package com.xup.offer.ch5;

import java.util.PriorityQueue;

public class StreamMedian {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b.compareTo(a));
	/**
	 * 利用两个堆实现插入和查找效率最高
	 * 大顶堆保存数组左边较小的元素，小顶堆保存右边较大的元素，
	 * 插入元素时，首先根据比较它与小顶堆最小元素的大小选择将其插入数组哪一边，
	 * 然后插入后到对应的堆之后，调整两个堆的元素，
	 * 保证最小堆的元素和最大堆的元素个数只能相等或多一个
	 * @param num
	 */
	public void insert(Integer num) {
		if (minHeap.isEmpty() || num >= minHeap.peek()) {
			minHeap.add(num);
			// 调整两个堆的元素
			if (maxHeap.size() + 1 < minHeap.size())
				maxHeap.add(minHeap.poll());
		} else {
			maxHeap.add(num);
			// 调整两个堆的元素
			if (maxHeap.size() > minHeap.size())
				minHeap.add(maxHeap.poll());
		}
    }

    public Double getMedian() {
    	if (maxHeap.size() == minHeap.size())
    		return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    	else 
    		return (double) minHeap.peek();
    }
    
    public static void main(String[] args) {
    	StreamMedian sm = new StreamMedian();
    	int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
    	for (int i : array) {
    		sm.insert(i);
    		System.out.println(sm.getMedian());
    	}
    }
}
