package org.monan.jdk;

import java.util.concurrent.RecursiveAction;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;


public class ForkJoinPoolTest {

	/**
	 *
	 * @作者：       心如明镜——
	 * @创建时间： 2019年1月19日
	 * @描述：通过forkjoin 多线程任务计算排序
	 *
	 */
	private static class SortTask extends RecursiveAction {

		private static final long serialVersionUID = 1L;
		final long[] array;
		final int lo, hi;

		static final int THRESHOLD = 100;

		SortTask(long[] array, int lo, int hi) {
			this.array = array;
			this.lo = lo;
			this.hi = hi;
		}

		SortTask(long[] array) {
			this(array, 0, array.length);
		}

		protected void compute() {
			if (hi - lo < THRESHOLD)
				sortSequentially(lo, hi);
			else {
				int mid = (lo + hi) >>> 1; //无符号右移一位，
//				System.out.println("low:"+lo+"----mid:"+mid+"----hi:"+hi);
				invokeAll(new SortTask(array, lo, mid), new SortTask(array, mid, hi));
				merge(lo, mid, hi);
			}
		}

		void sortSequentially(int lo, int hi) {
			Arrays.sort(array, lo, hi);
		}

		void merge(int lo, int mid, int hi) {
			long[] buf = Arrays.copyOfRange(array, lo, mid);
			for (int i = 0, j = lo, k = mid; i < buf.length; j++)
				array[j] = (k == hi || buf[i] < array[k]) ? buf[i++] : array[k++];
		}
	}

	public static void main(String[] args) throws InterruptedException {

		//普通数据排序
		NormalSort();

		// 使用forkjonpool排序
		forkjoinSort();
	}

	/**
	 * 数组直接排序
	 */
	private static void NormalSort() {
		long[] array = MakeArray();
		SortTask task = new SortTask(array);

		long start = System.currentTimeMillis();
		task.sortSequentially(0, array.length - 1);
		long end = System.currentTimeMillis();
		System.out.println("--使用数组直接排序，所需时间:" + (end - start) + "ms");

	}

	private static void forkjoinSort() throws InterruptedException {
		long[] array = MakeArray();
		SortTask task = new SortTask(array);
		ForkJoinPool pool = new ForkJoinPool();

		// 提交计算方法
		long start = System.currentTimeMillis();
		pool.submit(task);
		pool.shutdown();
		while (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
			System.out.println("到达指定时间，还有线程没执行完");
		}
		long end = System.currentTimeMillis();

		System.out.println("--forkjonpool排序，所需时间:" + (end - start) + "ms");



//		System.out.println("排序后：");
//		println(array);

	}

	private static long[] MakeArray() {
		final int SIZE = 10000000;
		long[] array = new long[SIZE];

		Random d = new Random();
		for (int i = 0; i < SIZE; i++) {
			array[i] = d.nextInt((i + 1) * 6); //随机赋值
		}
//		System.out.println("初始化：");
//		println(array);
		return array;
	}


	/**
	 * 只打印数组前100个值
	 * @param array
	 */
	private static void println(long[] array) {
		String result="";
		for (int i = 0; i < 100; i++) {
			result+= array[i] + ",";
		}
		System.out.println(result);
	}

}

