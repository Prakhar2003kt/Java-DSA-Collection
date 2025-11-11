public class LinkedList2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // ------------------- INSERTION -------------------
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ------------------- DELETION -------------------
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // ------------------- SEARCH -------------------
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key)
                return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if (head == null)
            return -1;
        if (head.data == key)
            return 0;
        int idx = helper(head.next, key);
        if (idx == -1)
            return -1;
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    // ------------------- REVERSE -------------------
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // ------------------- DELETE Nth FROM END -------------------
    public void deleteNthfromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    // ------------------- PALINDROME -------------------
    public Node findMid(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null)
            return true;
        Node mid = findMid(head);
        Node prev = null, curr = mid, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head, right = prev;
        while (right != null) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // ------------------- CYCLE DETECTION -------------------
    public static boolean isCycle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void removeCycle() {
        Node slow = head, fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (!cycle)
            return;
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // ------------------- MERGE SORT -------------------
    private Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node h1, Node h2) {
        Node dummy = new Node(-1), temp = dummy;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        if (h1 != null)
            temp.next = h1;
        if (h2 != null)
            temp.next = h2;
        return dummy.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);
        return merge(left, right);
    }

    // ------------------- ZIG ZAG -------------------
    public void zigZag() {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node prev = null, curr = mid.next, next;
        mid.next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head, right = prev, nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }

    // ------------------- PRINT -------------------
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ------------------- MAIN DEMO -------------------
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();

        System.out.println("Add First & Last:");
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();

        System.out.println("\nAdd at Index:");
        ll.add(2, 9);
        ll.print();

        System.out.println("\nRemove First: " + ll.removeFirst());
        ll.print();

        System.out.println("\nRemove Last: " + ll.removeLast());
        ll.print();

        System.out.println("\nIterative Search(9): " + ll.itrSearch(9));
        System.out.println("Recursive Search(3): " + ll.recSearch(3));

        System.out.println("\nReverse LinkedList:");
        ll.reverse();
        ll.print();

        System.out.println("\nDelete 2nd from End:");
        ll.deleteNthfromEnd(2);
        ll.print();

        System.out.println("\nCheck Palindrome:");
        LinkedList ll2 = new LinkedList();
        ll2.addLast(1);
        ll2.addLast(2);
        ll2.addLast(2);
        ll2.addLast(1);
        ll2.print();
        System.out.println("Palindrome? " + ll2.checkPalindrome());

        System.out.println("\nMerge Sort:");
        LinkedList ll3 = new LinkedList();
        ll3.addLast(4);
        ll3.addLast(2);
        ll3.addLast(1);
        ll3.addLast(3);
        ll3.print();
        ll3.head = ll3.mergeSort(ll3.head);
        ll3.print();

        System.out.println("\nZigZag Reorder:");
        LinkedList ll4 = new LinkedList();
        for (int i = 1; i <= 6; i++)
            ll4.addLast(i);
        ll4.print();
        ll4.zigZag();
        ll4.print();

        System.out.println("\nCycle Detection Demo:");
        tail.next = head.next; // create cycle
        System.out.println("Is Cycle? " + isCycle());
        removeCycle();
        System.out.println("Is Cycle after removal? " + isCycle());
    }
}
