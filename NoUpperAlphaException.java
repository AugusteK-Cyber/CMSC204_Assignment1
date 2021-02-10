package application;

/**
 * Exception if password doesn’t contain an uppercase alpha character 
 * @author Auguste K.
 */
public class NoUpperAlphaException extends Exception {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public NoUpperAlphaException (String errorMessage) {
		super(errorMessage);
	}
}