import model.Tree;

public class Main {
    public static void main(String[] args) {
        Tree test1 = TestTree1();
        Tree test2 = TestTree2();
        test1.str();
        test2.str();
    }

    public static Tree TestTree1() {
        Tree root = new Tree(1);
        Tree left = new Tree(2);
        Tree right = new Tree(3);
        root.setLeftTree(left);
        root.setRightTree(right);
        Tree left_left = new Tree(4);
        Tree left_right = new Tree(5);
        left.setLeftTree(left_left);
        left.setRightTree(left_right);
        Tree right_left = new Tree(6);
        Tree right_right = new Tree(7);
        right.setLeftTree(right_left);
        right.setRightTree(right_right);
        return root;
    }

    public static Tree TestTree2() {
        Tree root = new Tree(10);
        Tree left = new Tree(20);
        Tree right = new Tree(30);
        root.setLeftTree(left);
        root.setRightTree(right);
        Tree left_left = new Tree(40);
        Tree left_right = new Tree(50);
        left.setLeftTree(left_left);
        left.setRightTree(left_right);
        Tree right_left = new Tree(60);
        Tree right_right = new Tree(70);
        right.setLeftTree(right_left);
        right.setRightTree(right_right);
        Tree left_left_left = new Tree(80);
        left_left.setLeftTree(left_left_left);
        Tree right_right_left = new Tree(90);
        right_right.setLeftTree(right_right_left);
        return root;
    }
}
