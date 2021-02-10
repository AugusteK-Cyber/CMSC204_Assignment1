package application;

/**
 * Exception if password doesn’t contain a special character
 * @author Auguste K.
 */
public class NoSpecialCharacterException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public NoSpecialCharacterException(String errorMessage) {
		super(errorMessage);
	}
}
