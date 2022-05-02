package practico2.ejercicio7;

import java.util.ArrayList;

public class ArbolBinario {
    private Integer info;
    private ArbolBinario arbolizq;
    private ArbolBinario arbolder;

    public ArbolBinario(Integer valor){
        this.info = valor;
        this.arbolizq = null;
        this.arbolder = null;
    }

    public ArbolBinario(){
        this.info = null;
        this.arbolizq = null;
        this.arbolder = null;
    }

    /**
     * Retorna la raiz del arbol
     * Complejidad: O(1)
     * */
    public Integer getRoot(){
        return this.info;
    }

    /**
     * Retorna si el arbol tiene un elemento
     * Complejidad:
     * O(n) si n es la cantidad de nodos y tengo una enredadera
     * O(log2n) suponiendo que el arbol esta balanceado
     * O(h) donde h es la altura del arbol --> mejor opción
     * */
    public boolean hasElem(Integer valor){
        if (getRoot() == null) return false;
        if (getRoot().equals(valor)) return true;
        if (valor < getRoot() && arbolizq != null) return arbolizq.hasElem(valor);
        if (valor > getRoot() && arbolder != null) return arbolder.hasElem(valor);
        return false;
    }

    public boolean isEmpty(){
        return (this.getRoot() == null);
    }

    public void insert(Integer valor){
        if(getRoot() != null) {
            if (valor < getRoot()) {
                if (this.arbolizq == null) this.arbolizq = new ArbolBinario(valor);
                else arbolizq.insert(valor);
            } else if (valor > getRoot()) {
                if (this.arbolder == null) this.arbolder = new ArbolBinario(valor);
                else arbolder.insert(valor);
            }
        } else this.info = valor;
    }

    public Integer getHeight(){
        if (getRoot() == null) return 0;
        if (arbolizq == null && arbolder == null) return 1;
        int heightIzq = 0;
        int heightDer = 0;
        if (arbolizq != null)
            heightIzq += arbolizq.getHeight() + 1;
        if (arbolder != null)
            heightDer += arbolder.getHeight() + 1;
        return Math.max(heightIzq, heightDer);
    }

    public boolean delete(Integer valor){
        if (getRoot() == null) return false;
        /* Si la raiz es igual */
        if (getRoot().equals(valor)) {
            if (arbolizq == null && arbolder == null) {
                this.info = null;
            }
            else if (arbolizq == null && arbolder != null) {
                this.info = arbolder.getRoot();
                this.arbolder = arbolder.arbolder;
                this.arbolizq = arbolder.arbolizq;
            }
            else if (arbolder == null && arbolizq != null) {
                this.info = arbolizq.getRoot();
                this.arbolder = arbolizq.arbolder;
                this.arbolizq = arbolizq.arbolizq;
            }
            else {
                ArbolBinario aux = arbolder;
                ArbolBinario newDer = new ArbolBinario();
                while (aux.arbolizq != null) {
                    newDer.insert(aux.getRoot());
                    aux = aux.arbolizq;
                }
                this.info = aux.getRoot();
                if (newDer.getRoot() != null) {
                    this.arbolder = newDer;
                } else this.arbolder = null;
            }
            return true;
        }
        /* Si el valor es menor */
        if (valor < getRoot()) {
            if (arbolizq != null) {
                if (arbolizq.getRoot().equals(valor)) {
                    if (arbolizq.arbolizq == null && arbolizq.arbolder == null) {
                        this.arbolizq = null;
                    } else if (arbolizq.arbolizq == null && arbolizq.arbolder != null) {
                        this.arbolizq = arbolizq.arbolder;
                    } else if (arbolizq.arbolder == null && arbolizq.arbolizq != null) {
                        this.arbolizq = arbolizq.arbolizq;
                    } else {
                        ArbolBinario aux = arbolizq.arbolder;
                        while (aux.arbolizq != null) {;
                            aux = aux.arbolizq;
                        }
                        aux.arbolizq = arbolizq.arbolizq;
                        this.arbolizq = aux;
                    }
                    return true;
                }
                else arbolizq.delete(valor);
            }
        }
        /* Si el valor es mayor */
        else if (valor > getRoot()) {
            if (arbolder != null) {
                if (arbolder.getRoot().equals(valor)) {
                    if (arbolder.arbolizq == null && arbolizq.arbolder == null) {
                        this.arbolder = null;
                    } else if (arbolizq.arbolizq == null && arbolizq.arbolder != null) {
                        this.arbolder = arbolizq.arbolder;
                    } else if (arbolizq.arbolder == null && arbolizq.arbolizq != null) {
                        this.arbolder = arbolizq.arbolizq;
                    } else {
                        ArbolBinario aux = arbolder.arbolder;
                        while (aux.arbolizq != null) {;
                            aux = aux.arbolizq;
                        }
                        aux.arbolizq = arbolder.arbolizq;
                        this.arbolder = aux;
                    }
                    return true;
                }
                else arbolder.delete(valor);
            }
        }
        return false;
    }

