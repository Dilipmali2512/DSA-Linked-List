public class Leetcode19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            tempHead = tempHead.next;
            len++;
        }

        int targetIndex = len - n;

        tempHead = head;

        if (targetIndex == 0) {
            return head.next;
        }

        int currIndex = 1;

        while (tempHead != null) {
            if (currIndex == targetIndex) {
                tempHead.next = tempHead.next.next;
                break;
            }

            currIndex++;
            tempHead = tempHead.next;
        }

        return head;

    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode tempHead = head;

        ListNode mainHead = new ListNode(0, head);
        head = mainHead;

        for (int i = 0; i < n; i++) {
            tempHead = tempHead.next;
        }

        while (tempHead != null) {
            tempHead = tempHead.next;
            head = head.next;
        }

        head.next = head.next.next;

        return mainHead.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(2, null);
        node1 = node1.next;
        node1.next = new ListNode(3, null);
        node1 = node1.next;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        node1.next = new ListNode(5, null);

        ListNode ans = removeNthFromEnd1(head1, 2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
