package implAndAppend;

public class LinkedList1 {
	private Node1 head;
	private Node1 tail;

	public LinkedList1(Node1 head, Node1 tail) {
		super();
		this.head = head;
		this.tail = tail;
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

	public void deleteNode(Node1 node, Node1 prev) {
		if (node == null) {
			return;
		}
		if (prev == null) {
			head = head.getNext();
		} else {
			prev.setNext(node.getNext());
		}
	}

	public void deleteNode(Node1 node) {
		if (node == null) {
			return;
		}

		Node1 nextNode = node.getNext();
		if (nextNode != null) {
			node.setNumber(nextNode.getNumber());
			node.setNext(nextNode.getNext());
		}
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

	public void append(Node1 n) {
		if (head == null) {
			head = n;
		} else {
			tail.setNext(n);
		}
		tail = n;
	}

	public void printList() {
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

		LinkedList1 linkedList = new LinkedList1(head, tail);// 1,2

		Node1 newNode = new Node1(null, 3);// 1,2,3
		linkedList.append(newNode);
		linkedList.printList();

		linkedList.deleteNode(newNode, tail);// 1,2
		linkedList.printList();

		linkedList.deleteNode(head);// 2
		linkedList.printList();
	}
}
