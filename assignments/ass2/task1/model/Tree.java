package model;

import java.util.ArrayList;

public class Tree {
    // Fields
    private int value;
    private Tree left;
    private Tree right;
    private ArrayList<Integer> inOrderList;

    // Constructors
    public Tree(int Ivalue, Tree Ileft, Tree Iright) {
        value = Ivalue;
        left = Ileft;
        right = Iright;
        inOrderList = new ArrayList<Integer>();
    }

    public Tree(int Ivalue, Tree Ileft) {
        value = Ivalue;
        left = Ileft;
        inOrderList = new ArrayList<Integer>();
    }

    public Tree(int Ivalue) {
        value = Ivalue;
        inOrderList = new ArrayList<Integer>();
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
    public String str() {
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.str());
        }
        sb.append(value).append(" ");
        if (right != null) {
            sb.append(right.str());
        }
        return sb.toString();
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
        for (Integer integer : inOrderList) {
            if (integer == value) {
                return true;
            }
        }
        return false;
    }

    // Compare two trees
    public boolean hasSameValues(Tree other) {
        if (this.str().equals(other.str())) {
            return true;
        }
        return false;
    }

}
