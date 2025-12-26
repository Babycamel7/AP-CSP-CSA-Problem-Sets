public class DArrayList<Item> {
	private Item[] arr = (Item[]) new Object[8];
	private int n;

	private void resize(int size) {
		Item[] temp = (Item[]) new Object[size];
		
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i];
		}	

		arr = temp;
	}

	public int size() {
		return n;
	}

	public void add(Item item) {
		if (n == arr.length) {
			resize(arr.length * 2);
		}
		arr[n] = item;
		n++;
	}

	public void add(int index, Item item) {
		if (index < 0 || index > n) {
			throw new IndexOutOfBoundsException();
		}

		if (n == arr.length) {
			resize(arr.length * 2);
		}

		for (int i = n; i > index; i--) {
			arr[i] = arr[i - 1];
		}

		arr[index] = item;
		n++;
	}

	public Item get(int index) {
		if (index < 0 || index >= n) {
			throw new IndexOutOfBoundsException();
		}

		return arr[index];
	}

	public Item remove(int index) {
		if (index < 0 || index >= n) {
			throw new IndexOutOfBoundsException();
		}

		Item temp = arr[index];

		for (int i = index; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		} 

		arr[n - 1] = null;

		n--;

		if (n < arr.length / 4) resize(arr.length / 2);

		return temp;
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