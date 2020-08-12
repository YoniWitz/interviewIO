package intro;

public class ImplQueueWArrayFirst {
	public static void main(String[] str) {
		myQueue myQueue = new myQueue();
		try {
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
			myQueue.add(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		System.out.println(myQueue.remove());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class myQueue {
	int[] queue;
	int front;
	int back;

	public myQueue() {
		this(10);
	}

	public myQueue(int queueSize) {
		front = back = 0;
		queue = new int[queueSize];
	}

	public int remove() throws Exception {
		if (front != back) {
			int toRemove = queue[front];
			front = (++front) % queue.length;
			return toRemove;
		} else {
			throw new Exception("queue is empty");
		}
	}

	public void add(int toAdd) throws Exception {
		if ((back + 1) % queue.length == front) {
			throw new Exception("queue is full");
		} else {
			queue[back] = toAdd;
			back = (++back) % queue.length;
		}
	}
}
