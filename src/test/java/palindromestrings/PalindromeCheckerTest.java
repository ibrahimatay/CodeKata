package palindromestrings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeCheckerTest {

    @Test
    public void palindromeChecker_returns_true_for_empty_string() {
        assertEquals(true, PalindromeChecker.isPalindrome(""));
    }

    @Test
    public void palindromeChecker_returns_true_for_null() {
        assertEquals(true, PalindromeChecker.isPalindrome(null));
    }

    @Test
    public void palindromeChecker_returns_true_for_input_ABBA() {
        assertEquals(true, PalindromeChecker.isPalindrome("ABBA"));
    }

    @Test
    public void palindromeChecker_returns_true_for_input_tattarrattat() {
        assertEquals(true, PalindromeChecker.isPalindrome("tattarrattat"));
    }

    @Test
    public void palindromeChecker_returns_false_for_input_ABCD() {
        assertEquals(false, PalindromeChecker.isPalindrome("ABCD"));
    }

    @Test
    public void palindromeChecker_returns_false_for_input_palindrome() {
        assertEquals(false, PalindromeChecker.isPalindrome("palindrome"));
    }
}
