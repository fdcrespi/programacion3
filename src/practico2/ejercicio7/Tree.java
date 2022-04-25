package practico2.ejercicio7;

public class Tree {

    private Integer value;
    private Tree left;
    private Tree right;

    public Tree(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void add(Integer newValue) {
        if (this.value == null)
            this.value = newValue;
        else {
            if (this.value > newValue) {
                if (this.left == null)
                    this.left = new Tree(newValue);
                else
                    this.left.add(newValue);
            } else if (this.value < newValue) {
                if (this.right == null)
                    this.right = new Tree(newValue);
                else
                    this.right.add(newValue);
            }
        }
    }
}
