public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.remove();
        sll.remove();
        sll.printValues();
        System.out.println();
        sll.removeAt(1);
        sll.printValues();

        Node foundNode = sll.find(10);
        if (foundNode != null) {
            System.out.println("Node found : " + foundNode.value);
        } else {
            System.out.println("Node not found.");
        }

        foundNode = sll.find(7);
        if (foundNode != null) {
            System.out.println("Node found : " + foundNode.value);
        } else {
            System.out.println("Node not found.");
        }
    }
}
