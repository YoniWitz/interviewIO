package impl;

public class Node2 {
	public int data;
	public Node2 next;

	public Node2() {}
	
	public Node2(int data) {
		this.data = data;
	}
	
	public Node2(Node2 next ,int data) {
		this.data = data;
		this.next = next;
	}	
}
