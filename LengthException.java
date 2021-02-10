package application;

/**
 * Exception if length of password is less than 6 characters
 * @author Auguste K.
 */
public class LengthException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public LengthException(String errorMessage) {
		super(errorMessage);
	}
}
