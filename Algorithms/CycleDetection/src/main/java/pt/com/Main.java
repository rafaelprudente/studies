package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println("Has Cycle Test: " + hasCycleTest());
        System.out.println("Has Not Cycle Test: " + hasNotCycleTest());
    }

    private static boolean hasCycleTest() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head; // Creating a cycle

        return hasCycle(head);
    }

    private static boolean hasNotCycleTest() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        return hasCycle(head);
    }

    private static boolean hasCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) return true;
        }
        return false;
    }
}