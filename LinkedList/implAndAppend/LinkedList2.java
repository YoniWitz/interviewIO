package implAndAppend;

public class LinkedList2 {
	public Node2 head;
	public Node2 tail;

	public LinkedList2() {
	}

	public LinkedList2(Node2 head, Node2 tail) {
		this();
		this.head = head;
		this.tail = tail;
	}

	public void printNth(int n, Node2 head) {
		if (head == null) {
			return;
		}
		Node2 node = head;

		for (int i = 0; i < n - 1; i++) {
			if (node.next == null)
				return;
			node = node.next;
		}
		System.out.println(node.data);
	}

	public void append(Node2 n) {
		if (head == null) {
			head = n;
		} else {
			tail.next = n;
		}
		tail = n;
	}

	public void printLinkedList() {
		if (head == null) {
			return;
		}
		Node2 node = head;

		System.out.print(node.data + ", ");
		while (node.next != null) {
			node = node.next;
			System.out.print(node.data + ", ");
		}
		System.out.println();
	}

	static void orderLL(LinkedList2 unorderedList) {
		if (unorderedList.head == null || unorderedList.head == unorderedList.tail) {
			return;
		}

		LinkedList2 lL0 = new LinkedList2();
		LinkedList2 lL1 = new LinkedList2();
		LinkedList2 lL2 = new LinkedList2();

		Node2 node = unorderedList.head;
		while (node != null) {
			switch (node.data) {
			case 0:
				lL0.append(node);
				break;
			case 1:
				lL1.append(node);
				break;
			case 2:
				lL2.append(node);
				break;
			}
			node = node.next;
		}

		LinkedList2 orderedLL = new LinkedList2();

		if (lL0.head != null) {
			orderedLL.head = lL0.head;
			orderedLL.tail = lL0.tail;
		}
		if (lL1.head != null) {
			orderedLL.append(lL1.head);
			orderedLL.tail = lL1.tail;
		}
		if (lL2.head != null) {
			orderedLL.append(lL2.head);
			orderedLL.tail = lL2.tail;
		}
		unorderedList.head = orderedLL.head;
		unorderedList.tail = orderedLL.tail;
		unorderedList.tail.next = null;
	}

	static void separateLLs(LinkedList2 linkedlist) {
		LinkedList2 even = new LinkedList2();
		LinkedList2 odd = new LinkedList2();

		Node2 node = linkedlist.head;
		int index = 0;

		while (node != null) {
			if (index % 2 == 0) {
				even.append(node);
			} else {
				odd.append(node);
			}

			node = node.next;
			index++;
		}

		even.tail.next = null;
		odd.tail.next = null;
		System.out.println("even numbers:");
		even.printLinkedList();
		System.out.println("odd numbers:");
		odd.printLinkedList();
	}

	static void deleteN(LinkedList2 linkedList, Node2 N, Node2 prev) {
		if (linkedList.head == null || N == null) {
			return;
		}

		if (N == linkedList.head) {
			linkedList.head = N.next;
		}

		if (prev == null) {// in this case, we already got N == head covered, so if prev is null, must be
							// an error
			return;
		}

		if (N == linkedList.tail) {
			linkedList.tail = prev;
		}
		prev.next = N.next;
	}

	static void deleteNNoPrev(Node2 N) {
		if (N == null || N.next == null)
			return;

		N.data = N.next.data;
		N.next = N.next.next;

	}

	public static void main(String[] args) {
		Node2 node1 = new Node2();
		Node2 node2 = new Node2();
		Node2 node3 = new Node2();
		Node2 node4 = new Node2();
		Node2 node5 = new Node2();
		Node2 node6 = new Node2();
		Node2 node7 = new Node2();

		node1.data = 1;
		node2.data = 0;
		node3.data = 1;
		node4.data = 2;
		node5.data = 2;
		node6.data = 1;
		node7.data = 0;
		LinkedList2 linkedlist = new LinkedList2();
		linkedlist.append(node1);
		linkedlist.append(node2);
		linkedlist.append(node3);
		linkedlist.append(node4);
		linkedlist.append(node5);
		linkedlist.append(node6);
		linkedlist.append(node7);

		System.out.println("original linkedlist:");
		linkedlist.printLinkedList();

		LinkedList2.deleteN(linkedlist, node1, null);
		System.out.println("after deleting head:");
		linkedlist.printLinkedList();

		LinkedList2.deleteN(linkedlist, node7, node6);
		System.out.println("after deleting tail:");
		linkedlist.printLinkedList();

		LinkedList2.deleteN(linkedlist, node4, node3);
		System.out.println("after deleting node4:");
		linkedlist.printLinkedList();

		LinkedList2.deleteNNoPrev(node5);
		System.out.println("after deleting node5:");
		linkedlist.printLinkedList();

		LinkedList2.orderLL(linkedlist);
		System.out.println("after ordering:");
		linkedlist.printLinkedList();

		LinkedList2.separateLLs(linkedlist);
	}

}
