import model.Tree;

public class Main {
    public static void main(String[] args) {
        testTree();
        System.out.println();
        System.out.println();
        testTree2();
    }

    protected static void testTree() {
        Tree tree1 = new Tree(5);
    
        tree1.insertValue(2);
        tree1.insertValue(7);
        tree1.insertValue(1);
        tree1.insertValue(9);
        tree1.insertValue(4);
    
        System.out.println("Tree 1: " + tree1.str());
    
        int valueToFind = 4;
        if (tree1.contains(valueToFind)) {
            System.out.println("Tree 1 contains " + valueToFind);
        } else {
            System.out.println("Tree 1 totally does not contain " + valueToFind);
        }
    
        Tree tree2 = new Tree(5);
        tree2.insertValue(2);
        tree2.insertValue(7);
        tree2.insertValue(1);
        tree2.insertValue(9);
        tree2.insertValue(4);
    
        System.out.println("Tree 2: " + tree2.str());
    
        if (tree1.hasSameValues(tree2)) {
            System.out.println("Tree 1 and Tree 2 pass the vibe check");
        } else {
            System.out.println("Tree 1 and Tree 2 do not pass the vibe check");
        }
    }

    protected static void testTree2() {
        Tree tree1 = new Tree(15);
    
        tree1.insertValue(12);
        tree1.insertValue(17);
        tree1.insertValue(11);
        tree1.insertValue(19);
        tree1.insertValue(14);
    
        System.out.println("Tree 1: " + tree1.str());
    
        int valueToFind = 14;
        if (tree1.contains(valueToFind)) {
            System.out.println("Tree 1 contains " + valueToFind);
        } else {
            System.out.println("Tree 1 does not contain " + valueToFind);
        }
    
        Tree tree2 = new Tree(15);
        tree2.insertValue(12);
        tree2.insertValue(17);
        tree2.insertValue(11);
        tree2.insertValue(19);
        tree2.insertValue(14);
    
        System.out.println("Tree 2: " + tree2.str());
    
        if (tree1.hasSameValues(tree2)) {
            System.out.println("Tree 1 and Tree 2 have the same values");
        } else {
            System.out.println("Tree 1 and Tree 2 do not have the same values");
        }
    }
    
    
}
