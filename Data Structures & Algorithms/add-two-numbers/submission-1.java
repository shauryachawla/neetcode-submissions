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
        ListNode temp = l1;
        String s1 = "";
        String s2 = "";
        while(temp!=null) {
            s1 = s1+temp.val;
            temp = temp.next;
        }
        temp = l2;
        while(temp!=null) {
            s2 = s2+temp.val;
            temp = temp.next;
        }
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int n1 = Integer.valueOf(s1);
        int n2 = Integer.valueOf(s2);
        int sum = n1 + n2;
        return numberToNodes(sum);
    }

    private ListNode numberToNodes(int sum) {
        String s = "" + sum;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        char[] reverseSum = reverseArray(s.toCharArray());
        for(var c: reverseSum) {
            ListNode node = new ListNode(Integer.valueOf(c) - 48);
            curr.next = node;
            curr = node;
        }
        return head.next;
    }

    private char[] reverseArray(char[] arr ) {
        char[] reverse = new char[arr.length];
        for(int i=arr.length-1,j=0;i>=0;i--,j++) {
            reverse[j] = arr[i];
        }
        return reverse;
    }
}
