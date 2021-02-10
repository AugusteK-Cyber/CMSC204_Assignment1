package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Auguste K.
 *
 */
public class PasswordCheckerSTUDENT_Test {

	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		
		String[] d = {"772244MM", "Oz6#jeel0C", "johnny9DDD", "4now#", "coyote33#", "1hellFebru#", 
				"gigiou96", "stuvwx", "Pommesyy#", "ss00b", "gettoKnowyou", "itIsmytime", 
				"itIsmytime2"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(d)); // puts strings into the ArrayList
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("hijHIJ45#"));
			PasswordCheckerUtility.isValidPassword("op89#");
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("8765432nN#"));
			PasswordCheckerUtility.isValidPassword("8765432n#");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		//fail("Not implemented by student yet");
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("3456789Kk#"));
			PasswordCheckerUtility.isValidPassword("3456789K#");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		//fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("6789wwWW#"));
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("6789wwW#");
			assertTrue(weakPwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		//fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("3456ggGG#"));
			PasswordCheckerUtility.isValidPassword("3456gGGG#");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		//fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("hsk9ggGG#"));
			PasswordCheckerUtility.isValidPassword("hskoggGG#");
			assertTrue("Did not throw an NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides a NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		//fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("L3Ader5HiP#"));
			PasswordCheckerUtility.isValidPassword("SUCC355ful!");
			assertTrue("Did not throw any Exception",true);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		//fail("Not implemented by student yet");
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); //
		assertEquals(scan.next(), "772244MM");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one lowercase alphabetic character.");
		scan = new Scanner(results.get(1)); //
		assertEquals(scan.next(), "johnny9DDD");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));
		//assertEquals(scan.nextLine(), " The password cannot contain more than two of the same character in sequence.");
		scan = new Scanner(results.get(3)); //
		assertEquals(scan.next(), "coyote33#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		//assertEquals(scan.nextLine(), " The password must contain at least one uppercase alphabetic character.");
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "stuvwx");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") || nextResults.contains("digit"));
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
		scan = new Scanner(results.get(6)); //a
		assertEquals(scan.next(), "Pommesyy#");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
	}
	
}
