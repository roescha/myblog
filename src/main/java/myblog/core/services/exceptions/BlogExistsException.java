package myblog.core.services.exceptions;

public class BlogExistsException extends RuntimeException {
	public BlogExistsException(Throwable cause) {
		super(cause);
	}

	public BlogExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogExistsException(String message) {
		super(message);
	}

	public BlogExistsException() {

	}

}
