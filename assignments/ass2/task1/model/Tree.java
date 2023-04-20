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
        // if (value == null)
        if (value < this.value) {
            if (this.left == null) {
                this.left = new Tree(value);
            } else {
                this.left.insertValue(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Tree(value);
            } else {
                this.right.insertValue(value);
            }
        }
    }

    // Search through
    public boolean contains(int value) {
        if (this.value == value)
            return true;
        else if (value > this.value && this.right != null) {
            return this.right.contains(value);
        } else if (value < this.value && this.left != null) {
            return this.left.contains(value);
        } else {
            return false;
        }
    }

    // Compare two trees
    public boolean hasSameValues(Tree other) {
        if (other == null)
            return false;
        if (this.value == other.value) {
            if (other.left != null && this.left != null) {
                if (!this.left.hasSameValues(other.left))
                    return false;
            } else if (other.left != null || this.left != null) {
                return false;
            }
            if (other.right != null && this.right != null) {
                if (!this.right.hasSameValues(other.right))
                    return false;
            } else if (this.right != null || other.right != null) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

}
