package application;

/**
 * For GUI – check if Password and re-typed Password are identical
 * @author Auguste K.
 */
public class UnmatchedException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public UnmatchedException(String errorMessage) {
		super(errorMessage);
	}
}