package com.test.collections;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by salem on 7/8/2018.
 */
public class LinkedListTest {

    MyLinkedList<String> stringList;

    @Before
    public void setUp(){
        stringList = new MyLinkedList<>();
    }

    @Test
    public void testAddInteger() {
        MyLinkedList<Integer> intLinkedList = new MyLinkedList<>();
        intLinkedList.add(1);// index 0
        intLinkedList.add(2);// index 1
        intLinkedList.add(3);// index 2
        intLinkedList.add(4);// index 3
        intLinkedList.add(5);// index 4

        System.out.println("Collection size:" + intLinkedList.size());
        assertEquals(5, intLinkedList.size());

        // Check added values
        assertEquals(1, intLinkedList.get(0).intValue());
        assertEquals(2, intLinkedList.get(1).intValue());
        assertEquals(3, intLinkedList.get(2).intValue());
        assertEquals(4, intLinkedList.get(3).intValue());
        assertEquals(5, intLinkedList.get(4).intValue());
        try {
            intLinkedList.get(5);
            fail("the max index in Linked List found");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), containsString("the max index in Linked List found"));
        }
    }

    @Test
    public void testAddString() {

        stringList.add("This");
        stringList.add("is");
        stringList.add("test");
        System.out.println("Collection size:" + stringList.size());
        assertEquals(3, stringList.size());

        // Check added values
        assertEquals("This", stringList.get(0));
        assertEquals("is", stringList.get(1));
        assertEquals("test", stringList.get(2));
        try {
            stringList.get(3);
            fail("the max index in Linked List found =");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), containsString("the max index in Linked List found ="));
        }
    }

    @Test
    public void testRemoveItem() {

        stringList.add("This");
        stringList.add("is");
        stringList.add("test");
        System.out.println("Collection size:" + stringList.size());
        assertEquals(3, stringList.size());
        stringList.remove(0);
        assertEquals(2, stringList.size());
        assertEquals("is", stringList.get(0));
    }


    @Test
    public void testGetItemFormEmptyLinkedList() {

        try {

            stringList.get(0);
            fail("the max index in Linked List found =");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), containsString("the max index in Linked List found ="));

        }
    }

    @Test
    public void testInsertElementOutOfRangeLinkedList() {

        stringList.add("first element");

        try {
            stringList.add("third element",3);
            fail("the max index in Linked List found =");
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), containsString("the max index in Linked List found ="));

        }

    }

    @Test
    public void testAddLinkedListToLinkedList(){

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("new1");
        myLinkedList.add("new2");
        myLinkedList.add("new3");
        myLinkedList.add("new4");


        stringList.add("old1");
        stringList.add("old2");
        stringList.add("old3");
        stringList.add("old4");

        stringList.addAll(myLinkedList);

        assertEquals(8,stringList.size());
        assertEquals("old1",stringList.get(0));
        assertEquals("new1",stringList.get(4));
    }

    @Test
    public void testAddLinkedListToEmptyLinkedList(){

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("new1");
        myLinkedList.add("new2");
        myLinkedList.add("new3");
        myLinkedList.add("new4");

        stringList.addAll(myLinkedList);

        assertEquals(4,stringList.size());
        assertEquals("new1",stringList.get(0));

    }

    @Test
    public void testClearLinkedList(){

        stringList.add("element1");
        stringList.add("element2");
        stringList.add("element3");
        stringList.add("element4");

        assertEquals(4,stringList.size());

        stringList.clear();

        assertEquals(0,stringList.size());
    }

    @Test
    public void testAddElementAfterClear(){
        stringList.add("element1");
        stringList.add("element2");
        stringList.add("element3");
        stringList.add("element4");

        stringList.clear();

        stringList.add("newElement");
        assertEquals(1,stringList.size());
        assertEquals("newElement",stringList.get(0));
    }

    @Test
    public void testGetLastElement(){
        stringList.add("element1");
        stringList.add("element2");
        stringList.add("element3");
        stringList.add("element4");

        assertEquals("element4",stringList.getLast());
    }

    @Test
    public void testGetLastElementFromEmptyList(){
     assertNull(stringList.getLast());
    }

    // TODO  add search testing and its implementation



}
