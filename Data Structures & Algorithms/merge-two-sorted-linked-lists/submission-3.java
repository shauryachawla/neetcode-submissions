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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = null;
        ListNode prev = head;
        
        // both not null
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                curr = list1;
                list1 = list1.next;
            } else {
                curr = list2;
                list2 = list2.next;
            }
            prev.next = curr;
            prev = curr;
        }
        // either could be null
        if(list2 == null && list1 != null) {
            prev.next = list1;
        } 
        if(list1 == null && list2 != null) {
            prev.next = list2;
        }
        return head.next;
    }
}