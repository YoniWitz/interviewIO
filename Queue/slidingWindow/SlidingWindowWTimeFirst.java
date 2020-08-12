package slidingWindow;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowWTimeFirst {
	public static void main(String[] str) {
		SlidingWindowWTime mySlidingWindow = new SlidingWindowWTime();
		mySlidingWindow.addStockPrice(new StockPrice(32, 1));
		mySlidingWindow.addStockPrice(new StockPrice(45, 1));
		mySlidingWindow.addStockPrice(new StockPrice(37, 2));
		mySlidingWindow.addStockPrice(new StockPrice(42, 5));

		mySlidingWindow.print();
	}
}

class SlidingWindowWTime {
	Queue<StockPrice> myQueue;
	int times;

	public SlidingWindowWTime() {
		myQueue = new LinkedList<>();
		times = 3;
	}

	// saves only last 3 days
	public void addStockPrice(StockPrice stockPrice) {
		int time = stockPrice.time;
		myQueue.add(stockPrice);
		while (myQueue.peek().time <= time - times) {
			myQueue.remove();
		}
	}

	public int findMax() {
		Iterator<StockPrice> iterator = myQueue.iterator();
		int max = 0;
		while (iterator.hasNext()) {
			max = Math.max(max, iterator.next().price);
		}
		return max;
	}

	public void print() {
		Iterator<StockPrice> iterator = myQueue.iterator();

		while (iterator.hasNext()) {
			StockPrice stockPrice = iterator.next();
			System.out.println(stockPrice.price + " " + stockPrice.time);
		}

	}
}

class StockPrice {
	int time;
	int price;

	public StockPrice(int price, int time) {
		this.time = time;
		this.price = price;
	}
}
