package application;

/**
 * Exception if password contains 6 to 9 characters which are otherwise valid 
 * @author Auguste K.
 */
public class WeakPasswordException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public WeakPasswordException(String errorMessage) {
		super(errorMessage);
	}
}
