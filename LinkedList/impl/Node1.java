package impl;

public class Node1 {
	// Fields
	private int number;
	private Node1 next;

	public Node1() {
	}

	public Node1(Node1 next, int number) {
		super();
		this.next = next;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Node1 getNext() {
		return next;
	}

	public void setNext(Node1 next) {
		this.next = next;
	}

}
