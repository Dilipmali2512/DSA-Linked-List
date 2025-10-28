public class Leetcode24 {
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

    public static ListNode swapPairs(ListNode head) {
        if (head==null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode preNode = null;
        ListNode mainNode = null;
        while (temp != null && temp.next != null) {
            ListNode selfNode = temp;
            ListNode nextNode = temp.next;

            selfNode.next = nextNode.next;
            nextNode.next = selfNode;
            if (preNode != null) {
                preNode.next = nextNode;
            } else {
                mainNode = nextNode;
            }
            preNode = temp;

            temp = selfNode.next;

        }
        return mainNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        node1.next = new ListNode(5, null);
        node1 = node1.next;
        node1.next = new ListNode(6, null);

        // ListNode node2 = new ListNode(1, null);
        // ListNode head2 = node2;
        // node2.next = new ListNode(3, null);
        // node2 = node2.next;
        // node2.next = new ListNode(4, null);

        // ListNode node3 = new ListNode(2, null);
        // ListNode head3 = node3;
        // node3.next = new ListNode(6, null);
        // node3 = node3.next;
        // node3.next = new ListNode(, null);

        ListNode ans = swapPairs(head1);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
