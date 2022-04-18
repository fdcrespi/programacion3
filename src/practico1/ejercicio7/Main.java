package practico1.ejercicio7;

import practico1.ejercicio5.MyIterator;
import practico1.ejercicio5.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list1 = new MyList<>();
        MyList<Integer> list2 = new MyList<>();
        list1.insertFront(24);
        list1.insertFront(19);
        list1.insertFront(14);
        list1.insertFront(5);
        list2.insertFront(25);
        list2.insertFront(19);
        list2.insertFront(14);
        list2.insertFront(6);
        System.out.println(list1);
        System.out.println(list2);
        // a) Construir una lista ordinada a partir de dos desordenadas
        MyList<Integer> list3 = inOneList(list1, list2);
        System.out.println(list3);
    }

    private static MyList<Integer> inOneList(MyList<Integer> list1, MyList<Integer> list2) {
        MyList<Integer> listResult = new MyList<>();
        MyIterator<Integer> it1 = (MyIterator<Integer>) list1.iterator();
        MyIterator<Integer> it2 = (MyIterator<Integer>) list2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if(list2.indexOf(it1.get()) == -1){
                listResult.insertBack(it1.get());
            }
            it1.next();
        }
        return listResult;
    }
}
