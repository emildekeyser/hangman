package db;

public class DbException extends RuntimeException {

	String msg;
	
	public DbException(String msg) {
		
		this.msg = msg;
	}
	
	@Override
	public String getMessage() {
	
		return super.getMessage() + this.msg;
	}

	private static final long serialVersionUID = 1L;

}
