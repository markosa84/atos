package hu.ak_akademia.atos;

public class NetbankRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NetbankRuntimeException() {
	}

	public NetbankRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NetbankRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NetbankRuntimeException(String message) {
		super(message);
	}

	public NetbankRuntimeException(Throwable cause) {
		super(cause);
	}

}