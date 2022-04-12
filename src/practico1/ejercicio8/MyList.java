package practico1.ejercicio8;

import java.util.Iterator;

public class MyList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void insertFront(T info){
        Node<T> tmp = new Node<>(info);
        if (this.first == null) {
            this.last = tmp;
        } else {
            if (this.first.getNext() == null) {
                this.last.setPrev(tmp);
            }
            this.first.setPrev(tmp);
        }
        tmp.setNext(this.first);
        this.first = tmp;
        size++;
    }

    public T extractFront(){
        Node<T> tmp = first;
        this.first = tmp.getNext();
        this.first.setPrev(null);
        return tmp.getInfo();
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public int getSize(){
        return size;
    }

    public T getFirst() {
        return first.getInfo();
    }

    public T getLast() {
        return last.getInfo();
    }

    public T get(int index){
        Node<T> tmp = first;
        int cont = 0;
        if (index < 0 || index >= size) return null;
        while (cont < index && tmp != null){
            cont++;
            tmp = tmp.getNext();
        }
        if(tmp != null) return tmp.getInfo();
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        Node<T> tmp = first;
        while (tmp != null){
            s += tmp.getInfo();
            if (tmp.getNext() != null){
                s+= ", ";
            }
            tmp = tmp.getNext();
        }
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
    }
}
