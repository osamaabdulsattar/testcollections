package com.test.collections;

/**
 * Created by salem on 7/8/2018.
 */
public class MyLinkedList<T> {

    public static int MIN_INDEX = 0;

    private MyNode<T> head;
    private int counter = 0;

    public void add(T data) {

        MyNode<T> temp = new MyNode<T>(data);

        if (head == null) {
            head = new MyNode<T>(data);
        }

        MyNode<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(temp);

        counter++;
    }

    public int getCounter() {
        return this.counter;
    }

    public void add(T data, int index) {
        if (index < MIN_INDEX)
            throw new IndexOutOfBoundsException("index start from" + MIN_INDEX);

        MyNode<T> temp = new MyNode<T>(data);

        if (head == null)
            head = new MyNode<T>(data);

        MyNode<T> current = head.getNext();

        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                throw new IndexOutOfBoundsException("the max index in Linked List found =" + (getCounter() - 1) + " but you insert " + index);
            current = current.getNext();
        }

        temp.setNext(current.getNext());
        current.setNext(temp);

        counter++;
    }


    public T get(int index) {

        if (index < MIN_INDEX)
            throw new IndexOutOfBoundsException("index start from" + MIN_INDEX);

        MyNode<T> current = null;

        if (head == null)
            throw new IndexOutOfBoundsException("the max index in Linked List found =" + (getCounter() - 1) + " but you insert " + index);


        current = head.getNext();
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                throw new IndexOutOfBoundsException("the max index in Linked List found =" + (getCounter() - 1) + " but you insert " + index);

            current = current.getNext();
        }

        return current.getData();


    }


    public boolean remove(int index) {
        if (head == null)
            throw new IndexOutOfBoundsException("Linked list is already empty");

        MyNode<T> current = head;

        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                throw new IndexOutOfBoundsException("the max index in Linked List found =" + (getCounter() - 1) + " but you insert " + index);


            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        counter--;
        return true;
    }

    public int size() {
        return counter;
    }

    public boolean addAll(MyLinkedList<T> myLinkedList) {

        int myListSize=myLinkedList.size();
        if(head==null) {
            if (myListSize < 1)
                return false;

            if (myListSize > 0)
                head = new MyNode<T>(myLinkedList.get(0));
        }

        for(int i=0;i<myLinkedList.size();i++){
            this.add(myLinkedList.get(i));
        }
        return true;
    }

    public void clear() {
        head=null;
        counter=0;
    }

    public T getLast() {
        if(head==null)
            return null;
        return this.get(counter-1);
    }
}
