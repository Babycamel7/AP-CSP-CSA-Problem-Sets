public class LDeque<Item> {
	private class Node {
		Item item;
		Node next;
		Node prev;

		public Node(Item item) {
			this.item = item;
		}
	}
	private Node first;
	private Node end;
	private int n;

	public int size() {
		return n;
	}

	public void addFirst(Item item) {
		Node newNode = new Node(item);
		newNode.next = first;
		first.prev = newNode;
		first = newNode;
		n++;
	}

	public void addLast(Item item) {
		Node newNode = new Node(item);

		if (first == null) {
			first = newNode;
			end = newNode;
		}
		else {
			end.next = newNode;
			newNode.prev = end;
			end = newNode;
		}
		n++;
	}

	public Item removeFirst() {
		Item temp = first.item;
		if (first == end) {
			first = null;
			end = null;
		}
		else {
			first = first.next;
		}
		n--;
		return temp;
	}

	public Item removeLast() {
		Item temp = end.item;

		if (first == end) {
			first = null;
			end = null;
		}
		else {
			end = end.prev;
			end.next.prev = null;
			end.next = null;
		}
		return temp;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node curr = first;
		while (curr != null) {
			sb.append(curr.item);
			curr = curr.next;
			if (curr.next != null) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}