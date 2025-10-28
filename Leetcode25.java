public class Leetcode25 {

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

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode currNode = head;
        ListNode preHead = null;
        ListNode mainNode = null;
        while (currNode != null) {
            ListNode temp = reverseNode(currNode, k);
            if (mainNode == null) {
                mainNode = temp;
            }

            if (preHead != null) {
                preHead.next = temp;
            }
            preHead = currNode;
            currNode = currNode.next;
        }

        return mainNode;
    }

    public static ListNode reverseNode(ListNode head, int k) {
        ListNode prevNode = null;
        ListNode currNode = head;

        ListNode tempHead = head;
        int len = 0;

        while (tempHead != null) {
            tempHead = tempHead.next;
            len++;
        }

        if (len < k) {
            return head;
        }

        int count = 0;

        while (currNode != null && count < k) {
            ListNode tempNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = tempNode;
            count++;
        }
        head.next = currNode;
        return prevNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        node1.next = new ListNode(5, null);
        node1 = node1.next;
        node1.next = new ListNode(6, null);

        ListNode ans = reverseKGroup(head1, 3);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
