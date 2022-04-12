package practico1.ejercicio8;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.insertFront(4);
        list.insertFront(5);
        list.insertFront(6);
        System.out.println(list);
        System.out.println("Size: " + list.getSize());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
    }
}
