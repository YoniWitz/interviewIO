package stackAsRestriction;

public class ArrayTwoStacksSecond {
	int[] arrayStacks;

	int p1;
	int p2;

	public ArrayTwoStacksSecond() {
		this(5);
	}

	public ArrayTwoStacksSecond(int size) {
		arrayStacks = new int[size];
		p1 = -1;
		p2 = size;
	}

	public void push(int stackNumber, int data) throws Exception {
		if (p1 + 1 >= p2)
			throw new Exception(" stack full");

		if (stackNumber == 1) {
			arrayStacks[++p1] = data;
		} else if (stackNumber == 2) {
			arrayStacks[--p1] = data;
		} else {
			throw new Exception("fack yu!");
		}
	}

	public int pop(int stackNumber) throws Exception {
		if (stackNumber == 1) {
			if (p1 <= -1)
				throw new Exception("empty stack");

			return arrayStacks[p1--];
		} else if (stackNumber == 2) {
			if (p2 >= arrayStacks.length)
				throw new Exception("empty stack");

			return arrayStacks[p1++];
		} else {
			throw new Exception("no such stack");
		}
	}

	public static void main(String[] args) {
		ArrayTwoStacksSecond newStack = new ArrayTwoStacksSecond();
		try {
			newStack.push(1, 12);
			newStack.push(1, 13);
			newStack.push(1, 14);
			newStack.push(1, 15);
			newStack.push(1, 16);
			//newStack.push(1, 1);
			System.out.println(newStack.pop(1));
			newStack.pop(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
