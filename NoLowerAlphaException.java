package application;

/**
 * Exception if password does not contain a lowercase alpha character
 * @author Auguste K.
 */
public class NoLowerAlphaException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public NoLowerAlphaException(String errorMessage) {
		super(errorMessage);
	}
}
