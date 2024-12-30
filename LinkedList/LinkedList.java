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

    public Node removeLast() {
        if (length == 0) {
            System.out.println("\nTried to remove last Node but LinkedList is empty");
            return null;
        }

        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        --length;
        if (length == 0) {
            head = null;
            tail = null;
        }

        System.out.println("\nRemoved last Node with value " + temp.value);
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        ++length;
        System.out.println("\nPrepending Node with value " + value);
    }

    public Node removeFirst() {
        if (length == 0) {
            System.out.println("\nTried to remove first Node but LinkedList is empty");
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        --length;

        if (length == 0) {
            tail = null;
        }

        System.out.println("\nRemoved first Node with value " + temp.value);
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Tried to get Node of index " + index + " but is out of bounds");
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; ++i) {
            temp = temp.next;
        }

        System.out.println("Getting Node of index " + index + " with value " + temp.value);
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            System.out.println("Setting Node of index " + index + " with value " + temp.value);
            return true;
        }

        System.out.println("Tried to set value of Node with index " + index + " but is out of bounds");
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            System.out.println("Tried to insert at index " + index + " but is out of bounds");
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);

        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        ++length;

        System.out.println("Inserting Node of index " + index + " with value " + newNode.value);
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Tried to remove at index " + index + " but is out of bounds");
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        --length;

        System.out.println("removing Node of index " + index);
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;
        for (int i = 0; i < length; ++i) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        System.out.println("Successfully reversed LinkedList");
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

    public Node findMiddleNode() {
        if (head == null)
            return null;

        Node tortoise = head;
        Node hare = head;

        while (hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == null)
                break;
        }

        return tortoise;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
