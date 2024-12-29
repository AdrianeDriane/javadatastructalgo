public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public LinkedList() {
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length > 0) {
            tail.next = newNode;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }

        ++length;
        System.out.println("\nAppended new node of value " + value);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("\nHead: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("\nHead: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nLinkedList: ");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
}
