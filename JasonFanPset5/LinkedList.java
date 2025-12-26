public class LinkedList<Item> {
	private class Node {
		Node next;
		Item data;

		public Node(Item data) {
			this.data = data;
		}
	}

	private Node head;
	private int n;

	public int size() {
		return n;
	}

	public void add(Item item) {
		Node curr = head;

		if (head == null) {
			head = new Node(item);
			n++;
			return;
		}

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = new Node(item);
		n++;
	}

	public Item getMiddle() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public boolean hasCycle() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) return true;
		}
		return false;
	}

	public void reverse() {
		Node curr = head;
		Node prev = null;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}

	public void removeAll(Item key) {
		while (head != null && head.data.equals(key)) {
			head = head.next;
			n--;
		}

		Node curr = head;

		while (curr != null && curr.next != null) {
			if (curr.next.data.equals(key)) curr.next = curr.next.next;
			else curr = curr.next;
		}
	}

	public void swapInPairs() {
		if (head == null || head.next == null) return;

		Node prev = null;
		Node curr = head;
		head = head.next;

		while (curr != null && curr.next != null) {
			Node next = curr.next;
			Node nextnext = curr.next.next;

			next.next = curr;
			curr.next = nextnext;

			if (prev != null) prev.next = next;

			prev = curr;
			curr = nextnext;
		}
	}

	public static LinkedList<Integer> merge(LinkedList<Integer> li1, LinkedList<Integer> li2) {
		LinkedList<Integer>.Node curr1 = li1.head;
    	LinkedList<Integer>.Node curr2 = li2.head;

		LinkedList<Integer> result = new LinkedList<>();

		while (curr1 != null || curr2 != null) {
			if (curr1 == null) {
				result.add((int)curr2.data);
				curr2 = curr2.next;
			}
			else if (curr2 == null) {
				result.add((int)curr1.data);
				curr1 = curr1.next;
			}
			else {
				if (curr1.data > curr2.data) {
					result.add((int)curr2.data);
					curr2 = curr2.next;
				}
				else {
					result.add((int)curr1.data);
					curr1 = curr1.next;
				}
			}


		}


		return result;
	}

}