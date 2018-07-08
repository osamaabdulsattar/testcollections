package com.test.collections;

/**
 * Created by salem on 7/8/2018.
 */
public class MyLinkedList<T> {

    private MyNode<T> head;
    private int counter = 0;

    public void add(T data) {

        MyNode<T> temp = new MyNode<T>(data);

        if (head == null) {
            head = temp;
            return;
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

        MyNode<T> temp = new MyNode<T>(data);

        if (head == null)
            head = temp;

        MyNode<T> current = head;

        for (int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }

        temp.setNext(current.getNext());
        current.setNext(temp);

        counter++;
    }


    public T get(int index) {

        MyNode<T> current = null;

        if (head == null)
            return null;

        current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                return null;

            current = current.getNext();
        }

        return current.getData();


    }


    public boolean remove(int index){
        if(head ==null)
            return false;

        MyNode<T> current=head;

        for(int i=0;i<index;i++){
            if(current.getNext()==null)
                return false;

            current= current.getNext();
        }

        current.setNext(current.getNext().getNext());
        return true;
    }

    public int size() {
    return counter;
    }
}
