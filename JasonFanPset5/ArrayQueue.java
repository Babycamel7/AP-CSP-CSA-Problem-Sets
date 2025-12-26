public class ArrayQueue<Item> {
	private Item[] arr = (Item[]) new Object[8];
	private int n;
	private int s, e;

	private void resize(int size) {
		Item[] temp = (Item[]) new Object[size];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[(i + s) % arr.length];
		}
		arr = temp;
		s = 0;
		e = n;
	}

	public int size() {
		return n;
	}


	public void enqueue(Item x) {
		if (n == arr.length) resize(arr.length * 2);
		arr[e] = x;
		e = (e + 1) % arr.length;
		n++;
	}
	public Item dequeue() {
		if (n == 0) throw new Error("Cannot dequeue from an empty queue");
		Item item = arr[s];
		arr[s] = null;
		s = (s + 1) % arr.length;
		n--;

		if (n > 0 && n == arr.length / 4) {
			resize(arr.length / 2);
		}

		return item;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < n; i++) {
			if (i != n - 1) sb.append(arr[(i + s) % arr.length] + ", ");
			else sb.append(arr[(i + s) % arr.length] + "]");
		}
		return sb.toString();
	}
}