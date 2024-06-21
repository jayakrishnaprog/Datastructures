package com.prepare.datstructures;

//Node class representing a node in the linked list
class Node {
	int data;
	Node next;

	// Constructor to initialize a node with given data
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

//LinkedList class representing the singly linked list
class LinkedList {
	private Node head; // Head node of the linked list

	// Constructor to initialize an empty linked list
	public LinkedList() {
		this.head = null;
	}

	// Method to insert a node at the beginning of the linked list
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	// Method to insert a node at the end of the linked list
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	// Method to insert a node at a specific position in the linked list
	public void insertAtPosition(int data, int position) {
		Node newNode = new Node(data);
		if (position == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}
		Node current = head;
		int count = 0;
		while (current != null && count < position - 1) {
			current = current.next;
			count++;
		}
		if (current == null) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	// Method to delete a node from the beginning of the linked list
	public void deleteFromBeginning() {
		if (head == null) {
			throw new RuntimeException("Cannot delete from an empty list");
		}
		head = head.next;
	}

	// Method to delete a node from the end of the linked list
	public void deleteFromEnd() {
		if (head == null) {
			throw new RuntimeException("Cannot delete from an empty list");
		}
		if (head.next == null) {
			head = null;
			return;
		}
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}

	// Method to delete a node from a specific position in the linked list
	public void deleteAtPosition(int position) {
		if (head == null) {
			throw new RuntimeException("Cannot delete from an empty list");
		}
		if (position == 0) {
			head = head.next;
			return;
		}
		Node current = head;
		int count = 0;
		while (current != null && count < position - 1) {
			current = current.next;
			count++;
		}
		if (current == null || current.next == null) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		current.next = current.next.next;
	}

	// Method to traverse and print all elements in the linked list
	public void traverse() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Method to search for a node with given data in the linked list
	public boolean search(int data) {
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Method to update the value of a node at a specific position in the linked
	// list
	public void update(int newData, int position) {
		Node current = head;
		int count = 0;
		while (current != null && count < position) {
			current = current.next;
			count++;
		}
		if (current == null) {
			throw new IndexOutOfBoundsException("Invalid position");
		}
		current.data = newData;
	}

	// Method to calculate the length of the linked list
	public int length() {
		int length = 0;
		Node current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}
}

//Main class to test the LinkedList operations
public class LinkedlistAllOperation {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// Insert operations
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtBeginning(5);
		list.insertAtPosition(15, 2);

		// Print the linked list
		System.out.print("Linked List: ");
		list.traverse(); // Output: 5 10 15 20

		// Delete operations
		list.deleteFromBeginning();
		list.deleteAtPosition(2);

		// Print the linked list after deletion
		System.out.print("Linked List after deletion: ");
		list.traverse(); // Output: 10 20

		// Search operation
		int searchData = 10;
		boolean found = list.search(searchData);
		System.out.println(searchData + " found: " + found); // Output: 10 found: true

		// Update operation
		list.update(30, 1);

		// Print the linked list after update
		System.out.print("Linked List after update: ");
		list.traverse(); // Output: 10 30

		// Length operation
		int length = list.length();
		System.out.println("Length of linked list: " + length); // Output: Length of linked list: 2
	}
}
