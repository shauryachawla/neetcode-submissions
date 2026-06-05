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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        // [a,b,c,d,e]
        if(list.size() == 1) return null;
        int removeIndex = list.size()-n;
        if(removeIndex == 0) {
            head = list.get(1);
        }
        else {
            list.get(removeIndex-1).next = list.get(removeIndex).next;
            head = list.get(0);
        }
        return head;

    }
}
