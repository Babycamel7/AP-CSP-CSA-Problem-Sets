import java.util.Random;
import java.util.Arrays;

public class RArrayQueue<Item> {
	private Item[] arr = (Item[]) new Object[8];
	private int n;
	private Random rand = new Random(314159);

	private void resize(int size) {
		Item[] temp = (Item[]) new Object[size];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i % arr.length];
		}
		arr = temp;
	}

	public void enqueue(Item item) {
		if (n == 2 * arr.length) {
			resize(2 * arr.length);
		}
		arr[n++] = item;
	}

	public Item dequeue() {
		if (n == 0) throw new Error("Cannot dequeue from an empty queue");

		int index = rand.nextInt(n);
		Item temp = arr[index];
		arr[index] = arr[n - 1];
		arr[n - 1] = null;
		n--;

		if (n == arr.length / 4) resize(arr.length / 2);

		return temp;
	}

	public Item sample() {
		if (n == 0) throw new Error("Cannot sample an empty queue");

		int index = rand.nextInt(n);
		return arr[index];
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