    private void setChild(ArbolBinario elemDelete){
        if (elemDelete.arbolizq == null && elemDelete.arbolder == null) {
            this.arbolizq = null;
        }
        else if (elemDelete.arbolizq == null && elemDelete.arbolder != null) {
            this.arbolizq = elemDelete.arbolder;
        }
        else if (elemDelete.arbolder == null && elemDelete.arbolizq != null) {
            this.arbolizq = elemDelete.arbolizq;
        }
        else {
            ArbolBinario aux = elemDelete.arbolder;
            while (aux.arbolizq != null) {;
                aux = aux.arbolizq;
            }
            aux.arbolizq = elemDelete.arbolizq;
            this.arbolizq = aux;
        }
    }

    public void printInOrder(){
        System.out.println(this.stringInOrder());
    }

    /**
     * Imprime el arbol en orden
     * Complejidad: O(n) donde n son la cantidad de nodos del arbol
     * */
    private String stringInOrder(){
        String s = "";
        if (arbolizq != null) s += arbolizq.stringInOrder() + " ";
        s += getRoot();
        if (arbolder != null) s += " " + arbolder.stringInOrder();
        return s;
    }

    public void printPostOrder(){
        System.out.println(this.stringPostOrder());
    }

    private String stringPostOrder(){
        String s = "";
        if (arbolizq != null) s += arbolizq.stringPostOrder() + " ";
        if (arbolder != null) s += arbolder.stringPostOrder() + " ";
        s += getRoot();
        return s;
    }

    public void printPreOrder(){
        System.out.println(this.stringPreOrder());
    }

    private String stringPreOrder(){
        String s = "";
        s += getRoot();
        if (arbolizq != null) s += " " + arbolizq.stringPreOrder();
        if (arbolder != null) s += " " + arbolder.stringPreOrder();
        return s;
    }

    public ArrayList<Integer> getLongestBranch(){
        if (getRoot() == null) return null;
        if (arbolizq == null && arbolder == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(getRoot());
            return list;
        };
        ArrayList<Integer> listaIzq = new ArrayList<>();
        ArrayList<Integer> listaDer = new ArrayList<>();
        if (arbolizq != null) {
            listaIzq.add(getRoot());
            listaIzq.addAll(arbolizq.getLongestBranch());
        }
        if (arbolder != null) {
            listaDer.add(getRoot());
            listaDer.addAll(arbolder.getLongestBranch());
        }
        return (listaIzq.size() > listaDer.size()) ? listaIzq : listaDer;
    }

    public ArrayList<Integer> getFrontera() {
        if (getRoot() == null) return null;
        if (arbolizq == null && arbolder == null) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(getRoot());
            return list;
        }
        ArrayList<Integer> lista = new ArrayList<>();
        if (arbolizq != null) {
            lista.addAll(arbolizq.getFrontera());
        }
        if (arbolder != null) {
            lista.addAll(arbolder.getFrontera());
        }
        return lista;
    }

    public Integer getMaxElem(){
        if (getRoot() == null) return null;
        if (arbolder == null) return getRoot();
        return arbolder.getMaxElem();
    }

    public ArrayList<Integer> getElemAtLevel(int nivel){
        if (getRoot() == null) return null;
        if (nivel == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(getRoot());
            return list;
        }
        ArrayList<Integer> lista = new ArrayList<>();
        if (arbolizq != null) {
            lista.addAll(arbolizq.getElemAtLevel(nivel - 1));
        }
        if (arbolder != null) {
            lista.addAll(arbolder.getElemAtLevel(nivel - 1));
        }
        return lista;
    }

}