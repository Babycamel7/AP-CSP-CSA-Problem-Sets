public class LStack<Item> {
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

	public void push(Item item) {
		Node newNode = new Node(item);
		newNode.next = first;
		first = newNode;
		n++;
	}

	public Item peek() {
		if (first == null) throw new Error("Cannot peek at empty stack");
		return first.item;
	}

	public Item pop() {
		if (first == null) throw new Error("Cannot pop an empty stack");
		Item temp = first.item;
		first = first.next;
		n--;
		return temp;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node curr = first;
		while (curr != null) {
			sb.append(curr.item);
			curr = curr.next;
			if (curr != null) sb.append(", ");
		}
		sb.append("]")
		return sb.toString();
	}
}