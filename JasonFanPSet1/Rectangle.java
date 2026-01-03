public class Rectangle {
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;

	public Rectangle(Point tL, Point tR, Point bL, Point bR) {
		topLeft = tL;
		topRight = tR;
		bottomLeft = bL;
		bottomRight = bR;
	}

	public String toString() {
		return "(" + topLeft + ", " + topRight + ", " + bottomLeft + ", " + bottomRight + ")";
	}

	public boolean equals(Rectangle other) {
		return (this.topLeft.equals(other.topLeft)) && (this.topRight.equals(other.topRight)) && (this.bottomLeft.equals(other.bottomLeft)) && (this.bottomRight.equals(other.bottomRight));
	}

	public boolean isOverlapping(Rectangle other) {
		if (!this.isValid() || !other.isValid()) {
			return false;
		}

		if (this.topLeft.getX() >= other.bottomRight.getX() || other.topLeft.getX() >= this.bottomRight.getX()) {
			return false;
		}

		if (this.bottomLeft.getY() >= other.topLeft.getY() || other.bottomLeft.getY() >= this.topLeft.getY()) {
			return false;
		}

		return true;
	}

	public boolean isValid() {
		return (this.topLeft.getX() == this.bottomLeft.getX()) && (this.topRight.getX() == this.bottomRight.getX()) && (this.topLeft.getY() == this.topRight.getY()) && (this.bottomLeft.getY() == this.bottomRight.getY());
	}

	public double getArea() {
		return (topLeft.getY() - bottomLeft.getY()) * (topRight.getX() - topLeft.getX()); 
	}

	public boolean isSquare() {
		return bottomLeft.slopeTo(topRight) == 1;
	}
}