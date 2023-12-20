class Solution {

    /**
     * Finds the median of two sorted arrays.
     *
     * @param nums1 The first sorted array.
     * @param nums2 The second sorted array.
     * @return The median of the two sorted arrays.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int[] newnums = new int[nums1.length + nums2.length]; // Array to hold the merged array

        // Merge the two sorted arrays into newnums
        for (int z = 0; z < newnums.length; z++) {
            if (i >= nums1.length) {
                // If all elements in nums1 are added, add remaining elements from nums2
                newnums[z] = nums2[j++];
            } else if (j >= nums2.length) {
                // If all elements in nums2 are added, add remaining elements from nums1
                newnums[z] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                // If current element in nums2 is smaller, add it to newnums
                newnums[z] = nums2[j++];
            } else {
                // If current element in nums1 is smaller or equal, add it to newnums
                newnums[z] = nums1[i++];
            }
        }

        // Find the median of the merged array
        if (newnums.length % 2 == 1) {
            // If the merged array has odd number of elements, return the middle element
            return newnums[newnums.length / 2];
        } else {
            // If the merged array has even number of elements, return the average of the two middle elements
            return (newnums[newnums.length / 2] + newnums[newnums.length / 2 - 1]) / 2.0;
        }
    }
}
