package reversingALinkedList;

import impl.Impl1Second;
import impl.Node2;

public class ReverseLinkedList1N2Second {
	static void reverseLL(Impl1Second ll) {
		if (ll.head == null || ll.head.next == null) {
			return;
		}
		Node2 prev = null;
		Node2 curr = ll.head;
		Node2 next = curr.next;

		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null)
				next = next.next;
		}
		ll.tail = ll.head;
		ll.head = prev;
	}

	static boolean palindrom(Impl1Second ll) {
		if (ll.head == null) {
			return false;
		}
		StringBuilder sb1 = buildString(ll.head);
		reverseLL(ll);
		StringBuilder sb2 = buildString(ll.head);
		return (sb1.toString().equals(sb2.toString()));
	}

	private static StringBuilder buildString(Node2 head) {
		if (head == null) {
			return null;
		}
		Node2 node = head;

		StringBuilder sb = new StringBuilder(String.valueOf(node.data));
		while (node.next != null) {
			node = node.next;
			sb.append(node.data);
		}
		return sb;
	}

	public static void main(String[] main) {
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
		System.out.println("before reverse: ");
		linkedlist.printLinkedList();
		reverseLL(linkedlist);
		System.out.println("after reverse: ");
		linkedlist.printLinkedList();

		reverseLL(linkedlist);
		linkedlist.append(node3);
		System.out.println("is palindrom: " + palindrom(linkedlist));

		linkedlist.append(node4);
		linkedlist.append(node5);
		linkedlist.append(node6);
		linkedlist.append(node7);
		System.out.println("before reverse: ");
		linkedlist.printLinkedList();
		reverseLL(linkedlist);
		System.out.println("after reverse: ");
		linkedlist.printLinkedList();

		System.out.println("is palindrom: " + palindrom(linkedlist));

	}
}
