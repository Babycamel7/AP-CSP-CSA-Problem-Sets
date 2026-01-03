import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class JasonFanPset3 {
	public static void main(String[] args) {
		loadMessage();
	}
	//1
	public static int linSearch(int[] arr, int target) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	//2
	public static int binSearch(String[] arr, String target) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid].equals(target)) {
				return mid;
			}
			else if (arr[mid].compareTo(target) < 0) l = mid + 1;
			else r = mid - 1;
		}
		return -1;
	}
	//3
	public static void selSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int smallidx = i;
			for(int j = i; j < arr.length; j++) {
				if (arr[j] < arr[smallidx]) smallidx = j; 
			}
			swap(arr, i, smallidx);
		}
	}
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	//4
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for(int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) { 
					swap(arr, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) return;
		}
	}
	//5
	public static void insSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}
	//6
	public static void shellSort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < arr.length; i++) {
				int j = i;
				while (j >= gap && arr[j - gap] > arr[j]) {
					swap(arr, j, j - gap);
					j -= gap;
				}
			}
		}
	}
	//7
	public static boolean isSorted(int[] arr) {
		boolean asc = true;
		boolean desc = true;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) asc = false;
			if (arr[i] < arr[i + 1]) desc = false;
		}
		return asc || desc;
	}
	//8
	public static void dshellSort(double[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < arr.length; i++) {
				int j = i;
				while (j >= gap && arr[j - gap] > arr[j]) {
					dSwap(arr, j, j - gap);
					j -= gap;
				}
			}
		}
	}
	public static void dSwap(double[] arr, int i1, int i2) {
		double temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	public static double gymnasticScore(double[] arr) {
		dshellSort(arr);
		double avg = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			avg += arr[i];
		}
		return avg / (arr.length - 2);
	}
	//9
	public static int hottestStreak(int[] arr) {
		int max = arr[0];
		int tempMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			tempMax = Math.max(arr[i], tempMax + arr[i]);
			max = Math.max(max, tempMax);
		}
		return max * 100;
	}
	//10
	public static int moreThanQuarter(int[] arr) {
		int tempcons = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) tempcons++;
			else tempcons = 1;
			if (tempcons > arr.length / 4) return arr[i];
		}
		return -1;
	}
	//11
	public static int[] shiftElements(int[] arr) {
		int numZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) numZero++;
		}
		int[] newArr = new int[arr.length];
		int i = 0;
		int j = 0;
		while (j < arr.length) {
			newArr[j] = arr[i];
			if (arr[i] == 0) {
				newArr[j + 1] = 0;
				j++;
			}
			i++;
			j++;
		}
		return newArr;
	}
	//12
	public static void sortColors(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;
		while (mid <= high) {
			if (arr[mid] == 2) swap(arr, low++, mid++);
			else if (arr[mid] == 0) mid++;
			else swap(arr, mid, high--);
		}
	}

	//13
	public static int indexOf(String s, String key) {
		for (int i = 0; i < s.length() - key.length() + 1; i++) {
			if (key.equals(s.substring(i, i + key.length()))) return i;
		}
		return -1;
	}
	//14
	public static int rotatedMin(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] > arr[r]) l = mid + 1;
			else r = mid;
		}
		return arr[l];
	}
	//15
	public static int minBribes(int[] arr) {
		int bribes = 0;
		for (int i = 0; i < arr.length; i++) {
			int ogPos = arr[i];
			int curr = i;

			if (ogPos - (curr + 1) > 2) return -1;

			for (int j = Math.max(0, ogPos - 2); j < i; j++) {
				if (arr[j] > ogPos) bribes++;
			}
		}
		return bribes;
	}
	//16
	public static int removePoms(String[] s, int[] arr) {
		int tot = 0;
		for (int i = 1; i < arr.length; i++) {
			if (s[i].equals(s[i - 1])) tot += Math.min(arr[i], arr[i - 1]);
		}
		return tot;
	}
	//17
	public static int fineCalculator(int fine1, int fine2, String mural) {
		char[] arr = mural.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '?') {
				int j = i;
				while (j < arr.length && arr[j] == '?') j++; 

					char prev = (i > 0) ? arr[i - 1] : 0;
					char next = (j < arr.length) ? arr[j] : 0;

					char fill;
					if (prev == 0 && next == 0) fill = 'C';
					else if (prev == 0) fill = next;
					else if (next == 0) fill = prev;
					else fill = prev;

					for (int k = i; k < j; k++) {
						arr[k] = fill;
					}

					i = j - 1;

			}
		}
			int cost = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == 'C' && arr[i + 1] == 'J') cost += fine1;
				else if (arr[i] == 'J' && arr[i + 1] == 'C') cost += fine2;
		}
		return cost;
	}
	//18
	public static void prizeMoney(int n) {
		String prize = String.valueOf(n);
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();

		for (char ch : prize.toCharArray()) {
			if (ch == '6') {
				a.append('3');
				b.append('3');
			}
			else {
				a.append(ch);
				b.append('0');
			}
		}

		int check1 = Integer.parseInt(a.toString());
		int check2 = Integer.parseInt(b.toString());

		System.out.println(Integer.toString(check1) + " " + check2);
	}

	//19
	public static int calculateDamage(String[] arr) {
		int damage = 0;
		int power = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("S")) damage += power;
			else power *= 2;
		}
		return damage;
	}
	public static int swapsToSave(String[] arr, int health) {
		int damage = calculateDamage(arr);
		if (damage < health) return 0;
		int swaps = 0;
		while (damage >= health) {
			boolean swapped = false;
			for (int i = arr.length - 2; i >= 0; i--) {
				if (arr[i].equals("C") && arr[i + 1].equals("S")) {
					arr[i] = "S";
					arr[i + 1] = "C";
					swaps++;
					damage = calculateDamage(arr);
					swapped = true;
					if (damage <= health) return swaps;
				}
			}
			if (!swapped) return -1;
		}
		return swaps;
	}
	//20
	public static void loadMessage() {
		try {
			Scanner sc = new Scanner(new File("message.txt"));
			int n = Integer.parseInt(sc.nextLine());

			Message[] messages = new Message[n];

			for (int i = 0; i < n; i++) {
				int lineNum = sc.nextInt();
				int messageNum = sc.nextInt();
				String message = sc.nextLine().trim();
				messages[i] = new Message(messageNum, lineNum, message);
			}
			sc.close();

			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if (messages[j].messageNum() > messages[j + 1].messageNum() ||
						(messages[j].messageNum() == messages[j + 1].messageNum() &&
							messages[j].lineNum() > messages[j + 1].lineNum())) {
						Message temp = messages[j];
						messages[j] = messages[j + 1];
						messages[j + 1] = temp;
					}
				}
			}
			int currentMessage = -1;
			for (int i = 0; i < n; i++) {
				if (messages[i].messageNum() != currentMessage) {
					if (currentMessage != -1) System.out.println();
					currentMessage = messages[i].messageNum();
					System.out.println("Message " + currentMessage + ":");
				}
				System.out.println(messages[i].getMessage());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}