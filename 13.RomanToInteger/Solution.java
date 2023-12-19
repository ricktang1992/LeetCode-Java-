class Solution {

    /**
     * Converts a Roman numeral to an integer.
     * 
     * @param s The Roman numeral string.
     * @return The integer value of the Roman numeral.
     */
    public int romanToInt(String s) {
        int tag = 1; // Variable to track the highest value symbol seen so far
        int answer = 0; // Variable to accumulate the result

        // Iterate over the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            // Use a switch statement to handle each Roman numeral character
            switch (s.charAt(i)) {
                case 'I':
                    // 'I' can either add or subtract 1 depending on its position
                    if (tag > 1) {
                        answer--;
                    } else {
                        tag = 1;
                        answer++;
                    }
                    break;
                case 'V':
                    // 'V' can either add or subtract 5
                    if (tag > 5) {
                        answer -= 5;
                    } else {
                        tag = 5;
                        answer += 5;
                    }
                    break;
                case 'X':
                    // 'X' can either add or subtract 10
                    if (tag > 10) {
                        answer -= 10;
                    } else {
                        tag = 10;
                        answer += 10;
                    }
                    break;
                case 'L':
                    // 'L' can either add or subtract 50
                    if (tag > 50) {
                        answer -= 50;
                    } else {
                        tag = 50;
                        answer += 50;
                    }
                    break;
                case 'C':
                    // 'C' can either add or subtract 100
                    if (tag > 100) {
                        answer -= 100;
                    } else {
                        tag = 100;
                        answer += 100;
                    }
                    break;
                case 'D':
                    // 'D' can either add or subtract 500
                    if (tag > 500) {
                        answer -= 500;
                    } else {
                        tag = 500;
                        answer += 500;
                    }
                    break;
                case 'M':
                    // 'M' adds 1000, or subtracts if placed before a higher value symbol
                    if (tag > 1000) {
                        answer -= 1000;
                    } else {
                        tag = 1000;
                        answer += 1000;
                    }
                    break;
                default:
                    // In case of an invalid character (should not happen in valid input)
            }
        }
        return answer; // Return the computed integer value
    }
}