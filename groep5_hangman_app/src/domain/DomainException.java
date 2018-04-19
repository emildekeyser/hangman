package domain;

public class DomainException extends RuntimeException {

	private String msg;
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "\n" + this.msg;
	}

}
