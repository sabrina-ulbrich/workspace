import java.util.ArrayList;
import java.util.List;

/**
 * Algorithmen und Datenstrukturen Blatt 08 Aufgabe 3
 * (C) HU Berlin, Andre Koschmieder
 *
 * Generic Fibonacci Heap implementation that can contain
 * arbitrary elements which are only required to be comparable:
 * <E extends Comparable<? super E>> means that E can be any class that
 * implements the Comparable interface (provides the compareTo() method)
 * with E or an ancestor class of E.
 *
 * See FibHeapTest.java for a test case implementation.
 */
public class FibHeap<E extends Comparable<? super E>>
{
	/**
	 * A node in the Fibonacci Heap that represents one element.
	 */
	public static final class Node<E extends Comparable<? super E>>
	{
		private E data;
		private boolean bMarked;
		private int degree;
		private Node<E> parent;
		private Node<E> child;
		private Node<E> left;
		private Node<E> right;

		private Node(E data) {
			this.data = data;
			this.left = this.right = this;
		}

		public E getData() {
			return data;
		}

		public void setData(E value) {
			data = value;
		}

		private void printRecursive(int level,boolean bFirst)
		{
			if (bFirst) System.out.print("- ");
			else {
				for (int i = 0; i < level; i++) System.out.print("     ");
				System.out.print("\\ ");
			}
			System.out.print(data+(bMarked?"*":" "));
			if (child == null) System.out.println();
			else {
				Node<E> n = child;
				do {
					n.printRecursive(level+1,n==child);
					n = n.right;
				} while (n != child);
			}
		}
	}

	private Node<E> minRoot;
	private int numNodes;

	/**
	 * Print a textual representation of the Fibonacci Heap.
	 */
	public void print()
	{
		if (minRoot == null) System.out.println("* FibHeap is EMPTY.");
		else {
			System.out.println("* FibHeap content:");
			Node<E> n = minRoot;
			do {
				n.printRecursive(0,n==minRoot);
				n = n.right;
			} while (n != minRoot);
		}
	}

	/**
	 * Add an element to the Fibonacci Heap. A new node containing the
	 * element is added to the root list and the minimum element is updated.
	 * This method runs in O(1) time.
	 * @return the newly created FibHeap node
	 */
	public Node<E> add(E element)
	{
		Node<E> node = new Node<E>(element);
		minRoot = mergeLists(minRoot,node);
		numNodes++;
		return node;
	}

	/**
	 * Get the minimum element of the heap in O(1).
	 * @return the FibHeap node with the minimum element or
	 *         null, if the heap is empty
	 */
	public Node<E> getMin() {
		return minRoot;
	}

	/**
	 * Remove the node with the minimum element, add its children to the
	 * root list, update the minimum node and consolidate the root list.
	 * This method runs in O(log numNodes) amortized time.
	 * @return the FibHeap node with the minimum element or
	 *         null, if the heap is empty
	 */
	public Node<E> extractMin()
	{
		Node<E> result = minRoot;
		if (result != null)
		{
			numNodes--;
			if (result.left == result) minRoot = null;
			else {
				result.left.right = result.right;
				result.right.left = result.left;
				minRoot = result.right;
			}
			if (result.child != null)
			{
				for (Node<E> cur = result.child; cur.parent != null; cur = cur.right)
					cur.parent = null;
				minRoot = mergeLists(minRoot,result.child);
			}
			if (minRoot != null)
			{
				Node<E> start = minRoot;
				Node<E> node = start;
				do {
					node = node.right;
					if (node.data.compareTo(minRoot.data) < 0) minRoot = node;
				} while (node != start);
				consolidate();
			}
		}
		return result;
	}

