package workAtTech.practiceContest;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class AddTwoNumbersasLists {
    public static void main(String[] args) {
    
    }

    ListNode addTwoNumbers(ListNode firstList, ListNode secondList) {
        ListNode retValGlobal = null;
        ListNode retVal = null;
        int sum = 0;
        int carry = 0;

        while (firstList != null && secondList != null) {
            sum = firstList.data + secondList.data + carry;

            carry = sum / 10;
            int ans = sum % 10;

            if (retVal == null) {
                retVal = new ListNode(ans);
                retValGlobal = retVal;
            } else {
                retVal.next = new ListNode(ans);
                retVal = retVal.next;
            }

            firstList = firstList.next;
            secondList = secondList.next;
        }

        while (firstList != null) {
            sum = firstList.data + carry;

            carry = sum / 10;
            int ans = sum % 10;

            retVal.next = new ListNode(ans);
            retVal = retVal.next;

            firstList = firstList.next;
        }

        while (secondList != null) {
            sum = secondList.data + carry;

            carry = sum / 10;
            int ans = sum % 10;

            retVal.next = new ListNode(ans);
            retVal = retVal.next;

            secondList = secondList.next;
        }

        if (carry > 0) {
            retVal.next = new ListNode(carry);
        }

        return retValGlobal;
    }
}
