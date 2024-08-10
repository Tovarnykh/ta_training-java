package com.epam.training.student_viktor_tovarnykh.collections.list.optional_task;

import java.util.Optional;

public interface DoublyLinkedList {
	
	boolean addFirst(Object element);

	boolean addLast(Object element);

	void delete(int index);

	Optional<Object> remove(Object element);

	boolean set(int index, Object element);

	int size();

	Object[] toArray();

	String toString();

}
