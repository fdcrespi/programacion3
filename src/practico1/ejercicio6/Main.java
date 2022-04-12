package practico1.ejercicio6;

import practico1.ejercicio5.MyIterator;
import practico1.ejercicio5.MyList;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyList<Integer> list1 = new MyList<Integer>();
        MyList<Integer> list2 = new MyList<Integer>();
        list1.insertFront(24);
        list1.insertFront(19);
        list1.insertFront(14);
        list1.insertFront(5);
        list2.insertFront(25);
        list2.insertFront(19);
        list2.insertFront(14);
        list2.insertFront(5);
        // a) Construir una lista ordinada a partir de dos desordenadas
        MyList<Integer> list3 = listOrderListsOrdered(list1, list2);
        System.out.println(list3);
    }

    private static MyList<Integer> listOrderListsUnordered(MyList<Integer> list1, MyList<Integer> list2) {
        //TODO
        return null;
    }

    private static MyList<Integer> listOrderListsOrdered(MyList<Integer> list1, MyList<Integer> list2) {
        MyList<Integer> listResult = new MyList<Integer>();
        MyIterator<Integer> it1 = (MyIterator<Integer>) list1.iterator();
        MyIterator<Integer> it2 = (MyIterator<Integer>) list2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            if(it1.get().equals(it2.get())) {
                listResult.insertBack(it1.get());
                it1.next();
                it2.next();
            }
            else if (it1.get() < it2.get()) {
                it2.next();
            }
            else it1.next();
        }
        return listResult;
    }
}
