public class Point {
	private double x;
	private double y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public boolean equals(Point other) {
		return (this.x == other.x) && (this.y == other.y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double slopeTo(Point other) {
		if (other.x - this.x == 0) {
			return Double.POSITIVE_INFINITY;
		}

		return (other.y - this.y) / (other.x - this.x);
	}
}