	/**
	 * Decrease the key of the given node to the given value.
	 * Recursively cut nodes that do not fulfill the heap property
	 * or have lost two children, and update the minimum node.
	 * This method runs in O(1) amortized time.
	 */
	public void decreaseKey(Node<E> node,E newValue)
	{
		if (newValue.compareTo(node.data) >= 0) return;
		node.data = newValue;
		Node<E> parent = node.parent;
		if ((parent != null) && (newValue.compareTo(parent.data) < 0))
			cut(node,parent);
		if (newValue.compareTo(minRoot.data) < 0) minRoot = node;
	}


	/**
	 * Merge two doubly linked lists (or null references).
	 * If not null, the given references must be the 
	 * smallest elements in the respective list.
	 * This method runs in O(1) time.
	 * @return a reference to the given nodes with smaller element
	 *         with both lists merged, or
	 *         null, if both lists are null
	 */
	private Node<E> mergeLists(Node<E> list1,Node<E> list2)
	{
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		Node<E> tmp = list1.left;
		list1.left = list2.left;
		list1.left.right = list1;
		list2.left = tmp;
		tmp.right = list2;
		if (list1.data.compareTo(list2.data) <= 0) return list1;
		return list2;
	}

	/**
	 * Consolidate the root list of the Fibonacci Heap so that
	 * there are no two nodes with the same number of children.
	 */
	private void consolidate()
	{
		// To manage the ranks, you can use the following ArrayList.
		// The maximum possible degree is 2*log(numNodes).
		int maxDegree = 2*log2(numNodes)+1;
		List<Node<E>> table = new ArrayList<Node<E>>(maxDegree);
		for (int i = 0; i < maxDegree; i++) table.add(null);

		// ToDo: Aufgabenteil a)
		Node<E> start = minRoot;
		Node<E> current = start;
		Node<E> x;
		do {
			while(table.get(current.degree) != null) {
				x = table.get(current.degree);
				table.set(x.degree, null);
				if (x.data.compareTo(current.data) <= 0) {
					current.right.left = x;
					x.left.right = current;
					current.left = x.left;
					x.right = current.right;
					x.left = current;
					current.right = x;
					Node<E> tmp = current;
					current = x;
					x = tmp;
				}
				x.left.right = current;
				current.left = x.left;
				x.parent = current;
				if(current.child != null) {
					Node<E> old = current.child;
					x.right = old;
					x.left = old.left;
					Node<E> tmp = old.left;
					old.left = x;
					tmp.right = x;
					if (x.data.compareTo(current.child.data) <= 0) current.child = x;
				} else {
					current.child = x;
					x.left = x.right = x;
				}
				current.degree += 1;
			}
			table.set(current.degree, current);
			current = current.right;
		}while (current != start); 

		minRoot = null;
		for (int i = 0; i < maxDegree; i++) {
			if(table.get(i) != null) {
				table.get(i).left = table.get(i).right = table.get(i);
				if(minRoot == null) {
					minRoot = table.get(i);
				} else {
					minRoot = mergeLists(minRoot, table.get(i));
				}
			}
		}
	}
	
	private int log2(int n)
	{
		int result = 0;
		while ((n >>= 1) > 0) result++;
		return result;
	}

	/**
	 * Cut the given node from its parent and add it to the root list.
	 * If the parent had already lost a child (is marked), recursively
	 * cut it from its parent and also add it to the root list.
	 */
	private void cut(Node<E> node,Node<E> parent)
	{
		// ToDo: Aufgabenteil b)
		boolean mark = false;
		if(parent == null) return;
		if(node.bMarked == true) node.bMarked = false;
		if(parent.bMarked == true) mark = true;
		if(parent.bMarked == false && parent.parent != null) parent.bMarked = true;
		parent.degree -= 1;
		node.parent = null;
		if(node.left != node) {
			node.left.right = node.right;
			node.right.left = node.left;
		} else {
			parent.child = null;
		}
		node.left = node.right = node;
		minRoot = mergeLists(minRoot, node);
		if(mark == true) cut(parent, parent.parent);
	}
}