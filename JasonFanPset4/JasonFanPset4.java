import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class JasonFanPset4 {
	public static String twoDArrayToString(String[][] a) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < a.length; r++) {
			sb.append(Arrays.toString(a[r]) + "\n");
		}
		return sb.toString();
	}
	//1
	public static int[][] addMatricies(int[][] arr1, int[][] arr2) {
		int[][] newArr = new int[arr1.length][arr1[0].length];
		for (int r = 0; r < arr1.length; r++) {
			for (int c = 0; c < arr1[0].length; c++) {
				newArr[r][c] = arr1[r][c] + arr2[r][c];
			}
		}
		return newArr;
	}
	//2
	public static int[][] mulMatricies(int[][] a, int[][] b) {
		int[][] newArr = new int[a.length][b[0].length];

		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < b[0].length; c++) {
				for (int k = 0; k < a[0].length; k++) {
					newArr[r][c] += a[r][k] + b[k][c];
				}
			}
		}
		return newArr;

	}
	//3
	public static int[][] transposeMatrix(int[][] a) {
		int[][] newArr = new int[a[0].length][a.length];
		for (int c = 0; c < a[0].length; c++) {
			for (int r = 0; r < a.length; r++) {
				newArr[c][r] = a[r][c];
			}
		}
		return newArr;
	}
	//4
	public static boolean isDiagonal(int[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				if (r == c) continue;
				else if (a[r][c] != 0) return false; 
			}
		}
		return true;
	}
	//5
	public static String[][] randomWalker(int n) {
		String[][] box = new String[2 * n + 1][2 * n + 1];
		for (int r = 0; r < 2 * n + 1; r++) {
			for (int c = 0; c < 2 * n + 1; c++) {
				box[r][c] = " ";
			}
		}
		int x = 0;
		int y = 0;

		box[n][n] = "#";
		Random rand = new Random();

		while (Math.abs(x) <= n && Math.abs(y) <= n) {
			int direction = rand.nextInt(4);

			if (direction == 0) y++;
			if (direction == 1) y--;
			if (direction == 2) x++;
			if (direction == 3) x--;

			if (Math.abs(x) <= n && Math.abs(y) <= n) {
				box[n - y][n + x] = "#";
			}
		}
		return box;
	}
	//6
	public static int randomWalkerNum(int n) {
		int x = 0;
		int y = 0;

		int nums = 0;
		Random rand = new Random();

		while (Math.abs(x) <= n && Math.abs(y) <= n) {
			nums++;
			int direction = rand.nextInt(4);

			if (direction == 0) y++;
			if (direction == 1) y--;
			if (direction == 2) x++;
			if (direction == 3) x--;
		}
		return nums;
	}
	public static double numWalks(int n) {
		int tries = 1000;
		double avg = 0;
		for (int i = 0; i < tries; i++) {
			avg += randomWalkerNum(n);
		}
		return avg / tries;
	}
	//7
	public static boolean isFilled(boolean[][] a) {
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				if (a[r][c] == false) return false;
			}
		}
		return true;
	}
	public static int walkerWalls(int n) {
		boolean[][] a = new boolean[2 * n + 1][2 * n + 1];
		int x = 0;
		int y = 0;
		a[n][n] = true;

		int nums = 0;
		Random rand = new Random();

		while (!isFilled(a)) {
			nums++;
			int direction = rand.nextInt(4);

			if (direction == 0 && y < n) y++;
			if (direction == 1 && y > -n) y--;
			if (direction == 2 && x < n) x++;
			if (direction == 3 && x > -n) x--;

			a[n - y][n + x] = true;
		}
		return nums;
	}
	//8
	public static String[][] randomWalkerEnd(int n) {
		String[][] box = new String[2 * n + 1][2 * n + 1];
		for (int r = 0; r < 2 * n + 1; r++) {
			for (int c = 0; c < 2 * n + 1; c++) {
				box[r][c] = " ";
			}
		}
		int x = 0;
		int y = 0;

		box[n][n] = "#";
		Random rand = new Random();

		while (Math.abs(x) <= n && Math.abs(y) <= n) {
			int direction = rand.nextInt(4);

			if (direction == 0) y++;
			if (direction == 1) y--;
			if (direction == 2) x++;
			if (direction == 3) x--;

			if (box[n - y][n + x].equals("#")) break;

			if (Math.abs(x) <= n && Math.abs(y) <= n) {
				box[n - y][n + x] = "#";
			}

		}
		return box;
	}
	//9
	public static int randomWalkerEndNum(int n) {
		String[][] box = new String[2 * n + 1][2 * n + 1];
		for (int r = 0; r < 2 * n + 1; r++) {
			for (int c = 0; c < 2 * n + 1; c++) {
				box[r][c] = " ";
			}
		}
		int x = 0;
		int y = 0;

		int num = 0;

		box[n][n] = "#";
		Random rand = new Random();

		while (Math.abs(x) <= n && Math.abs(y) <= n) {
			int direction = rand.nextInt(4);

			if (direction == 0) y++;
			if (direction == 1) y--;
			if (direction == 2) x++;
			if (direction == 3) x--;

			if (box[n - y][n + x].equals("#")) break;
			num++;
			if (Math.abs(x) <= n && Math.abs(y) <= n) {
				box[n - y][n + x] = "#";
			}

		}
		return num;
	}
	public static double numWalksAvoiding(int n) {
		int tries = 1000;
		double avg = 0;
		for (int i = 0; i < tries; i++) {
			avg += randomWalkerNum(n);
		}
		return avg / tries;
	}
	//10
	public static boolean ticTacToeCheck(String[][] board) {
		for (int r = 0; r < 3; r++) {
			if (board[r][0].equals(board[r][1]) && board[r][0].equals(board[r][2]) && !board[r][0].equals(" ")) {
				return true;
			}
		}
		for (int c = 0; c < 3; c++) {
			if (board[0][c].equals(board[1][c]) && board[0][c].equals(board[2][c]) && !board[0][c].equals(" ")) {
				return true;
			}
		}
		if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(" ")) {
			return true;
		}
		if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(" ")) {
			return true;
		}
		return false;
	}
	public static void ticTacToe() {
		String[][] board = new String[3][3];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length; c++) {
				board[r][c] = " ";
			}
		}
		boolean isX = true;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(twoDArrayToString(board));
			if (ticTacToeCheck(board)) {
				System.out.println("Winner!");
				sc.close();
				break;
			}
			System.out.println("Pick your row (1-3): ");
			int row = Integer.parseInt(sc.nextLine()) - 1;
			System.out.println("Pick your column (1-3): ");
			int col = Integer.parseInt(sc.nextLine()) - 1;
			if (isX) board[row][col] = "X";
			else board[row][col] = "O";
			if (isX) isX = false;
			else isX = true;
		}
	}
	//11
	public static void slidingPuzzle() {
		int[][] puzzle = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 0, 8}
		};

		Scanner sc = new Scanner(System.in);
		System.out.println("use wasd to move");

		while (true) {
			printPuzzle(puzzle);
			if (Arrays.deepEquals(new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 0}
			}, puzzle)) {
				System.out.println("Winner ! yippee");
				break;
		}

			System.out.println("do wasd");
			char move = sc.nextLine().charAt(0);

			moveTile(puzzle, move);
		}
		sc.close();
	}
	public static void printPuzzle(int[][] puzzle) {
		for (int[] row : puzzle) {
			for (int val : row) {
				System.out.print((val == 0 ? " " : val) + " ");
			}
			System.out.println();
		}
	}
	public static void moveTile(int[][] puzzle, char move) {
		int r = 0;
		int c = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (puzzle[i][j] == 0) {
					r = i;
					c = j;
				}
			}
		}
		int newRow = r;
		int newCol = c;
		if (move == 'w') newRow++;
		if (move == 's') newRow--;
		if (move == 'a') newCol++;
		if (move == 'd') newCol--;

		int temp = puzzle[newRow][newCol];
		puzzle[newRow][newCol] = 0;
		puzzle[r][c] = temp;
	}
	//12
	public static void play2048() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(67);
		int[][] board = new int[4][4];
		int score = 0;

		addRandomTile(board, rand);
		addRandomTile(board, rand);
		
		int[][] oldBoard = new int[4][4];
		while (true) {
			addRandomTile(board, rand);
			print2048(board, score);
			if (has2048(board)) {
				System.out.println("nah i'd win");
				break;
			}
			if (!canMove(board)) {
				System.out.println("nah you'd losse");
				break;
			}

			System.out.print("use wasd");
			char move = sc.nextLine().charAt(0);
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) oldBoard[r][c] = board[r][c];
			}
			if (move == 'w') score += moveUp(board);
			if (move == 's') score += moveDown(board);	
			if (move == 'a') score += moveLeft(board);
			if (move == 'd') score += moveRight(board);
		}

		if (!Arrays.deepEquals(oldBoard, board)) {
			addRandomTile(board, rand);
		}
		sc.close();
	}
	public static void print2048(int[][] board, int score) {
		System.out.println("Score: " + score);
		for (int[] row : board) {
			for (int v : row) {
				String s = (v == 0) ? "." : Integer.toString(v);
				System.out.print(" " + s + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void addRandomTile(int[][] board, Random random) {
		int numpty = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] == 0) numpty++;
			}
		}

		int choice = random.nextInt(numpty);
		int val = (random.nextInt(10) == 0) ? 4 : 2;
		int count = 0;

		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c] == 0) {
					if (count == choice) {
						board[r][c] = val;
						return;
					}
					count++;
				}
			}
		}
	}

	public static boolean has2048(int[][] board) {
		for (int[] r : board) {
			for (int v : r) {
				if (v == 2048) return true;
			}
		}
		return false;
	}

	public static boolean canMove(int[][] board) {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				if (board[r][c] == 0) return true;
				if (r < 3 && board[r][c] == board[r + 1][c]) return true;
				if (c < 3 && board[r][c] == board[r][c + 1]) return true;
			}	
		}
		return false;
	}

	public static int moveUp(int[][] board) {
		int score = 0;
		for (int c = 0; c < 4; c++) {
			int[] col = new int[4];
			for (int r = 0; r < 4; r++) col[r] = board[r][c];

			score += compressAndMerge(col);
			for (int r = 0; r < 4; r++) board[r][c] = col[r];
		}
		return score;
	}
	public static int moveDown(int[][] board) {
		int score = 0;
		for (int c = 0; c < 4; c++) {
			int[] col = new int[4];
			for (int r = 0; r < 4; r++) col[r] = board[3 - r][c];

			score += compressAndMerge(col);
			for (int r = 0; r < 4; r++) board[3 - r][c] = col[r];
		}
		return score;
	}
	public static int moveLeft(int[][] board) {
		int score = 0;
		for (int r = 0; r < 4; r++) {
			int[] row = board[r].clone();

			score += compressAndMerge(row);
			board[r] = row;
		}
		return score;
	}
	public static int moveRight(int[][] board) {
		int score = 0;
		for (int r = 0; r < 4; r++) {
			int[] row = new int[4];
			for (int c = 0; c < 4; c++) row[c] = board[r][3 - c];
			score += compressAndMerge(row);
			for (int c = 0; c < 4; c++) board[r][3 - c] = row[c];
		}
		return score;
	}
	public static int compressAndMerge(int[] arr) {
		int score = 0;

		int[] li = new int[4];
		int idx = 0;
		for (int n : arr) {
			if (n != 0) li[idx++] = n;
		}
		for (int i = 0; i < 3; i++) {
			if (li[i] != 0 && li[i] == li[i + 1]) {
				li[i] *= 2;
				score += li[i];
				li[i + 1] = 0;
			}
		}
		int[] newArr = new int[4];
		idx = 0;
		for (int n : li) {
			if (n != 0) newArr[idx++] = n;
		}

		for (int i = 0; i < 4; i++) arr[i] = newArr[i];

		return score;
	}
	//13
	public static void playSudoku() {
		int[][] board = {
			{5, 3, 0, 0, 7, 0, 0, 0, 0},
			{6, 0, 0, 1, 9, 5, 0, 0, 0},
			{0, 9, 8, 0, 0, 0, 0, 6, 0},
			{8, 0, 0, 0, 6, 0, 0, 0, 3},
			{4, 0, 0, 8, 0, 3, 0, 0, 1},
			{7, 0, 0, 0, 2, 0, 0, 0, 6},
			{0, 6, 0, 0, 0, 0, 2, 8, 0},
			{0, 0, 0, 4, 1, 9, 0, 0, 5},
			{0, 0, 0, 0, 8, 0, 0, 7, 9}
		};
		Scanner sc = new Scanner(System.in);
		while (true) {
			printSudoku(board);
			if (sudokuIsSolved(board)) {
				System.out.println("contrats gng");
				break;
			}
			System.out.println("Select a row (1 - 9): ");
			int row = Integer.parseInt(sc.nextLine()) - 1;
			System.out.println("Select a column (1 - 9): ");
			int col = Integer.parseInt(sc.nextLine()) - 1;
			System.out.println("What number would you like? ");
			int val = Integer.parseInt(sc.nextLine());
			board[row][col] = val;
		}
		sc.close();

	}
	public static boolean hasDuplicates(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && arr[i] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean sudokuIsSolved(int[][] board) {
		for (int[] row : board) {
			if (hasDuplicates(row)) return false;
		}
		for (int c = 0; c < board[0].length; c++) {
			int[] col = new int[9];
			for (int r = 0; r < board.length; r++) col[r] = board[r][c];
			if (hasDuplicates(col)) return false;
		}
		for (int gr = 0; gr < 9; gr += 3) {
			for (int gc = 0; gc < 9; gc += 3) {
				int[] block = new int[9];
				int idx = 0;
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						block[idx++] = board[gr + r][gc + c];
					}
				}
				if (hasDuplicates(block)) return false;
			}
		}
		for (int[] row : board) {
			for (int v : row) {
				if (v == 0) return false;
			}
		}
		return true;
	}
	public static void printSudoku(int[][] puzzle) {
		for (int[] row : puzzle) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	//14
	public static boolean kenKenIsSolved(int[][] puzzle) {
		try {
			Scanner sc = new Scanner(new File("kenken1.puz"));
			int n = Integer.parseInt(sc.nextLine());
			int numGroups = Integer.parseInt(sc.nextLine());

			for (int r = 0; r < n; r++) {
				boolean[] seen = new boolean[n + 1];
				for (int c = 0; c < n; c++) {
					int v = puzzle[r][c];
					if (v < 1 || v > n || seen[v]) return false;
					seen[v] = true;
				}
			}
			for (int c = 0; c < n; c++) {
				boolean[] seen = new boolean[n + 1];
				for (int r = 0; r < n; r++) {
					int v = puzzle[r][c];
					if (v < 1 || v > n || seen[v]) return false;
					seen[v] = true;
				}
			}
			for (int i = 0; i < numGroups; i++) {
				String[] parts = sc.nextLine().split(" ");
				char op = parts[parts.length - 2].charAt(0);
				int target = Integer.parseInt(parts[parts.length - 1]);

				int cellCount = (parts.length - 2) / 2;

				int[] vals = new int[cellCount];
				int idx = 0;
				for (int p = 0; p < cellCount * 2; p += 2) {
					int r = Integer.parseInt(parts[p]);
					int c = Integer.parseInt(parts[p + 1]);
					vals[idx++] = puzzle[r][c];
				}

				if (op == '+') {
					int sum = 0;
					for (int v : vals) sum += v;
					if (sum != target) return false;
				}
				else if (op == '*') {
					int prod = 1;
					for (int v : vals) prod *= v;
					if (prod != target) return false;
				}
				else if (op == '/') {
					int a = vals[0], b = vals[1];
					if (!((a != 0 && b != 0 && (double)a / b == target) || (a != 0 && b != 0 && (double)b / a == target))) return false;
				}
				else return false;
			}
		sc.close();
		return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	public static void main(String[] args) {
		int[][] a = {{1, 2, 3}, {4, 5, 6}};
		int[][] b = {{1, 4}, {2, 5}, {3, 6}};
	}
}