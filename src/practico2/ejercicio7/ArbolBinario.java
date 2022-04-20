package practico2.ejercicio7;

import java.util.Objects;

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

    public Integer getRoot(){
        return this.info;
    }

    public boolean hasElem(Integer valor){
        return (this.getRoot().equals(valor) || arbolizq.hasElem(valor) || arbolder.hasElem(valor));
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
    public boolean delete(Integer valor){
        if(this.getRoot().equals(valor)){
            this.info = null;
            return true;
        }
        if (valor < getRoot()){
            if (arbolizq == null) return false;
            return this.arbolizq.delete(valor);
        } else {
            if (arbolder == null) return false;
            return this.arbolder.delete(valor);
        }
    }

    public void printInOrder(){
        System.out.println(this.stringInOrder());
    }

    public String stringInOrder(){
        String s = "";
        if (arbolizq != null) s += arbolizq.stringInOrder() + " - ";
        s += getRoot();
        if (arbolder != null) s += " - " + arbolder.stringInOrder();
        return s;
    }
}
