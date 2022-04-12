package practico1.ejercicio4;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.insertFront(8);
        list.insertFront(2);
        System.out.println(list);
        System.out.println(list.indexOf(8));
    }
}
