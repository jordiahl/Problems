/**
 * Created by jordi on 8/16/2017.
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 *
 *
 *
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode prev = result;

        while (l1 != null || l2 != null) {
            int l1Value = (l1 != null)?l1.val : 0;
            int l2Value = (l2 != null)?l2.val : 0;
            int value = l1Value + l2Value + carry;
            int digit = value % 10;
            carry = value/10;

            prev.next = new ListNode(digit);
            prev = prev.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry >0){
            prev.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers a2n = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(7);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(9);


        System.out.println("l1");
        l1.print();
        System.out.println("l2");
        l2.print();

        ListNode result = a2n.addTwoNumbers(l1, l2);
        System.out.println("ANSWER");
        result.print();
    }

}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int x) {
        val = x;
    }

    public void print() {
        System.out.println(val);
        if (next != null) {
            next.print();
        }
    }
}