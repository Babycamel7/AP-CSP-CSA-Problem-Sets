public class LQueue<Item> {
	private class Node {
		Item item;
		Node next;

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

	public void enqueue(Item item) {
		Node newNode = new Node(item);

		if (first == null) {
			first = newNode;
			end = newNode;
		}
		else {
			end.next = newNode;
			end = newNode;
		}
		n++;
	}

	public Item dequeue() {
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

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node curr = first;
		while (curr != null) {
			sb.append(curr.item);
			if (curr.next != null) sb.append(", ");
			curr = curr.next;
		}
		sb.append("]");
		return sb.toString();
	}
}