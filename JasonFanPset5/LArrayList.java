public class LArrayList<Item> {
	private class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}
	private Node first;
	private int n;

	public int size() {
		return n;
	}

	public void add(Item item) {
		if (n == 0) {
			first = new Node(item);
		}
		else {
			Node curr = first;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(item);
		}
		n++;
	}
	public void add(int index, Item item) {
		if (index < 0 || index >= n) throw new IndexOutOfBoundsException();

		Node newNode = new Node(item);
		
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		}
		else {
			Node curr = first;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;
		}
	n++;
	}
	public Item get(int index) {
		if (index < 0 || index >= n) throw new IndexOutOfBoundsException();

		Node curr = first;

		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}

		return curr.item;
	}

	public Item set(int index, Item item) {
		if (index < 0 || index >= n) throw new IndexOutOfBoundsException();

		Node curr = first;

		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}

		Item temp = curr.item;
		curr.item = item;
		return temp;
	}

	public Item remove(int index) {
		if (index < 0 || index >= n) throw new IndexOutOfBoundsException();

		Item temp;

		if (index == 0) {
			temp = first.item;
			first = first.next;
		}

		else {
			Node curr = first;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			temp = curr.next;
			curr.next = curr.next.next;
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