public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(11);
        linkedList.append(3);
        linkedList.append(23);
        linkedList.append(7);
        linkedList.append(11);

        System.out.println(linkedList.hasLoop());
    }
}