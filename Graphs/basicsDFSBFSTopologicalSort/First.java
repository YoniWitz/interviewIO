package basicsDFSBFSTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class First {

	public static void main(String[] args) {
		Graph myGraph = new Graph();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);

		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node4);
		node3.neighbors.add(node5);
		node3.neighbors.add(node4);
		node4.neighbors.add(node6);
		node5.neighbors.add(node6);
		node7.neighbors.add(node8);
		node1.neighbors.add(node7);

		myGraph.nodes.add(node1);
		// myGraph.nodes.add(node7);
		myGraph.nodes.add(node9);

		// 124635789
		System.out.print("first dfs traverse: ");
		myGraph.dfs();

		System.out.println("find 11 in first graph: " + myGraph.findT(11));
		System.out.println("find 8 in first graph: " + myGraph.findT(8));

		Graph myClonedGraph = myGraph.cloneGraph();
		myClonedGraph.nodes.get(0).data = 10000;

		// 124635789
		System.out.print("dfs traverse first graph after clone: ");
		myGraph.dfs();
		// 100024635789
		System.out.print("dfs traverse cloned graph: ");
		myClonedGraph.dfs();

		// 100092345678
		System.out.print("bfs traverse cloned graph: ");
		myClonedGraph.bfs();

		// 100023456789
		System.out.println("bfs traverse cloned graph from 2nd level: ");
		myClonedGraph.bfsFromN(node2);

		Node sortNode1 = new Node(1);
		Node sortNode2 = new Node(2);
		Node sortNode3 = new Node(3);
		Node sortNode4 = new Node(4);
		Node sortNode5 = new Node(5);

		sortNode1.neighbors.add(sortNode2);
		sortNode1.neighbors.add(sortNode4);
		sortNode2.neighbors.add(sortNode4);
		sortNode2.neighbors.add(sortNode5);
		sortNode2.neighbors.add(sortNode3);
		sortNode3.neighbors.add(sortNode5);

		Graph topologicalSort = new Graph();
		topologicalSort.nodes.add(sortNode1);
		System.out.println("minimum semesters: " + topologicalSort.minimumSemesters());
	}
}

class Graph {
	List<Node> nodes = new ArrayList<>();

	public boolean findT(int T) {
		for (Node node : nodes) {
			if (node.findT(T, false)) {
				cleanUpGraph();
				return true;
			}
		}
		cleanUpGraph();
		return false;
	}

	public int minimumSemesters() {
		Stack<Node> topologicallySorted = topologicalSort();
		int[] sortedCourses = new int[topologicallySorted.size()];
		sortedCourses[0] = 1;

		while (!topologicallySorted.isEmpty()) {
			Node node = topologicallySorted.pop();

			for (Node neighbor : node.neighbors) {
				sortedCourses[neighbor.data - 1] = Math.max(sortedCourses[neighbor.data - 1], sortedCourses[node.data - 1] + 1);
			}
		}

		return sortedCourses[sortedCourses.length - 1];
	}

	public Stack<Node> topologicalSort() {
		Stack<Node> topologicallySorted = new Stack<>();

		for (Node node : nodes) {
			addNeighborsToStack(topologicallySorted, node);
		}

		cleanUpGraph();
		return topologicallySorted;
	}

	public void addNeighborsToStack(Stack<Node> stack, Node node) {
		if (node.status == Status.UNVISITED) {
					
			for (Node neighbor : node.neighbors) {
				addNeighborsToStack(stack, neighbor);
			}
			node.status = Status.VISITED;
			stack.add(node);
		}
	}

//	public int graphDiameter() {
//		int max = 0;
//		
//		for (Node node : nodes) {
//			max = Math.max(max, nodeDiameter(node));
//		}
//
//		cleanUpGraph();
//		
//		return max;
//	}
	
//	public int nodeDiameter(Node node) {
//		for()
//	}
	
	public void dfs() {
		for (Node node : nodes) {
			node.dfVisit();
		}
		cleanUpGraph();
		System.out.println();
	}

	public void bfs() {
		Queue<Node> bfsQueue = new LinkedList<>();
		Node current;
		for (Node node : nodes) {
			bfsQueue.add(node);
			while (!bfsQueue.isEmpty()) {
				current = bfsQueue.remove();
				if (current.status == Status.UNVISITED) {
					current.status = Status.VISITED;
					System.out.print(current.data + " ");
					for (Node neighbor : current.neighbors) {
						bfsQueue.add(neighbor);
					}
				}
			}
		}
		cleanUpGraph();
		System.out.println();
	}

	public void bfsFromN(Node N) {
		Queue<Node> bfsQueue = new LinkedList<>();
		Node current;
		bfsQueue.add(N);

		Node bogus = new Node(0);
		bfsQueue.add(bogus);

		while (!bfsQueue.isEmpty()) {
			current = bfsQueue.remove();
			if (current == bogus) {
				System.out.println();
				if (bfsQueue.isEmpty())
					return;
				bfsQueue.add(current);
			} else if (current.status == Status.UNVISITED) {
				current.status = Status.VISITED;

				System.out.print(current.data);
				for (Node neighbor : current.neighbors) {
					bfsQueue.add(neighbor);
				}
			}
		}
	}

	private void cleanUpGraph() {
		for (Node node : nodes) {
			node.cleanUpNode();
		}
	}

	public Graph cloneGraph() {
		Graph clonedGraph = new Graph();
		for (Node node : nodes) {
			Node clonedNode = node.cloneNode();
			clonedGraph.nodes.add(clonedNode);
		}
		cleanUpGraph();
		return clonedGraph;
	}
}

class Node {
	List<Node> neighbors = new ArrayList<>();
	int data;
	Status status = Status.UNVISITED;

	public Node(int data) {
		this.data = data;
	}

	public void dfVisit() {
		if (status == Status.UNVISITED) {
			status = Status.VISITED;
			System.out.print(data + " ");
			for (Node neighbor : neighbors) {
				neighbor.dfVisit();
			}
		}
	}

	public boolean findT(int T, boolean found) {
		if (status == Status.UNVISITED) {
			status = Status.VISITED;
			if (data == T)
				return true;

			for (Node neighbor : neighbors) {
				found = neighbor.findT(T, found);
				if (found)
					return true;
			}
		}
		return found;
	}

	public Node cloneNode() {
		Node clonedNode = null;
		if (status != Status.VISITED) {
			status = Status.VISITED;
			List<Node> clonedNeighbors = new ArrayList<>();
			clonedNode = new Node(data);
			for (Node neighbor : neighbors) {
				Node clonedNeighbor = neighbor.cloneNode();
				if (clonedNeighbor != null)
					clonedNeighbors.add(clonedNeighbor);
			}
			clonedNode.neighbors = clonedNeighbors;
		}
		return clonedNode;
	}

	public void cleanUpNode() {
		if (status != Status.UNVISITED) {
			status = Status.UNVISITED;
			for (Node neighbor : neighbors) {
				neighbor.cleanUpNode();
			}
		}
	}
}

enum Status {
	UNVISITED, VISITING, VISITED;
}
