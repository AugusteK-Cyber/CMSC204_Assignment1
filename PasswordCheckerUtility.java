package application;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is meant to check the validity of passwords
 * @author Auguste K.
 *
 */
public final class PasswordCheckerUtility {

	/**
	 * Constructor
	 */
	public PasswordCheckerUtility() {
	}

	/**
	 * Private method that checks if the length of the password is 
	 * equal or greater than 6
	 * @param password: password String to be checked
	 * @return true if length of the password is valid, false otherwise
	 * @author Auguste K.
	 */
	private static boolean isValidLength(String password) {
		if (password.length() >= 6) {
			return true;
		}
		return false;
	}

	/**
	 * Private method that checks if the password contains at least 
	 * one uppercase alphabetic character
	 * @param password: password String to be checked
	 * @return true if the password contains at least one uppercase 
	 * alphabetic character, false otherwise
	 * @author Auguste K.
	 */
	private static boolean oneUppercaseCheck(String password) {

		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Private method that checks if the password contains at least 
	 * one lowercase alphabetic character
	 * @param password: password String to be checked
	 * @return true if the password contains at least one lowercase 
	 * alphabetic character, false otherwise
	 * @author Auguste K.
	 */
	private static boolean oneLowercaseCheck(String password) {

		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isLowerCase(ch)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Private method that checks if the password contains a numeric character 
	 * @param password: password String to be checked
	 * @return true if the password contains a numeric character, false otherwise
	 * @author Auguste K.
	 */
	private static boolean oneDigitCheck(String password) {
		// boolean digitFlag = false;
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Private method that checks if the password contains a special character 
	 * @param password: password String to be checked
	 * @return true if the password contains a special character, false otherwise
	 * @author Auguste K.
	 */
	private static boolean specialCharacterCheck(String password) {

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		return (!matcher.matches());
	}

	/**
	 * Private method that checks if the password contains more than 2 of the same 
	 * character in sequence 
	 * @param password: password String to be checked
	 * @return true if the password contains contains more than 2 of the same 
	 * character in sequence, false otherwise
	 * @author Auguste K.
	 */
	private static boolean validSequenceCheck(String password) {

		for (int i = 0; i < password.length()-2; i++) { 
			char ch = password.charAt(i);
			if (ch == password.charAt(i+1) && ch == password.charAt(i+2)) {
				return false; } 
		} 
		return true;
	}

	/**
	 * This method checks the validity of one password and return true if the 
	 * password is valid and throw one or more exceptions if invalid.  
	 * @param passwordString: password String to be checked
	 * @return return true if the password is valid
	 * @throws LengthException length of password not valid
	 * @throws NoDigitException not at least one digit in the password
	 * @throws NoUpperAlphaException not at least one uppercase letter in the password
	 * @throws NoLowerAlphaException not at least one lowercase letter in the password
	 * @throws InvalidSequenceException more than two characters in a sequence of the password
	 * @throws NoSpecialCharacterException no special character in the password
	 * @author Auguste K.
	 */
	public static boolean isValidPassword(String passwordString) 
			throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, 
			InvalidSequenceException, NoSpecialCharacterException {

		if (isValidLength(passwordString) == false) {
			throw new LengthException("The password must be at least 6 characters long");
		}

		if (oneUppercaseCheck(passwordString) == false) {
			throw new NoUpperAlphaException(
					"The password must contain at least one uppercase alphabetic character");
		}

		if (oneLowercaseCheck(passwordString) == false) {
			throw new NoLowerAlphaException(
					"The password must contain at least one lowercase alphabetic character");
		}

		if (oneDigitCheck(passwordString) == false) {
			throw new NoDigitException(
					"The password must contain at least one digit");
		}

		if (specialCharacterCheck(passwordString) == false) {
			throw new NoSpecialCharacterException(
					"The password must contain at least one special character");
		}

		if (validSequenceCheck(passwordString) == false) {
			throw new InvalidSequenceException(
					"The password cannot contain more than two of the same character in sequence");
		}

		return true;
	}

	/**
	 * Method that checks if password contains 6 to 9 characters which are otherwise valid
	 * @param passwordString: password String to be checked
	 * @return true if length of the password is within that range, false otherwise
	 * @author Auguste K.
	 */
	public static boolean isWeakPassword(String passwordString) {

		if ((passwordString.length() >= 6 && passwordString.length() < 10))
			return true;
		else
			return false;
	}

	/**
	 * This method will check an ArrayList of passwords and return an ArrayList with 
	 * the status of any invalid passwords (weak passwords are not considered invalid).  
	 * @param passwords: password String to be checked
	 * @return ArrayList of invalid passwords
	 * @author Auguste K.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<String>();
		passwords.forEach((password) -> {
			try {
				PasswordCheckerUtility.isValidPassword(password);
			} catch (LengthException | NoDigitException | NoUpperAlphaException | NoLowerAlphaException
					| InvalidSequenceException | NoSpecialCharacterException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			}
		});
		return invalidPasswords;

	}
}
