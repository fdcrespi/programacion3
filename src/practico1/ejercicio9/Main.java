package practico1.ejercicio9;

import practico1.ejercicio8.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Character> palabra = new MyList<>();
        String pal = "rallar";
        for (int i = 0; i < pal.length(); i++) {
            palabra.insertFront(pal.charAt(i));
        }
        System.out.println(palabra);
        System.out.println(isPalindrome(palabra));
    }

    private static boolean isPalindrome(MyList<Character> palabra) {
        if (!palabra.isEmpty()) {
            for (int i = 0; i < palabra.getSize()/2; i++) {
                if (!palabra.get(i).equals(palabra.get(palabra.getSize() - 1 - i))){
                    return false;
                }
            }
            return true;
        } else return false;
    }
}
