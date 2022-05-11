package practico2.ejercicio7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArbolBinario AB = new ArbolBinario(30);
        AB.insert(40);
        AB.insert(35);
        AB.insert(60);
        AB.insert(32);
        AB.insert(37);
        AB.insert(20);
        AB.printInOrder();
        AB.delete(30);
        AB.printInOrder();
        /*
        System.out.println("¿Contiene al elemento?: " + AB.hasElem(18));
        System.out.println("¿Esta vacio?: " + AB.isEmpty());
        System.out.println("La altura del arbol es: " + AB.getHeight());
        AB.printPreOrder();
        AB.printPostOrder();
        System.out.println("La rama mas larga es: " + AB.getLongestBranch());
        System.out.println("Los nodos fronteras/hojas son: " + AB.getFrontera());
        System.out.println("El elemento maximo es: " + AB.getMaxElem());
        System.out.println("Elementos del nivel: " + AB.getElemAtLevel(3));
        */
    }
}
