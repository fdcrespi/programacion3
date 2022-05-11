package practico2.ejercicio7;

import practico1.ejercicio8.Node;

public class ArbolBinarioWithNode {
    Node<Integer> root;

    public ArbolBinarioWithNode(){
        this.root = null;
    }

    private void setRoot(Node<Integer> nodo){
        this.root = nodo;
    }

    public Integer getRoot(){
        return this.root.getInfo();
    }

    public boolean hasElem(Integer value){
        return isFound(root, value);
    }

    private boolean isFound(Node<Integer> nodo, Integer value){
        if (nodo.getInfo().equals(value)) return true;
        if (nodo.getInfo() < value){
            if(nodo.getPrev() == null) return false;
            return isFound(nodo.getPrev(), value);
        }
        if (nodo.getNext() == null) return false;
        return isFound(nodo.getNext(), value);
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insert(Integer value){
        insertInOrder(root, value);
    }

    private void insertInOrder(Node<Integer> nodo, Integer value){
        if (nodo == null) {
            nodo.setInfo(value);
        }
        if(value < nodo.getInfo()){
            if (nodo.getPrev() == null) nodo.setPrev(new Node<>(value));
            else insertInOrder(nodo.getPrev(), value);
        }
        if (value > nodo.getInfo()){
            if (nodo.getNext() == null) nodo.setNext(new Node<>(value));
            else insertInOrder(nodo.getNext(), value);
        }
    }

    public boolean delete(Integer value){
        //TODO
        return false;
    }

}


/*https://programmerclick.com/article/35711887866/*/