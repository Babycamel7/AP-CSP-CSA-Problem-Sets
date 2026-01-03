import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("X val: ");
		int xVal = (int) s.nextInt();
		System.out.println("yVal: ");
		int yVal = (int) s.nextInt();

		Point p = new Point(xVal, yVal);
		Point p2 = new Point(2, 3);
		System.out.println(p.slopeTo(p2));

		Rectangle r = new Rectangle(new Point(0, 2), new Point(2, 2), new Point(0, 0), new Point(2, 0));
		Rectangle r2 = new Rectangle(new Point(1, 3), new Point(3, 3), new Point(1, 1), new Point(3, 1));
		Rectangle r3 = new Rectangle(new Point(0, 0), new Point(2, 2), new Point(2, 0), new Point(2, 6));
		Rectangle r4 = new Rectangle(new Point(8, 10), new Point(10, 10), new Point(8, 8), new Point(10, 8));

		System.out.println(r.isOverlapping(r2));
		System.out.println(r.isOverlapping(r4));

		System.out.println(r.isSquare());
		System.out.println(r3.isValid());

		MedicalRecord grant = new MedicalRecord("Grant Vance");
		MedicalRecord henry = new MedicalRecord("Henry Galla");

		System.out.println(MedicalRecord.getNumRecords());
	}
}