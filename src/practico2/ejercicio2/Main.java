package practico2.ejercicio2;

import practico1.ejercicio5.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.insertFront(8);
        list.insertFront(5);
        list.insertFront(18);
        list.insertFront(10);
        System.out.println(searchInList(list,18, 0));
    }

    private static int searchInList(MyList<Integer> list, int info, int inicio) {
        if(list.isEmpty()) return -1;
        if (inicio < list.size() || list.get(inicio) == info) {
            searchInList(list, info, ++inicio);
        }
        if (list.get(inicio) != null && list.get(inicio) == info) return inicio;
        return -1;
    }
}
