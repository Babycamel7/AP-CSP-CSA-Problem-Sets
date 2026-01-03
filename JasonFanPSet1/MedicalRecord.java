public class MedicalRecord {
	private String name;
	private String patientID;
	private boolean needsTranslator;
	private static int numRecords;

	public MedicalRecord(String name) {
		this.name = name;
		int d1 = (int) (Math.random() * 10);
		int d2 = (int) (Math.random() * 10);
		int d3 = (int) (Math.random() * 10);
		int d4 = (int) (Math.random() * 10);
		int d5 = (int) (Math.random() * 10);

		patientID = String.valueOf(d1) + String.valueOf(d2) + String.valueOf(d3) + String.valueOf(d4) + String.valueOf(d5);

		this.needsTranslator = false;
		numRecords++;
	}

	public MedicalRecord(String name, boolean needsTranslator) {
		this.name = name;
		int d1 = (int) (Math.random() * 10);
		int d2 = (int) (Math.random() * 10);
		int d3 = (int) (Math.random() * 10);
		int d4 = (int) (Math.random() * 10);
		int d5 = (int) (Math.random() * 10);

		patientID = String.valueOf(d1) + String.valueOf(d2) + String.valueOf(d3) + String.valueOf(d4) + String.valueOf(d5);

		this.needsTranslator = needsTranslator;
		numRecords++;
	}

	public String toString() {
		return "(" + patientID + ", " + name + ", " + needsTranslator + ")";
	}

	public boolean equals(MedicalRecord other) {
		return (this.name == other.name) && (this.patientID == other.patientID) && (this.needsTranslator == other.needsTranslator);
	}

	public String getName() {
		return name;
	}

	public String getPatientID() {
		return patientID;
	}

	public static int getNumRecords() {
		return numRecords;
	}

	public void clearRecord() {
		this.name = null;
		this.patientID = null;
		this.needsTranslator = false;
	}
}