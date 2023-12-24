class Solution {

    /**
     * Finds the longest palindromic substring in the given string.
     *
     * @param s The input string.
     * @return The longest palindromic substring.
     */
    public String longestPalindrome(String s) {
        int size = 0; // Current palindrome size
        int maxSize = 0; // Size of the largest palindrome found
        int location = 0; // Starting index of the largest palindrome

        // Check for odd-length palindromes
        for (int i = 1; i < s.length() - 1; i++) {
            size = 0;
            for (int j = 0; j <= i && j < s.length() - i; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    size++;
                } else {
                    j = s.length(); // Break the loop if characters don't match
                }
            }
            if (size > maxSize) {
                maxSize = size; // Update maxSize if a larger palindrome is found
                location = i; // Update the location of the palindrome's center
            }
        }

        // Build the longest odd-length palindrome
        String answer = "" + s.charAt(location);
        for (int z = 1; z < maxSize; z++) {
            answer = s.charAt(location - z) + answer + s.charAt(location + z);
        }

        int flag = 0; // Flag to check if an even-length palindrome is found
        // Check for even-length palindromes
        for (int i = 0; i < s.length() - 1; i++) {
            size = 0;
            for (int j = 0; j <= i && j < s.length() - i; j++) {
                if (i + j + 1 < s.length() && s.charAt(i - j) == s.charAt(i + j + 1)) {
                    size++;
                } else {
                    j = s.length(); // Break the loop if characters don't match
                }
            }
            if (size >= maxSize) {
                maxSize = size; // Update maxSize for even-length palindrome
                location = i; // Update location for even-length palindrome
                flag = 1; // Set flag indicating an even-length palindrome is found
            }
        }

        // Build the longest even-length palindrome
        if (flag == 1) {
            if (maxSize < 1) {
                return "" + s.charAt(location); // Return single character if no palindrome is found
            }
            answer = "" + s.charAt(location) + s.charAt(location + 1);
            for (int z = 1; z < maxSize; z++) {
                answer = s.charAt(location - z) + answer + s.charAt(location + z + 1);
            }
        }

        return answer; // Return the longest palindromic substring
    }
}