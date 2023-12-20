class Solution {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        String tempString = ""; // Temporary string to hold the current substring
        int temp = 0; // Length of the current substring
        int answer = 0; // Length of the longest substring found so far

        // Outer loop to start checking from each character in the string
        for (int i = 0; i < s.length(); i++) {
            temp = 0; // Reset the length for the new starting character
            tempString = ""; // Reset the temporary string

            // Inner loop to extend the substring starting from character at index i
            for (int j = i; j < s.length(); j++) {
                // Check if current character is already in the tempString
                if (!matchChar(s.charAt(j), tempString)) {
                    tempString += s.charAt(j); // Add new character to substring
                    temp++; // Increase length of the current substring
                } else {
                    // If character is repeated, break out of the inner loop
                    j = s.length();
                }
            }

            // Update answer if the current substring is longer than the previous longest
            if (temp >= answer) {
                answer = temp;
            }
        }
        return answer; // Return the length of the longest substring found
    }

    /**
     * Helper method to check if a character is present in a string.
     *
     * @param c The character to search for.
     * @param s The string to search in.
     * @return true if the character is found, false otherwise.
     */
    public boolean matchChar(char c, String s) {
        // Iterate over the string to find the character
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                return true; // Return true if character is found
            }
        }
        return false; // Return false if character is not found
    }
}
