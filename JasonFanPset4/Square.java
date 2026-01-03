public class Square {
	private boolean isBlack;
	private int num;

	public Square(boolean isBlack, int num) {
		this.isBlack = isBlack;
		this.num = num;
	}

	public String toString() {
		if (isBlack) return "#";
		else if (num > 0) return String.valueOf(num);
		else return " ";
	}
}