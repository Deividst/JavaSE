
public class UnderflowException extends RuntimeException {

	private String msg;

	public UnderflowException() {
		this.msg = "Lista est� cheia";
	}
	
	public String getMsg() {
		return msg;
	}	

}
