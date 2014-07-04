package myblog.core.services.exceptions;

public class BlogNotFoundException extends RuntimeException {
	public BlogNotFoundException(Throwable cause) {
		super(cause);
	}

	public BlogNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogNotFoundException(String message) {
		super(message);
	}

	public BlogNotFoundException() {

	}

}
