import java.util.Random;

public class RLQueue<Item> {
	private class Node {
		Item item;
		Node next;

		public Node(Item item) {
			this.item = item;
		}
	}
	private Node first;
	private Node end;
	private Random rand = new Random(314159);
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
		int index = rand.nextInt(n);

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
			temp = curr.next.item;
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