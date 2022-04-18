package practico1.ejercicio5;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        System.out.println(list);
        System.out.println(list.get(4));
    }
}
