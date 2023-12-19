class Solution {

    public boolean isPalindrome(int x) {
        // Convert the integer to a String for easier character comparison
        String input = "" + x;

        // Iterate over each character in the String
        for (int i = 0; i < input.length(); i++) {
            // Check if the character at the current index (i) is not equal to
            // the character at the mirrored index (length - 1 - i)
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                // If any character doesn't match, it's not a palindrome, return false
                return false;
        }

        // If all mirrored characters match, it's a palindrome, return true
        return true;
    }
}