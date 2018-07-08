package com.test.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Created by salem on 7/8/2018.
 */
public class LinkedListTest {

	@Test
	public void testAddInteger() {
		MyLinkedList<Integer> linkedList = new MyLinkedList<>();
		linkedList.add(1);// index 0
		linkedList.add(2);// index 1
		linkedList.add(3);// index 2
		linkedList.add(4);// index 3
		linkedList.add(5);// index 4

		System.out.println("Collection size:" + linkedList.size());
		assertEquals(5, linkedList.size());

		// Check added values
		assertEquals(1, linkedList.get(0).intValue());
		assertEquals(2, linkedList.get(1).intValue());
		assertEquals(3, linkedList.get(2).intValue());
		assertEquals(4, linkedList.get(3).intValue());
		assertEquals(5, linkedList.get(4).intValue());
		assertNull(linkedList.get(5));
	}

	@Test
	public void testAddString() {
		MyLinkedList<String> linkedList = new MyLinkedList<>();

		linkedList.add("This");
		linkedList.add("is");
		linkedList.add("test");
		System.out.println("Collection size:" + linkedList.size());
		assertEquals(3, linkedList.size());

		// Check added values
		assertEquals("This", linkedList.get(0));
		assertEquals("is", linkedList.get(1));
		assertEquals("test", linkedList.get(2));
		assertNull(linkedList.get(3));
	}
}
