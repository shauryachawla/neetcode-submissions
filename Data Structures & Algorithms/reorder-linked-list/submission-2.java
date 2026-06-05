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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        if(list.size() == 0) return ;
        if(list.size() == 1) return ;
        // [0,1,2,3,4,5,6]
        int i=0,j=list.size()-1;
        while(i<j) {
            if(i!=0) list.get(j+1).next = list.get(i);
            list.get(i).next = list.get(j);
            i++;j--;
        }
        if(i>j) { // even
            list.get(i).next = null;
        }
        else if (i==j) {
            list.get(j+1).next = list.get(i);
            list.get(i).next = null;
        }
        head = list.get(0);
        printList(head);

    }

    void printList(ListNode head) {
        ListNode temp = head;
        while(temp!=null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
