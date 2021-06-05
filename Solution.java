/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        
        ListNode curr = headA;
        while (curr != null) {
            map.put(curr, 1);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (map.containsKey(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;

    }
}