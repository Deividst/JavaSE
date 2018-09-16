
public class OverflowException extends RuntimeException {
	
	private String msg;

	public OverflowException() {
		this.msg = "Lista está cheia";
	}
	
	public String getMsg() {
		return msg;
	}	

}
