package model;

public class Tree {
    // Fields
    private int value;
    private Tree left;
    private Tree right;

    // Constructors
    public Tree(int Ivalue, Tree Ileft, Tree Iright) {
        value = Ivalue;
        left = Ileft;
        right = Iright;
    }

    public Tree(int Ivalue, Tree Ileft) {
        value = Ivalue;
        left = Ileft;
    }

    public Tree(int Ivalue) {
        value = Ivalue;
    }

    // Getter + Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tree getLeftTree() {
        return left;
    }

    public void setLeftTree(Tree leftTree) {
        this.left = leftTree;
    }

    public Tree getRightTree() {
        return right;
    }

    public void setRightTree(Tree rightTree) {
        this.right = rightTree;
    }

    // In-Order Print
    public void str() {
        printInOrder();
        System.out.println("");
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(value + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    // Insertion of value
    public void insertValue(int value) {
        if (this.value < value) {
            this.right.insertValue(value);
        }
        if (this.value > value) {
            this.left.insertValue(value);
        }
    }

}
