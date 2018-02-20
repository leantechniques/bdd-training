package co.leantechniques;

import java.util.LinkedList;

public class Stack<T> {

    private LinkedList<T> _innerList = new LinkedList<>();

    public int size() {
        return _innerList.size();
    }

    public Stack put(T value) {
        _innerList.add(value);
        return this;
    }

    public T pop() {
        if(_innerList.isEmpty()) throw new IndexOutOfBoundsException();

        return _innerList.removeLast();
    }
}
