package practico1.ejercicio5;

import practico1.ejercicio1.Node;

import java.util.Iterator;

public class MyIterator <T> implements Iterator<T> {

    private Node<T> cursor;

    public MyIterator(Node<T> first) {
        // TODO Auto-generated constructor stub
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return this.cursor != null;
    }

    @Override
    public T next() {
        // TODO Auto-generated method stub
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

    public T get() {
        return this.cursor.getInfo();
    }
}
