class Solution {

    public int[] twoSum(int[] nums, int target) {

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // For each element, loop through the rest of the array to find a complementary number
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the current element and the selected element sum up to the target
                if (target - nums[i] == nums[j]) {
                    // If they do, return their indices
                    return new int[]{i, j};
                }
            }
        }
        // Return null if no pair is found that adds up to the target
        return null;
    }
}