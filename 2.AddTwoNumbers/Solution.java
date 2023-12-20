/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(); // Dummy head node for the answer list

        ListNode temp1 = l1; // Pointer to traverse the first list
        ListNode temp2 = l2; // Pointer to traverse the second list
        ListNode tempAnswer = answer; // Pointer to build the answer list
        boolean over10 = false; // Flag to indicate carry over

        // Iterate as long as at least one list has nodes left, or there is a carry over
        while (temp1 != null || temp2 != null || over10) {
            if (over10) {
                tempAnswer.val++; // Add carry over if present
                over10 = false; // Reset carry over flag
            }
            if (temp1 != null) {
                tempAnswer.val += temp1.val; // Add value from the first list
                temp1 = temp1.next; // Move to next node in the first list
            }
            if (temp2 != null) {
                tempAnswer.val += temp2.val; // Add value from the second list
                temp2 = temp2.next; // Move to next node in the second list
            }
            if (tempAnswer.val >= 10) {
                tempAnswer.val -= 10; // Adjust value if it's 10 or more
                over10 = true; // Set carry over flag for next node
            }
            // Check if we need to create a new node for the next digit
            if (temp1 != null || temp2 != null || over10) {
                tempAnswer.next = new ListNode(); // Create new node
                tempAnswer = tempAnswer.next; // Move to newly created node
            }
        }
        return answer; // Return the head of the answer list
    }
}