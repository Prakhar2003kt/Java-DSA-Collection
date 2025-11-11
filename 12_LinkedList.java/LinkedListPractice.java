public class LinkedListPractice {
    
    public static void main(String[] args) {
        LinkedListPractice practice = new LinkedListPractice();
        practice.runAllConcepts();
    }

    private void runAllConcepts() {
        demonstrateInsertions();
        demonstrateDeletions();
        demonstrateSearches();
        demonstrateReverseAndMid();
        demonstrateDeleteNthFromEnd();
        demonstratePalindromeCheck();
        demonstrateCycleUtilities();
        demonstrateMergeSort();
        demonstrateZigZagReorder();
    }

    private void demonstrateInsertions() {
        System.out.println("\n=== Insertions: addFirst | addLast | add(index, data) ===");
        LinkedList list = resetAndPopulate();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.print("Start after addFirst x3: ");
        list.print();

        list.addLast(4);
        list.addLast(5);
        System.out.print("After addLast x2: ");
        list.print();

        list.add(2, 99);
        System.out.print("After add(idx=2, 99): ");
        list.print();
        System.out.println("Current size: " + LinkedList.size);
    }

    private void demonstrateDeletions() {
        System.out.println("\n=== Deletions: removeFirst | removeLast ===");
        LinkedList list = resetAndPopulate(10, 20, 30, 40);
        System.out.print("Original list: ");
        list.print();

        int first = list.removeFirst();
        System.out.println("removeFirst -> " + first);
        System.out.print("Now: ");
        list.print();

        int last = list.removeLast();
        System.out.println("removeLast -> " + last);
        System.out.print("Now: ");
        list.print();
        System.out.println("Current size: " + LinkedList.size);
    }

    private void demonstrateSearches() {
        System.out.println("\n=== Search: iterative vs recursive ===");
        LinkedList list = resetAndPopulate(5, 10, 15, 20, 25);
        System.out.print("List: ");
        list.print();

        int targetPresent = 15;
        int targetAbsent = 90;
        System.out.println("itrSearch(" + targetPresent + ") -> " + list.itrSearch(targetPresent));
        System.out.println("itrSearch(" + targetAbsent + ") -> " + list.itrSearch(targetAbsent));

        System.out.println("recSearch(" + targetPresent + ") -> " + list.recSearch(targetPresent));
        System.out.println("recSearch(" + targetAbsent + ") -> " + list.recSearch(targetAbsent));
    }

    private void demonstrateReverseAndMid() {
        System.out.println("\n=== Reverse list + Find middle node ===");
        LinkedList list = resetAndPopulate(1, 2, 3, 4, 5);
        System.out.print("Original list: ");
        list.print();

        LinkedList.Node midBefore = list.findMid(LinkedList.head);
        System.out.println("Middle before reverse -> " + (midBefore != null ? midBefore.data : "null"));

        list.reverse();
        System.out.print("After reverse: ");
        list.print();

        LinkedList.Node midAfter = list.findMid(LinkedList.head);
        System.out.println("Middle after reverse -> " + (midAfter != null ? midAfter.data : "null"));
    }

    private void demonstrateDeleteNthFromEnd() {
        System.out.println("\n=== Delete Nth node from end ===");
        LinkedList list = resetAndPopulate(11, 22, 33, 44, 55);
        System.out.print("Original list: ");
        list.print();

        int n = 3;
        System.out.println("Deleting " + n + "rd node from end...");
        list.deleteNthfromEnd(n);
        System.out.print("After deletion: ");
        list.print();
    }

    private void demonstratePalindromeCheck() {
        System.out.println("\n=== Palindrome check ===");
        LinkedList list = resetAndPopulate(1, 2, 3, 2, 1);
        System.out.print("List: ");
        list.print();
        System.out.println("checkPalindrome() -> " + list.checkPalindrome());

        list = resetAndPopulate(1, 2, 3, 4);
        System.out.print("List: ");
        list.print();
        System.out.println("checkPalindrome() -> " + list.checkPalindrome());
    }

    private void demonstrateCycleUtilities() {
        System.out.println("\n=== Detect and remove cycle ===");
        LinkedList list = resetAndPopulate(7, 14, 21, 28, 35);
        createCycleAtIndex(1); // tail connects to node with data 14
        System.out.println("Cycle created by connecting tail to index 1");
        System.out.println("isCycle() -> " + LinkedList.isCycle());

        LinkedList.removeCycle();
        System.out.println("removeCycle() executed");
        System.out.println("isCycle() -> " + LinkedList.isCycle());
        refreshTailAndSize();
        System.out.print("Restored list: ");
        list.print();
    }

    private void demonstrateMergeSort() {
        System.out.println("\n=== Merge sort on linked list ===");
        LinkedList list = resetAndPopulate(4, 2, 8, 1, 5, 7, 3, 6);
        System.out.print("Unsorted list: ");
        list.print();

        LinkedList.head = list.mergeSort(LinkedList.head);
        refreshTailAndSize();
        System.out.print("Sorted list: ");
        list.print();
    }

    private void demonstrateZigZagReorder() {
        System.out.println("\n=== Zig-Zag reorder (reorder list into L0->Ln->L1->Ln-1...) ===");
        LinkedList list = resetAndPopulate(1, 2, 3, 4, 5, 6, 7);
        System.out.print("Original list: ");
        list.print();

        list.zigZag();
        refreshTailAndSize();
        System.out.print("After zigZag(): ");
        list.print();
    }

    private LinkedList resetAndPopulate(int... values) {
        LinkedList.head = null;
        LinkedList.tail = null;
        LinkedList.size = 0;
        LinkedList list = new LinkedList();
        for (int value : values) {
            list.addLast(value);
        }
        return list;
    }

    private void createCycleAtIndex(int index) {
        if (LinkedList.head == null) {
            return;
        }

        LinkedList.Node joinNode = LinkedList.head;
        for (int i = 0; i < index && joinNode != null; i++) {
            joinNode = joinNode.next;
        }
        if (LinkedList.tail != null) {
            LinkedList.tail.next = joinNode;
        }
    }

    private void refreshTailAndSize() {
        LinkedList.Node current = LinkedList.head;
        LinkedList.tail = current;
        LinkedList.size = 0;
        while (current != null) {
            LinkedList.tail = current;
            LinkedList.size++;
            current = current.next;
        }
    }
}
