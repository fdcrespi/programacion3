package practico1.ejercicio1;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> l = new MyList<Integer>();
        l.insertFront(2);
        l.insertFront(8);
        System.out.println(l);
        System.out.println(l.get(0));
    }
}
