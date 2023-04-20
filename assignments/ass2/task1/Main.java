import model.Tree;

public class Main {
    public static void main(String[] args) {
        Tree test1 = TestTree1();
        Tree test2 = TestTree2();
        test1.str();
        test2.str();
    }

    public static Tree TestTree1() {
        Tree root = new Tree(4);
        Tree leftChild = new Tree(2);
        Tree rightChild = new Tree(6);
        root.setLeftTree(leftChild);
        root.setRightTree(rightChild);
        leftChild.setLeftTree(new Tree(1));
        leftChild.setRightTree(new Tree(3));
        rightChild.setLeftTree(new Tree(5));
        rightChild.setRightTree(new Tree(7));
        return root;
    }

    public static Tree TestTree2() {
        Tree root = new Tree(10);
        Tree leftChild = new Tree(5);
        Tree rightChild = new Tree(15);
        root.setLeftTree(leftChild);
        root.setRightTree(rightChild);
        leftChild.setLeftTree(new Tree(2));
        leftChild.setRightTree(new Tree(7));
        rightChild.setLeftTree(new Tree(13));
        rightChild.setRightTree(new Tree(17));
        return root;
    }
}
