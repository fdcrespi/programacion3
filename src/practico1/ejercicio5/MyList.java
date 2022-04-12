package practico1.ejercicio5;

import practico1.ejercicio1.Node;

import java.util.Iterator;

public class MyList <T> implements Iterable<T>{
    private Node<T> first;
    private int size;

    public MyList() {
        this.first = null;
        this.size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        size++;
    }

    public void insertBack(T info) {
        // TODO Auto-generated method stub
        Node<T> newNode = new Node<T>(info, null);
        Node<T> ult = this.first;
        boolean insert = false;
        while (ult != null && !insert) {
            if(ult.getNext() == null) {
                ult.setNext(newNode);
                insert = true;
            }
            ult = ult.getNext();
        }
    }

    public T extractFront() {
        if (this.first != null) {
            return null;
        }
        Node<T> tmp = this.first;
        this.first = tmp.getNext();
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        return this.getFirst() == null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= 0 && index < this.size) {
            Node<T> tmp = this.first;
            int cont = 0;
            while (tmp != null && cont < index) {
                tmp = tmp.getNext();
                cont++;
            }
            if (tmp != null) return tmp.getInfo();
            return null;
        }
        return null;
    }

    public int indexOf(T elem) {
        int index = -1;
        if (this.first != null) {
            Node<T> act = this.first;
            int cont = 0;
            while (act != null) {
                if (act.getInfo() == elem) {
                    return cont;
                }
                act = act.getNext();
                cont++;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        String s = "";
        Node<T> tmp = this.first;
        while (tmp != null) {
            s = s + tmp.getInfo();
            if (tmp.getNext() != null) s = s + ", ";
            tmp = tmp.getNext();
        }
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this.first);
    }
}
