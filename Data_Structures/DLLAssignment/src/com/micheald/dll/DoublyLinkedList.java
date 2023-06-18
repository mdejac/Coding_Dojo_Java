package com.micheald.dll;

public class DoublyLinkedList {
	public Node head;
	public Node tail;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void push(Node newNode) {
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}
	
	public void printValuesForward() {
		Node runner = this.head;
		while (runner != null) {
			System.out.println(runner.value);
			runner = runner.next; 
		}
	}
	
	public void printValuesReverse() {
		Node runner = this.tail;
		while (runner != null) {
			System.out.println(runner.value);
			runner = runner.previous; 
		}
	}
	
	public Node pop() {
		Node lastNode = this.tail;
		this.tail = lastNode.previous;
		if (this.tail == null) {
			this.head = null;			
		} else {
			this.tail.next = null;
		}
		return lastNode;
	}
	
	public boolean contains(Integer value) {
		if (this.head == null) {
			return false;
		}
		Node runner = this.head;
		while (runner != null) {
			if (runner.value == value) {
				return true;
			}
			runner = runner.next;
		}
		return false;
	}
	
	public int size() {
		int count = 0;
		if (this.head == null) {
			return count;
		}
		Node runner = this.head;
		while (runner != null) {
			count++;
			runner = runner.next;
		}
		return count;
	}
	
	public void insertAt(Node newNode, int index) {
		if (index < 0) {
			return;
		} else if ( this.head == null && index == 0) {
			push(newNode);
			return;
		} else if ( index == 0) {
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
			return;
		}
		
		int count = 0;
		Node runner = this.head;
		while (count < index - 1) {
			count++;
			runner = runner.next;
		}
		runner.next.previous = newNode;
		newNode.previous = runner;
		newNode.next = runner.next;
		runner.next = newNode;
	}
	
	public void removeAt(int index) {
		if (index <= 0 || index >= size()) {
			if (index == 0) {
				this.head = this.head.next;
				this.head.previous = null;
			}
			return;
		}
		
		if (index == size() - 1) {
			this.tail = this.tail.previous;
			this.tail.next = null;
			return;
		}
		
		int count = 0;
		Node runner = this.head;
		while (count < index) {
			count++;
			runner = runner.next;
		}
		runner.previous.next = runner.next;
		runner.next.previous = runner.previous;
	}
	
	public boolean isPalindrome() {
		if (this.head == null) {
			return false;
		}
		
		Node rightStart = this.head;
		Node leftStart = this.tail;
		
		while (leftStart != rightStart && leftStart.previous != rightStart) {
			if (leftStart.value != rightStart.value) {
				return false;
			}
			leftStart = leftStart.previous;
			rightStart = rightStart.next;
		}
		return true;
	}
}
