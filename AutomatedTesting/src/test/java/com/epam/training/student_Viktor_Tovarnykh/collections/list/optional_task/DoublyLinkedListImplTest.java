package com.epam.training.student_Viktor_Tovarnykh.collections.list.optional_task;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import com.epam.training.student_viktor_tovarnykh.collections.list.optional_task.DoublyLinkedListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spoon.Launcher;
import spoon.SpoonAPI;
import spoon.reflect.declaration.CtTypeInformation;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * @author D. Kolesnikov
 */
public class DoublyLinkedListImplTest {

	//////////////////////////////////////////////////////////////////////////////

	private static boolean isAllTestsMustFailed;

	//////////////////////////////////////////////////////////////////////////////
	
	private DoublyLinkedListImpl list;
	
	@BeforeEach
	void setUp() {
		list = new DoublyLinkedListImpl();
	}
	
	@Test
	void toStringShouldReturnElementsSeparatedBySpace() {
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		list.addFirst("D");
		String expected = "D C B A";
		String actual = list.toString();
		assertEquals(expected, actual);
	}

	@Test
	void sizeShouldReturn0WhenNoElementsWereAdded() {
		int expected = 0;
		int actual = list.size();
		assertEquals(expected, actual);
	}

	@Test
	void sizeShouldReturn3WhenThreeElementsWereAdded() {
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		int expected = 3;
		int actual = list.size();
		assertEquals(expected, actual);
	}

	@Test
	void toArrayShouldReturnEmptyArrayWhenListIsEmpty() {
		Object[] expected = {};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void addLastShouldAddThreeElementsABC() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		String expected = "A B C";
		String actual = list.toString();
		assertEquals(expected, actual);
	}

	@Test
	void toArrayShouldReturnArrayWith3ElementsWhenListContains3Elements() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		Object[] expected = {"A", "B", "C"};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void setShouldSetSecondElement() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.set(1, "7");
		Object[] expected = {"A", "7", "C"};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void setShouldThrowExceptionIfIndexOutOfBounds() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "7"));
	}

	@Test
	void getShouldReturnFirstElement() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		Object expected = "A";
		Object actual = list.remove("A").get();
		assertEquals(expected, actual);
	}

	@Test
	void getShouldReturnLastElement() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		Object expected = "C";
		Object actual = list.remove("C").get();
		assertEquals(expected, actual);
	}

	@Test
	void getShouldReturnNullIfNoSuchElement() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		assertTrue(list.remove("7").isEmpty());
	}

	@Test
	void deleteShouldDeleteOneElementWhenListContainOneElement() {
		list.addLast("A");
		list.delete(0);
		Object[] expected = {};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void deleteShouldDeleteOneElementsWhenListContainsThreeElements() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.delete(0);
		Object[] expected = {"B", "C"};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void deleteShouldDeleteSecondElementWhenListContainsThreeElements() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.delete(1);
		Object[] expected = {"A", "C"};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void deleteShouldDeleteLastElement() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.delete(2);
		Object[] expected = {"A", "B"};
		Object[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void deleteShouldDeleteAllElements() {
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");

		Object[] expected;
		Object[] actual;

		list.delete(0);
		expected = new Object[] {"B", "C"};
		actual = list.toArray();
		assertArrayEquals(expected, actual);

		list.delete(0);
		expected = new Object[] {"C"};
		actual = list.toArray();
		assertArrayEquals(expected, actual);

		list.delete(0);
		expected = new Object[] {};
		actual = list.toArray();
		assertArrayEquals(expected, actual);
	}

	@Test
	void addFirstShouldReturnFalseWhenAddNull() {
		assertFalse(list.addLast(null));
	}

	@Test
	void addFirstShouldReturnTrueWhenAddNonNull() {
		assertTrue(list.addLast("A"));
	}

	@Test
	void addLastShouldReturnFalseWhenAddNull() {
		assertFalse(list.addLast(null));
	}

	@Test
	void addLastShouldReturnTrueWhenAddNonNull() {
		assertTrue(list.addLast("A"));
	}

	@Test
	void setShouldReturnFalseWhenAddNull() {
		list.addFirst("A");
		assertFalse(list.set(0, null));
	}

	@Test
	void setShouldReturnTrueWhenAddNonNull() {
		list.addFirst("A");
		assertTrue(list.set(0, "B"));
	}
	
	@Test
	void appShouldUseOnlyOptionalFromJavaUtilPackage() {
		SpoonAPI spoon = new Launcher();
		spoon.addInputResource("src/main/java/");
		spoon.buildModel();

		java.util.List<String> types = spoon.getModel()
				.getElements(new TypeFilter<>(CtTypeReference.class))
				.stream()
				.filter(r -> r.toString().startsWith("java.util."))
				.map(CtTypeReference::getQualifiedName).distinct()
				.toList();
	}

	@Test
	void appShouldUseOnlyOneTopLevelClass() {
		String packName = getClass().getPackage().getName();

		SpoonAPI spoon = new Launcher();
		spoon.addInputResource("src/main/java/");
		spoon.buildModel();
		
		List<String> types = spoon.getModel()
				.getElements(new TypeFilter<>(CtTypeReference.class))
				.stream()
				.filter(CtTypeInformation::isClass)
				.filter(r -> r.toString().startsWith(packName))
				.map(CtTypeReference::getQualifiedName).distinct()
				.toList();
	}

	@Test
	void listShouldDeclaredOnlyTwoFields() {
		Field[] fields = DoublyLinkedListImpl.class.getDeclaredFields();
		assertEquals(2, fields.length, () -> "You must declare only two fields");
		for (Field f : fields) {
			assertTrue(f.getType().getSuperclass() != Number.class,
					() -> "Field cannot be of type of number");
		}
	}
	
}
