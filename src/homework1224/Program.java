package homework1224;

public class Program {

	public static void main(String[] args) throws Exception {
		// ArrayQueue myQueue = new ArrayQueue(4);
		// try {
		// System.out.println(myQueue.peek());
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// }
		// myQueue.push(1);
		// System.out.println(myQueue.peek());
		// myQueue.push(2);
		// System.out.println(myQueue.peek());
		// myQueue.push(4);
		// System.out.println(myQueue.peek());
		// myQueue.push(4);
		// System.out.println(myQueue.pop());
		// System.out.println(myQueue.pop());
		// myQueue.push(25);
		// System.out.println(myQueue.pop());
		// System.out.println(myQueue.pop());
		// System.out.println(myQueue.pop());
		// SlidingWindows2 sw = new SlidingWindows2();
		//
		// sw.addPrice(13, 1);
		// sw.addPrice(15, 1);
		// sw.addPrice(8, 2);
		// sw.addPrice(17, 5);
		// sw.addPrice(8, 10);

		QueueWithMax queueWithMax = new QueueWithMax();
		queueWithMax.add(5);
		System.out.println(queueWithMax.max());
		queueWithMax.add(6);
		System.out.println(queueWithMax.max());
		queueWithMax.add(4);
		System.out.println(queueWithMax.max());
		queueWithMax.remove();
		System.out.println(queueWithMax.max());
		queueWithMax.remove();
		System.out.println(queueWithMax.max());
		queueWithMax.remove();
		try {
			queueWithMax.remove();
		} catch (Exception e) {
			System.out.println("problem a");
		}
		try {
			System.out.println(queueWithMax.max());
		} catch (Exception e) {
			System.out.println("problem b");
		}

	}

}
