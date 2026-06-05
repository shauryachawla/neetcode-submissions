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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(true) {
            int minNodeIndex = -1;
            for(int i=0;i<lists.length;i++) {
                if(lists[i] == null) continue;
                if(minNodeIndex == -1 || lists[i].val < lists[minNodeIndex].val)
                    minNodeIndex = i;
            }
            if(minNodeIndex == -1) break;
            cur.next = lists[minNodeIndex];
            lists[minNodeIndex] = lists[minNodeIndex].next;
            cur = cur.next;
        }
        return head.next;
    }
}
