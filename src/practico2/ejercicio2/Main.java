package practico2.ejercicio2;

import practico1.ejercicio8.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.insertFront(8);
        list.insertFront(5);
        list.insertFront(18);
        list.insertFront(10);
        int pos = searchInList(list,8, 0);
        System.out.println(pos);
    }

    private static int searchInList(MyList<Integer> list, int info, int inicio) {
        if (list.isEmpty()) return -1;
        int infoElem = list.get(inicio);
        if (inicio < list.getSize() && infoElem != info) {
            return searchInList(list, info, ++inicio);
        }
        if (infoElem == info) return inicio;
        return -1;
    }
}
