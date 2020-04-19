package LeetCode.MonthChallenge;



class Day8 {
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        ListNode fastCurrent = head;
        while(fastCurrent!=null && fastCurrent.next!=null){
            current = current.next;
            fastCurrent = fastCurrent.next.next;
        }
        return current;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}