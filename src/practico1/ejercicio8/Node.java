package practico1.ejercicio8;

public class Node<T>{
    private T info;
    private Node<T> next;
    private Node<T> prev;

    public Node(){
        this.info = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }

    public Node(T info, Node<T> next, Node<T> prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        String s = "";
        s += "info=" + info;
        if(prev != null) s += ", prev=" + prev.getInfo();
        if(next != null) s += ", next=" + next.getInfo();
        return s;
    }
}
