public class Leetcode8 {

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

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        boolean isDuplicate = false;

        while (currNode.next != null) {
            if (currNode.val == currNode.next.val) {
                isDuplicate = true;
            } else {
                if (prevNode == null) {
                    if (isDuplicate) {
                        head = currNode.next;
                        isDuplicate = false;
                    } else {
                        head = currNode;
                        prevNode = currNode;
                    }
                } else {
                    if (isDuplicate) {
                        prevNode.next = currNode.next;
                        isDuplicate = false;
                    } else {

                        prevNode.next = currNode;
                        prevNode = currNode;
                    }
                }

            }

            currNode = currNode.next;
        }

        if (isDuplicate) {
            if (prevNode == null) {
                return null;
            } else {
                prevNode.next = null;
            }
            return head;
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3, null);
        ListNode head1 = node1;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        // node1.next = new ListNode(2, null);
        // node1 = node1.next;
        node1.next = new ListNode(6, null);
        node1 = node1.next;
        node1.next = new ListNode(6, null);

        ListNode ans = deleteDuplicates(head1);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
