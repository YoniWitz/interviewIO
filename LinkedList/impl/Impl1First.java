package impl;

public class Impl1First {
	private Node1 head;
	private Node1 tail;

	public Impl1First(Node1 head, Node1 tail) {
		this.head = head;
		this.tail = tail;
	}

	public Impl1First() {
	}

	public Node1 getHead() {
		return head;
	}

	public void setHead(Node1 head) {
		this.head = head;
	}

	public Node1 getTail() {
		return tail;
	}

	public void setTail(Node1 tail) {
		this.tail = tail;
	}

	public Node1 get(int n) {
		Node1 node = head;
		for (int i = 0; i < n - 1; i++) {
			if (node.getNext() != null) {
				node = node.getNext();
			} else {
				throw new IndexOutOfBoundsException("this node doesn't exist you dick head");
			}
		}
		return node;
	}

	public void printList() {
		if(head == null) return;
		
		Node1 node = head;
		while (node.getNext() != null) {
			System.out.print(node.getNumber());
			node = node.getNext();
		}
		System.out.println(node.getNumber());
	}

	public static void main(String[] args) {
		Node1 head = new Node1(null, 1);
		Node1 tail = new Node1(null, 2);
		head.setNext(tail);

		Impl1First linkedList = new Impl1First(head, tail);// 1,2
	
		linkedList.printList();
	}
}
