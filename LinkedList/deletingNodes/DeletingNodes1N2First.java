package deletingNodes;

import impl.Impl1First;
import impl.Node1;

public class DeletingNodes1N2First {

	public static void main(String[] args) {
		Node1 tail = new Node1(null, 5);
		Node1 newNode4 = new Node1(tail, 4);
		Node1 newNode3 = new Node1(newNode4, 3);
		Node1 newNode2 = new Node1(newNode3, 2);
		Node1 newNode1 = new Node1(newNode2, 1);
		Node1 head = new Node1(newNode1, 0);
		LinkedList linkedList = new LinkedList(head,tail);
		linkedList.printList();
		linkedList.deleteNode(head);
		linkedList.printList();
		linkedList.deleteNode(tail);
		linkedList.printList();
		linkedList.deleteNode(newNode3);
		linkedList.printList();
	}
}

class LinkedList extends Impl1First{
	public LinkedList(Node1 head, Node1 tail) {
		super(head, tail);
	}

	public void deleteNode(Node1 prevNode, Node1 nodeToDelete) {
		if(nodeToDelete == null || getHead() == null) {
			return;
		}
		
		if(nodeToDelete == getHead()) {
			setHead(getHead().getNext());
			return;
		}
		//only after checking for 
		//head do we check for prevNode. because in case of head,
		//we don't need prevNode
		if(prevNode == null) {
			return;
		}
		
		prevNode.setNext(nodeToDelete.getNext());
		
		if(nodeToDelete == getTail())
			setTail(prevNode);
	}
	public void deleteNode(Node1 nodeToDelete) {
		if(nodeToDelete == null || getHead() == null || nodeToDelete == getTail()) return;
				
		nodeToDelete.setNumber(nodeToDelete.getNext().getNumber());
		nodeToDelete.setNext(nodeToDelete.getNext().getNext());
	}
}
