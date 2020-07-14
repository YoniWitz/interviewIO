package stackAsRestriction;

public class ArrayQueueFirst {
	private int size;
	private int p1;
	private int p2;
	private int[] queue;

	public ArrayQueueFirst(int size) {
		this.size = size;
		this.p1 = -1;
		this.p2 = size;
		this.queue = new int[size];
	}

	public void push(int item) {
		if (p1 + 1 >= p2) {
			throw new StackOverflowError("no more space");
		}
		queue[++p1] = item;
	}

	public Integer pop() {
		if (p2 >= size)
			flush();
		if (p2 >= size)
			return null;

		return (queue[p2++]);

	}

	private void flush() {
		while (p1 >= 0) {
			queue[--p2] = queue[p1--];
		}
	}

	public static void main(String[] args) {
		ArrayQueueFirst myQueue = new ArrayQueueFirst(7);
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		myQueue.push(4);
		myQueue.push(5);
		myQueue.push(6);
		myQueue.push(7);
		//myQueue.push(7);

		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
	}

}
