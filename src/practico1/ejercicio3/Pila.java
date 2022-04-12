package practico1.ejercicio3;

import practico1.ejercicio1.MyList;

public class Pila <T>{
    private MyList<T> list;

    public Pila() {
        this.list = new MyList<T>();
    }

    public void push(T o) {
        list.insertFront(o);
    }

    public T pop() {
        return list.extractFront();
    }

    public T top() {
        return list.get(0);
    }

    public void reverse() {
        if (this.list != null) {
            MyList<T> reverseList = new MyList<T>();
            while(!this.list.isEmpty()) {
                reverseList.insertFront(this.list.extractFront());
            }
            this.list = reverseList;
        }
    }
}
