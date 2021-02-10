package application;

/**
 * Exception if password contains more than 2 of the same character in sequence
 * @author Auguste K.
 */
public class InvalidSequenceException extends Exception {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSequenceException(String errorMessage) {
		super(errorMessage);
	}
}