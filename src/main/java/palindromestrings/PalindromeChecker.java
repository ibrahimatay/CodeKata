package palindromestrings;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        if(s == null) return true;
        if (s.isEmpty()) return true;

        int index = s.length();

        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(index - i - 1)) return false;
        }

        return true;
    }
}
