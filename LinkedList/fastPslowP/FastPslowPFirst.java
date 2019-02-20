package fastPslowP;

import implAndAppend.LinkedList2;
import implAndAppend.Node2;

public class FastPslowPFirst {
	static Node2 hasCycle(Node2 head) { // returning node for next functions
		if (head == null || head.next == null) {
			return null;
		}
		Node2 fastP = head;
		Node2 slowP = head;

		while (fastP != null) {
			for (int i = 0; i < 2; i++) {
				fastP = fastP.next;
				if (fastP == null) {
					return null;
				}
				if (fastP == slowP) {
					return slowP;
				}
			}
			slowP = slowP.next;
		}
		return null;
	}

	static Node2 median(Node2 head) {
		if (head == null) {
			return null;
		}

		Node2 node = FastPslowPFirst.hasCycle(head);
		if (node != null)
			return null;
		Node2 fastP = head;
		Node2 slowP = head;

		while (fastP != null) {
			for (int i = 0; i < 2; i++) {
				fastP = fastP.next;
				if (fastP == null)
					break;
			}
			slowP = slowP.next;
		}
		return slowP;
	}

	static int countNodesInCycle(Node2 head) {
		if (head == null) {
			return 0;
		}

		Node2 staticNode = FastPslowPFirst.hasCycle(head);
		if (staticNode == null)
			return 0;

		Node2 node = staticNode.next;
		int count = 1;
		while (node != staticNode) {
			node = node.next;
			count++;
		}
		return count;
	}

	static Node2 returnNthNode(Node2 head, int n) {
		Node2 frontP = head;
		for (int i = 0; i < n; i++) {
			if (frontP == null)
				return null;
			frontP = frontP.next;
		}

		Node2 backP = head;
		while (frontP.next != null) {
			frontP = frontP.next;
			backP = backP.next;
		}

		return backP;
	}

	static Node2 beginningOfCycle(Node2 head) {
		if (head == null) {
			return null;
		}

		int cycleLength = FastPslowPFirst.countNodesInCycle(head);

		Node2 frontP = head;
		for (int i = 0; i < cycleLength; i++) {
			frontP = frontP.next;

		}
		Node2 backP = head;
		while (backP != frontP) {
			backP = backP.next;
			frontP = frontP.next;
		}
		return backP;
	}

	public static void main(String[] args) {
		Node2 node1 = new Node2(1);
		Node2 node2 = new Node2(0);
		Node2 node3 = new Node2(1);
		Node2 node4 = new Node2(4);
		Node2 node5 = new Node2(5);
		Node2 node6 = new Node2(1);
		Node2 node7 = new Node2(0);

		LinkedList2 linkedlist = new LinkedList2();
		linkedlist.append(node1);
		linkedlist.append(node2);
		linkedlist.append(node3);
		linkedlist.append(node4);
		linkedlist.append(node5);
		linkedlist.append(node6);
		linkedlist.append(node7);
		System.out.println("initialy: " + FastPslowPFirst.hasCycle(linkedlist.head));
		System.out.println("number of nodes in cycle: " + FastPslowPFirst.countNodesInCycle(linkedlist.head));
		System.out.println("median: " + FastPslowPFirst.median(linkedlist.head).data);
		System.out.println("2nd to last: " + FastPslowPFirst.returnNthNode(linkedlist.head, 2).data);
		System.out.println();

		node7.next = node4;
		System.out.println("after cycling: " + FastPslowPFirst.hasCycle(linkedlist.head).data);
		System.out.println("number of nodes in cycle: " + FastPslowPFirst.countNodesInCycle(linkedlist.head));
		System.out.println("median: " + FastPslowPFirst.median(linkedlist.head));
		System.out.println("beginning of Cycle: " + FastPslowPFirst.beginningOfCycle(linkedlist.head).data);
		System.out.println();

		node7.next = null;
		System.out.println("after grounding: " + FastPslowPFirst.hasCycle(linkedlist.head));
		System.out.println("number of nodes in cycle: " + FastPslowPFirst.countNodesInCycle(linkedlist.head));
		System.out.println("median: " + FastPslowPFirst.median(linkedlist.head).data);
		System.out.println("6th to last: " + FastPslowPFirst.returnNthNode(linkedlist.head, 6).data);
		System.out.println("N too big: " + FastPslowPFirst.returnNthNode(linkedlist.head, 30));
		System.out.println("null list: " + FastPslowPFirst.returnNthNode(null, 3));
		System.out.println();

	}
}
