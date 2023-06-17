public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            return;
        }

        Node runner = head;
        while (runner.next.next != null) {
            runner = runner.next;
        }
        runner.next = null;
    }

    public void printValues() {
        Node runner = this.head;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }

    public Node find(int value) {
        Node runner = this.head;
        while (runner != null) {
            if (runner.value == value) {
                return runner;
            }
            runner = runner.next;
        }
        return null;
    }

    public void removeAt(int index) {
        if (head == null || index < 0) {
            return;
        } else if (index == 0) {
            head = head.next;
            return;
        }
        int counter = 0;
        Node runner = this.head;
        while (runner != null && counter < index - 1) {
            runner = runner.next;
            counter++;
        }

        if (runner != null && runner.next != null) {
            runner.next = runner.next.next;
        }
    }
}
