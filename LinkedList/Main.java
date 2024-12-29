public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.append(10);
        linkedList.append(4);
        linkedList.append(6);

        linkedList.printAll();

        System.out.println(linkedList.insert(3, 69));
        linkedList.printAll();
    }
}