public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.printAll();

        linkedList.append(10);
        linkedList.printAll();

        linkedList.append(4);
        linkedList.printAll();

        linkedList.append(6);
        linkedList.printAll();

        linkedList.removeFirst();
        linkedList.printAll();

        linkedList.removeFirst();
        linkedList.printAll();

        linkedList.removeFirst();
        linkedList.printAll();

        linkedList.removeFirst();
        linkedList.printAll();
    }
}