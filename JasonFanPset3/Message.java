public class Message {
	private int lineNum;
	private int messageNum;
	private String message;

	public Message(int lineNum, int messageNum, String message) {
		this.lineNum = lineNum;
		this.messageNum = messageNum;
		this.message = message;
	}

	public int lineNum() {
		return lineNum;
	}
	public int messageNum() {
		return messageNum;
	}
	public String getMessage() {
		return message;
	}
}