package com.micheald.dll;

public class Node {
	public Integer value;
	public Node previous;
	public Node next;
	
	public Node(Integer value) {
		this.value = value;
		this.previous = null;
		this.next = null;
	}
}
