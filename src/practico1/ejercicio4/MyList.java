package practico1.ejercicio4;

import practico1.ejercicio1.Node;

public class MyList <T>{

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
        if (index < 0 || index > this.size-1) {
            return null;
        }
        Node<T> tmp = this.first;
        int cont = 0;
        while (tmp != null && cont < index) {
            tmp = tmp.getNext();
            cont++;
        }
        return tmp.getInfo();
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
}
