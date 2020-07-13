package reversingALinkedList;

public class ReverseLinkedList1N2First {
	public static void main(String[] args) {
		Node node1 = new Node(null, 1);

		Node node3 = new Node(node1, 15);
		Node node4 = new Node(node3, 23);
		Node node5 = new Node(node4, 23);
		Node node6 = new Node(node5, 15);
		Node node7 = new Node(node6, 1);

//		LinkedList ll2 = new LinkedList();
//		ll2.append(node3);
//		ll2.append(node1);
//		ll2.printList();
//		ll2.reverseLinkedList(ll2.head);
//		ll2.printList();

		LinkedList ll = new LinkedList();
		ll.head = node7;
		ll.tail = node1;
		ll.printList();
		ll.reverseLinkedList(ll.head);
		ll.printList();

		ll.isPalindrome();
	}
}

class LinkedList {
	Node head;
	Node tail;

	public void append(Node n) {
		if (this.head == null) {
			this.head = n;
		} else {
			this.tail.next = n;
		}
		this.tail = n;
		this.tail.next = null;
	}

	public void printList() {
		Node node = this.head;
		while (node.next != null) {
			System.out.print(node.data + ", ");
			node = node.next;
		}
		System.out.println(node.data);
	}

	public void isPalindrome() {
		Node tempHead = findMedian();
		LinkedList tempLL = new LinkedList();
		tempLL.head = tempHead;
		tempLL.printList();
		tempLL.head = tempLL.reverseLinkedList(tempLL.head);
		tempLL.printList();
		Node right = tempLL.head;
		Node left = this.head;
		while (right != left && left != null && right != null) {
			System.out.println(right.data + " " + left.data + ": ");
			if (right.data != left.data) {
				System.out.println(" not pali");
				return;
			}
			right = right.next;
			left = left.next;
		}
		System.out.println("pali");
	}

	public Node findMedian() {
		if (head == null)
			return null;
		Node fastNode = head;
		Node slowNode = head;

		while (fastNode != null) {
			fastNode = fastNode.next;
			if (fastNode == null) {
				break;
			}
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return slowNode;

	}

	public Node reverseLinkedList(Node first) {
		if (first == null || first == this.tail)
			return null;

		if (first == head)
			this.tail = this.head;
		Node prev = null;
		Node current = first;
		Node next = current.next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		if (first == head)
			this.head = prev;
		
		return prev;
	}
}

class Node {
	Node next;
	int data;

	public Node() {
	}

	public Node(Node next, int data) {
		this.next = next;
		this.data = data;
	}
}
