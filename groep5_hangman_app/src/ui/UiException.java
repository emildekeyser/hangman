package ui;

public class UiException extends RuntimeException {

	String msg;
	
	public UiException(String msg) {
		
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
	
		return super.getMessage() + this.msg;
	}

	private static final long serialVersionUID = 1L;

}
