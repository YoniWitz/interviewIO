package appendAndSort;

import impl.Impl1Second;
import impl.Node2;

public class Append1N2Second {

	public static void main(String[] args) {
		Node2 head = new Node2(null, 1);
		Node2 tail = new Node2(null, 2);
		head.next = tail;

		LinkedList2 linkedList = new LinkedList2(head, tail);// 1,2

		Node2 newNode = new Node2(null, 3);
		linkedList.append(newNode);
		linkedList.printLinkedList();// 1,2,3

		linkedList.deleteN(newNode, tail);
		linkedList.printLinkedList();// 1,2

		//linkedList.deleteNode(head);
		linkedList.printLinkedList();// 2
	}

}

class LinkedList2 extends Impl1Second{	
	public LinkedList2(Node2 head, Node2 tail) {
		super(head, tail);
	}
	
	@Override
	public void append(Node2 n) {
		if (head == null) {
			head = n;
		} else {
			tail.next =n;
		}
		tail =n ;
	}
}
