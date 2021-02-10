package application;

/**
 * Exception if password doesn’t contain a numeric character 
 * @author Auguste K.
 */
public class NoDigitException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public NoDigitException(String errorMessage) {
		super(errorMessage);
	}
}
