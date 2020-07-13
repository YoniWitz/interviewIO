package linkedHashTable;

import java.util.HashMap;

public class LinkedHashTable1First {
	public static void main(String... args) {
		LRUCache lru = new LRUCache();
		lru.saveToCache(1);
		lru.saveToCache(2);
		lru.saveToCache(3);
		lru.saveToCache(4);
		lru.saveToCache(5);
		lru.saveToCache(6);
		lru.saveToCache(2);
		
		LinkedList linked = new LinkedList();
		linked.append(new Node(1));
		System.out.println(linked.length());
	}
	
}

class LRUCache {
	HashMap<Integer, Node> integerToNodeMap;
	LinkedList integerLinkedList;

	int capacity;

	public LRUCache() {
		this(5);
	}

	public LRUCache(int capacity) {
		this.integerToNodeMap = new HashMap<Integer, Node>();
		this.integerLinkedList = new LinkedList();
		this.capacity = capacity;
	}

	public void saveToCache(Integer toCache) {
		if(toCache == null) return;
		
		Node toAppend = integerToNodeMap.get(toCache);
		// if value already present, find Node in hashmap, append Node in linkedlist and
		// update hashmap
		if (toAppend != null) {
			integerLinkedList.remove(toAppend);
			integerLinkedList.append(toAppend);
			integerToNodeMap.put(toCache, toAppend);
		}
		// if value not present:
		else {
			toAppend = new Node(toCache);
			// if cache not full to capacity, just append in linkedlist and update hashmap
			if (integerLinkedList.length() < capacity) {
				integerLinkedList.append(toAppend);
				// if cache full, kick out the head from hashmap and linkedlist, append the new
				// and update both entries in hashmap
			} else {
				integerToNodeMap.remove(integerLinkedList.head.data);
				integerLinkedList.remove(integerLinkedList.head);
				integerLinkedList.append(toAppend);
			}
			integerToNodeMap.put(toCache, toAppend);
		}
	}
}

class LinkedList {
	Node head;
	Node tail;

	public int length() {
		if (head == null)
			return -1;

		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.next;
		}

		return length;
	}

	public void remove(Node toRemove) {
		if(toRemove == null || head == null) return;
		
		if(toRemove == head) {
			head = toRemove.next;
		}
		else {
			Node prevNode = toRemove.prev;
			prevNode.next = toRemove.next;
		}
	}

//	public void append(Integer data) {
//		if(data == null) return;
//		append(new Node(data, null, null));
//	}
	// function to add node the end of linkedlist
	public void append(Node appendedNode) {
		if(appendedNode == null) return;
		
		appendedNode.next = null;
		
		if (head == null) {
			appendedNode.prev = null;
			head = appendedNode;
		} else {
			tail.next = appendedNode;
			appendedNode.prev = tail;
			
		}
		tail = appendedNode;
	}
}

class Node {
	Integer data;
	Node prev;
	Node next;

	public Node(Integer data) {
		this(data, null, null);
	}

	public Node(Integer data, Node prev, Node next) {
		super();
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}
