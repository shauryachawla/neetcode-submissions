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
        ListNode start = new ListNode();
        ListNode temp = start;
        while(list1 != null && list2 != null) {
            var val1 = list1.val;
            var val2 = list2.val;
            if(val1 < val2) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list2 == null) temp.next = list1;
        if(list1 == null) temp.next = list2;
        return start.next;
    }
}