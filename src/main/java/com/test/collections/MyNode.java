package com.test.collections;

/**
 * Created by salem on 7/8/2018.
 */
public class MyNode<T> {

	MyNode<T> next;
	T data;

	public MyNode(T data) {
		this.next = null;
		this.data = data;
	}

	public MyNode(T data, MyNode<T> next) {
		this.next = next;
		this.data = data;
	}

	public MyNode<T> getNext() {
		return next;
	}

	public void setNext(MyNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MyNode [next=" + next + ", data=" + data + "]";
	}

}
