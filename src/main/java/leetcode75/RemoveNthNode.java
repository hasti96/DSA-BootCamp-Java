package leetcode75;

/**
 * @see -> https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val;}

    ListNode(int val, ListNode next) { this.val = val; this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [next=" + next + ", val=" + val + "]";
    }
}

public class RemoveNthNode {
    
    public static void main(String[] argv) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        System.out.println(head);

        ListNode retNode = removeNthFromEnd(head, 2);

        System.out.println(retNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = new ListNode(-1, head);

        ListNode p2 = head;
        ListNode p3 = head;
       
        while (n > 1) {
            p3 = p3.next;
            n--;
        }
        
        if(p3.next != null ) {
            while(p3.next != null) {
                p3 = p3.next;
                p2 = p2.next;
                p1 = p1.next;
            }
        } else if(p2 == p3) {
            return null;    
        }
        
        p1.next = p2.next;
        
        if(p1.val == -1) {
            return p1.next;
        }
        
        return head;
    }

    public static ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(n > 1) {
            p2 = p2.next;
            n--;
        }

        while(p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }
}
