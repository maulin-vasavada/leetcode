package leetcode.streammedian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10,
			Collections.reverseOrder());

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	//
	// Adds a number into the data structure.
	public void addNum(int num) {
		list.add(num);
		if ( minHeap.isEmpty() ) {
			maxHeap.add(num);
		} else if ( num < minHeap.peek() ) {
			maxHeap.add(num);
		} else {
			maxHeap.add(minHeap.remove());
			minHeap.add(num);
		}

		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.remove());
		}
		//System.out.println();
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else {
			if ( minHeap.size() > maxHeap.size() ) {
				return minHeap.peek();
			} else {
				return maxHeap.peek();
			}
		}
	}

	List<Integer> list = new ArrayList<>();

	public List<Integer> all() {
		return list;
	}

	static void test1() {
		MedianFinder mf = new MedianFinder();
		mf.addNum(9);
		System.out.println("Median=" + mf.findMedian() + " , supposed to be="
				+ median(mf.all()));
		mf.addNum(10);
		System.out.println("Median=" + mf.findMedian() + " , supposed to be="
				+ median(mf.all()));
		mf.addNum(5);
		mf.addNum(2);
		mf.addNum(8);
		mf.addNum(1);
		mf.addNum(15);
		mf.addNum(3);
		mf.addNum(4);
		mf.addNum(6);
		System.out.println("Median=" + mf.findMedian() + " , supposed to be="
				+ median(mf.all()));
	}

	static void test2() {
		MedianFinder mf = new MedianFinder();
		mf.addNum(-1);
		mf.addNum(-2);
		mf.addNum(-3);
		System.out.println("Median=" + mf.findMedian() + " , supposed to be="
				+ median(mf.all()));
	}

	static void test3() {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		System.out.println("Median=" + mf.findMedian() + " , supposed to be="
				+ median(mf.all()));
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	static double median(List<Integer> list) {
		double result = 0;
		Integer[] sortedList = new Integer[list.size()];
		Arrays.sort(list.toArray(sortedList));
		if (sortedList.length % 2 == 0) {
			int idx1 = (int) (sortedList.length / 2);
			int idx2 = idx1 - 1;
			result = ((double) sortedList[idx1] + (double) sortedList[idx2]) / 2;
		} else {
			result = sortedList[(int) (sortedList.length / 2)];
		}
		return result;
	}
}