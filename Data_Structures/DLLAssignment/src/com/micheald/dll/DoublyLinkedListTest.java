package com.micheald.dll;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
    	DoublyLinkedList dll = new DoublyLinkedList();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        System.out.println("Print Forward");
        dll.printValuesForward();
        System.out.println();
        
        System.out.println("Print Reverse");
        dll.printValuesReverse();
        System.out.println();
        
        System.out.println("Pop Last Node");
        Node lastNode = dll.pop();
        System.out.println("The last nodes value is : " + lastNode.value);
        System.out.println("The new list printed forward.");
        dll.printValuesForward();
        System.out.println();
        
        System.out.println("Contains");
        dll.printValuesForward();
        System.out.println("List contains the value 10 : " + dll.contains(10));
        System.out.println("List contains the value 100 : " + dll.contains(100));
        System.out.println();
        
        System.out.println("Size");
        dll.push(n6);
        dll.printValuesForward();
        System.out.println("This list contains " + dll.size() + " items.");
        System.out.println();
        
        System.out.println("Insert At");
        Node n7 = new Node(15);
        Node n8 = new Node(5);
        dll.printValuesForward();
        dll.insertAt(n7, 1);
        System.out.println();
        System.out.println("Insert 15 at index 1.");
        dll.printValuesForward();
        dll.insertAt(n8, 0);
        System.out.println();
        System.out.println("Insert 5 at index 0.");
        dll.printValuesForward();
        System.out.println();
        
        System.out.println("Remove At");
        dll.printValuesForward();
        dll.removeAt(0);
        System.out.println();
        System.out.println("Remove node at index 0.");
        dll.printValuesForward();
        dll.removeAt(1);
        System.out.println();
        System.out.println("Remove node at index 1.");
        dll.printValuesForward();
        System.out.println();
        dll.removeAt(5);
        System.out.println();
        System.out.println("Remove node at index 5.");
        dll.printValuesForward();
        System.out.println();
        
        System.out.println("Is Panindrome");
        dll.printValuesForward();
        System.out.println();
        System.out.println("This list " + (dll.isPalindrome() ? "is " : "is not ") + "a palindrome.");
        System.out.println();
        Node n9 = new Node(10);
        Node n10 = new Node(20);
        Node n11 = new Node(50);
        Node n12 = new Node(60);
        dll.push(n12);
        dll.push(n11);
        dll.push(n10);
        dll.push(n9);
        dll.printValuesForward();
        System.out.println();
        System.out.println("This list " + (dll.isPalindrome() ? "is " : "is not ") + "a palindrome.");
    }
}

