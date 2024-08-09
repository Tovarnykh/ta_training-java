package com.epam.rd.autocode.dllist;

import java.util.Optional;

public class DoublyLinkedListImpl implements DoublyLinkedList {

	private Node head;
	
	private Node tail;

	private static class Node {

		Object element;

		Node next;

		Node prev;

		Node(Object obj, Node prev, Node next) {
			this.element = obj;
			this.next = next;
			this.prev = prev;
		}

	}
	
	@Override
	public boolean addFirst(Object element) {
		Node newNode = new Node(element, null, null);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;

		}
		return true;
	}

	@Override
	public boolean addLast(Object element) {
		Node new_Node = new Node(element, null, null);
		if (element == null)
			return false;

		if (head == null) {
			head = new_Node;

			return true;
		}
		Node current = head;

		while (current.next != null)
			current = current.next;

		current.next = new_Node;

		new_Node.prev = current;

		return true;
	}

	@Override
	public void delete(int index) {
		Node node = getNodeByIndex(index);

		if (node == null) {
			throw new IndexOutOfBoundsException();
		}
		removeNode(node);
	}

	@Override
	public Optional<Object> remove(Object element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (head != null) {
			Node current = head;
			while (current != null) {
				if (current.element == element) {
					current.prev = current.next;

					return Optional.of(current.element);
				}
				current = current.next;
			}
		}
		return Optional.empty();
	}

	@Override
	public boolean set(int index, Object element) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		if (element == null)
			return false;

		Node newNode = new Node(element, null, null);

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node prevNode = getNodeByIndex(index - 1);
			newNode.next = prevNode.next.next;
			prevNode.next = newNode;

		}
		return true;
	}

	@Override
	public int size() {
		int size = 0;
		Node current = head;

		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size()];
		int i = 0;
		Node current = head;
		while (i < size()) {
			if (current != null) {
				result[i++] = current.element;
				current = current.next;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		Node current = head;

		while (current != null) {
			stringBuilder.append(current.element);
			current = current.next;
			if (current != null) {
				stringBuilder.append(" ");
			}
		}
		return stringBuilder.toString();
	}

	private Node getNodeByIndex(int index) {
		if (index < 0) {
			return null;
		}
		Node current = head;
		for (int i = 0; i < index; i++) {
			if (current == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	private void removeNode(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}
	
}
