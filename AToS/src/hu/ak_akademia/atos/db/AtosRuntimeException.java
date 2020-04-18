package hu.ak_akademia.atos.db;

public class AtosRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AtosRuntimeException() {
	}

	public AtosRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AtosRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public AtosRuntimeException(String message) {
		super(message);
	}

	public AtosRuntimeException(Throwable cause) {
		super(cause);
	}

}