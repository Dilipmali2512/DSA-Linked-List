public class Leetcode61 {

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

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempHead = head;
        int listlength = 0;
        while (tempHead != null) {
            tempHead = tempHead.next;
            listlength++;
        }

        int index = (listlength - (k % listlength)) % listlength;

        if (index == 0) {
            return head;
        }

        tempHead = head;

        ListNode preHead = null;
        int cNum = 0;
        while (cNum != index) {
            preHead = tempHead;
            tempHead = tempHead.next;
            cNum++;
        }

        ListNode mainNode = tempHead;

        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        preHead.next = null;
        tempHead.next = head;

        return mainNode;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(2, null);
        // node1 = node1.next;
        // node1.next = new ListNode(2, null);
        // node1 = node1.next;
        // node1.next = new ListNode(6, null);

        ListNode ans = rotateRight(head1, 2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
