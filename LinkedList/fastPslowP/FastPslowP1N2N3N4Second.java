package fastPslowP;

import impl.Impl1Second;
import impl.Node2;

public class FastPslowP1N2N3N4Second {
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

		Node2 node = FastPslowP1N2N3N4Second.hasCycle(head);
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

		Node2 staticNode = FastPslowP1N2N3N4Second.hasCycle(head);
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

		int cycleLength = FastPslowP1N2N3N4Second.countNodesInCycle(head);

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

		Impl1Second linkedlist = new Impl1Second();
		linkedlist.append(node1);
		linkedlist.append(node2);
		linkedlist.append(node3);
		linkedlist.append(node4);
		linkedlist.append(node5);
		linkedlist.append(node6);
		linkedlist.append(node7);
		System.out.println("initialy: " + FastPslowP1N2N3N4Second.hasCycle(linkedlist.head));
		System.out.println("number of nodes in cycle: " + FastPslowP1N2N3N4Second.countNodesInCycle(linkedlist.head));
		System.out.println("median: " + FastPslowP1N2N3N4Second.median(linkedlist.head).data);
		System.out.println("2nd to last: " + FastPslowP1N2N3N4Second.returnNthNode(linkedlist.head, 2).data);
		System.out.println();

		node7.next = node4;
		System.out.println("after cycling: " + FastPslowP1N2N3N4Second.hasCycle(linkedlist.head).data);
		System.out.println("number of nodes in cycle: " + FastPslowP1N2N3N4Second.countNodesInCycle(linkedlist.head));
		System.out.println("median: " + FastPslowP1N2N3N4Second.median(linkedlist.head));
		System.out.println("beginning of Cycle: " + FastPslowP1N2N3N4Second.beginningOfCycle(linkedlist.head).data);
		System.out.println();

		node7.next = null;
		System.out.println("after grounding: " + FastPslowP1N2N3N4Second.hasCycle(linkedlist.head));
		System.out.println("number of nodes in cycle: " + FastPslowP1N2N3N4Second.countNodesInCycle(linkedlist.head));
		System.out.println("median: " + FastPslowP1N2N3N4Second.median(linkedlist.head).data);
		System.out.println("6th to last: " + FastPslowP1N2N3N4Second.returnNthNode(linkedlist.head, 6).data);
		System.out.println("N too big: " + FastPslowP1N2N3N4Second.returnNthNode(linkedlist.head, 30));
		System.out.println("null list: " + FastPslowP1N2N3N4Second.returnNthNode(null, 3));
		System.out.println();

	}
}
