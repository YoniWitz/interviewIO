package appendAndSort;

import impl.Impl1First;
import impl.Node1;

public class Append1N2N3First {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.sort();
		Node1 head = new Node1(null, 0);
		linkedList.append(head);

		Node1 newNode = new Node1(null, 2);
		linkedList.append(newNode);

		newNode = new Node1(null, 0);
		linkedList.append(newNode);

		newNode = new Node1(null, 1);
		linkedList.append(newNode);

		newNode = new Node1(null, 0);
		linkedList.append(newNode);

		newNode = new Node1(null, 2);
		linkedList.append(newNode);

		Node1 tail = new Node1(null, 1);
		linkedList.append(tail);

		linkedList.printList();// 0201021

		linkedList.sort();
		linkedList.printList();// 0001122

		linkedList.separate();
	}
}

class LinkedList extends Impl1First {
	public LinkedList() {
		super();
	}

	public LinkedList(Node1 head, Node1 tail) {
		super(head, tail);
	}

	public void append(Node1 n) {	
		if (getHead() == null) {
			setHead(n);
		} else {
			getTail().setNext(n);
		}
		setTail(n);
	}

	public void separate() {
		LinkedList even = new LinkedList();
		LinkedList odd = new LinkedList();

		int index = 0;
		Node1 node = getHead();
		while (node != null) {
			if (index % 2 == 0) {
				even.append(node);
			} else {
				odd.append(node);
			}
			node = node.getNext();
			index++;
		}

		if (index % 2 == 1) {
			odd.getTail().setNext(null);
		} else {
			even.getTail().setNext(null);
		}

		even.printList();
		odd.printList();
	}

	public void sort() {
		if (getHead() == null)
			return;
		
		LinkedList lL0 = new LinkedList();
		LinkedList lL1 = new LinkedList();
		LinkedList lL2 = new LinkedList();

		Node1 node = getHead();
		while (node != null) {
			if (node.getNumber() == 0) {
				lL0.append(node);
			} else if (node.getNumber() == 1) {
				lL1.append(node);
			} else if (node.getNumber() == 2) {
				lL2.append(node);
			}
			node = node.getNext();
		}

		if (lL0.getHead() == null) {
			lL0.setHead(lL1.getHead());
		}
		else {
			lL0.append(lL1.getHead());
		}

		if (lL1.getHead() == null) {
			lL1.setHead(lL2.getHead());
		}
		else {
			lL1.append(lL2.getHead());
		}
		
		if (lL2.getHead() == null) {
			lL2.setHead(new Node1());

		} 
		lL2.getTail().setNext(null);
		

		setHead(lL0.getHead());
		
		 node = getHead();
		while (node.getNext() != null) {
			node = node.getNext();
		}
		setTail(node);
	}

}
