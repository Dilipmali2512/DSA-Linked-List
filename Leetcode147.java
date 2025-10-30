public class Leetcode147 {
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

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode ans = head;
        ListNode prevNode = head;
        int currIndex = 1;

        while (curr != null) {
            ListNode tNode = ans;
            ListNode prNode = null;
            int currCount = 0;
            boolean isPositionChange = false;
            while (tNode != null && currIndex != currCount) {
                currCount++;
                if (tNode.val > curr.val) {
                    // add curr node after prNode and before tNode
                    if (prNode == null) {
                        ans = curr;
                    } else {
                        prNode.next = curr;
                    }
                    prevNode.next = curr.next;
                    ListNode temp = curr.next;
                    curr.next = tNode;
                    curr = temp;
                    isPositionChange = true;
                    break;
                }
                prNode = tNode;
                tNode = tNode.next;
            }

            if (!isPositionChange) {
                prevNode = curr;
                curr = curr.next;
            }
            currIndex++;
        }

        return ans;
    }

    public static void main(String[] args) {
        // -1,5,3,4,0
        ListNode node1 = new ListNode(-1, null);
        ListNode head1 = node1;
        node1.next = new ListNode(5, null);
        node1 = node1.next;
        node1.next = new ListNode(3, null);
        node1 = node1.next;
        node1.next = new ListNode(4, null);
        node1 = node1.next;
        node1.next = new ListNode(0, null);
        // node1 = node1.next;
        // node1.next = new ListNode(4, null);
        // node1 = node1.next;
        // node1.next = new ListNode(-1, null);

        ListNode ans = insertionSortList(head1);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}