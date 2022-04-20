package practico2.ejercicio7;

public class Main {
    public static void main(String[] args) {
        ArbolBinario AB = new ArbolBinario(10);
        AB.insert(3);
        AB.insert(6);
        AB.insert(12);
        AB.insert(11);
        boolean delete = AB.delete(6);
        System.out.println(delete);
        AB.insert(7);
        AB.printInOrder();
    }
}
