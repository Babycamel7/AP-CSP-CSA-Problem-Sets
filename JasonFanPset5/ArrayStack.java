public class ArrayStack<Item> {
	private Item[] arr = (Item[]) new Object[8];
	private int n;

	private void resize(int len) {
		Item[] temp = (Item[]) new Object[len];
		
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i];
		}	

		arr = temp;
	}

	public int size() {
		return n;
	}

	public void push(Item item) {
		if (n == arr.length) {
			resize(arr.length * 2);
		}
		arr[n] = item;
		n++;
	}

	public Item pop() {
		if (n == 0) return null;
		Item temp = arr[n - 1];
		arr[n - 1] = null;
		n--;
		if (n < arr.length / 4) {
			resize(arr.length / 2);
		}
		return temp;
	}

	public Item peek() {
		return arr[n - 1];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < n; i++) {
			if (i != n - 1) sb.append(arr[i] + ", ");
			else sb.append(arr[i] + "]");
		}
		return sb.toString();
	}
}