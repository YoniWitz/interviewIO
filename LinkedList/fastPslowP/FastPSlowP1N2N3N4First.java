package fastPslowP;

import impl.Impl1First;
import impl.Node1;

public class FastPSlowP1N2N3N4First {

	public static void main(String[] args) {
		Node1 tail = new Node1(null, 6);
		Node1 newNode5 = new Node1(tail, 5);
		Node1 newNode4 = new Node1(newNode5, 4);
		Node1 newNode3 = new Node1(newNode4, 3);
		Node1 newNode2 = new Node1(newNode3, 2);
		Node1 newNode1 = new Node1(newNode2, 1);
		Node1 head = new Node1(newNode1, 0);
		LinkedList linkedList = new LinkedList(head, tail);
		
		linkedList.findMedian();
		linkedList.findIfCycle();
		linkedList.findLengthOfCycle();
		System.out.println(linkedList.findNToLast(8).getNumber());
		tail.setNext(newNode2);
		linkedList.findMedian();
		linkedList.findIfCycle();
		linkedList.findLengthOfCycle();
	}
}

class LinkedList extends Impl1First {
	public LinkedList(Node1 head, Node1 tail) {
		super(head, tail);
	}

	public boolean findIfCycle() {
		Node1 fastNode = getHead();
		Node1 slowNode = getHead();
		if (slowNode == null)
			return false;

		while (fastNode != null) {
			fastNode = fastNode.getNext();
			if (fastNode == slowNode) {
				System.out.println("Cyclic");
				return true;
			}
			
			if (fastNode == null) {
				break;
			}
			fastNode = fastNode.getNext();
			if (fastNode == slowNode) {
				System.out.println("Cyclic");
				return true;
			}
			slowNode = slowNode.getNext();
		}
		System.out.println("Not cyclic");
		return false;
	}

	public void findLengthOfCycle() {
		if (!findIfCycle()) {
			return;
		}
		Node1 fastNode = getHead().getNext();
		Node1 slowNode = getHead();
		
		while (fastNode != slowNode) {
			fastNode = fastNode.getNext().getNext();		
			slowNode = slowNode.getNext();
		}
		int count = 1;
		slowNode = slowNode.getNext();
		while (fastNode != slowNode) {	
			slowNode = slowNode.getNext();
			count++;
		}
		System.out.println(count);
	}
	
	public void findMedian() {
		if(findIfCycle()) return;
		
		Node1 fastNode = getHead();
		Node1 slowNode = getHead();
		
		int count = 0;
		while (fastNode != null) {
			
			fastNode = fastNode.getNext();
			if(fastNode == null) {
				break;
			}
			fastNode = fastNode.getNext();
			slowNode = slowNode.getNext();
			count++;
		}
		System.out.println(count);
	}
	
	public Node1 findNToLast(int N) {
		if(getHead() == null) return new Node1(null, -1);
		
		Node1 firstNode = getHead();
		Node1 secondNode = getHead();
		
		int count=0;
		while(count < N) {
			secondNode = secondNode.getNext();
			if(secondNode == null) return new Node1(null, -1);	
			count++;
		}
		
		while(secondNode.getNext() != null) {
			secondNode = secondNode.getNext();
			firstNode = firstNode.getNext();
		}
		
		return firstNode;
	}
}