package debug.model;

//Inserts integers in a sorted way. Only needs to search in one subtree as a
//result.
public class SortedIntBinTreeNode extends IntBinTreeNode {
  
  public SortedIntBinTreeNode(int content, SortedIntBinTreeNode left, SortedIntBinTreeNode right) {
    super(content, left, right);
    if ((left != null && left.content_ >= content) || (right != null && right.content_ <= content)) {
      System.err.println("Trying to create invalid sorted tree.");
      System.exit(2);
    }
  }

  /**
   * Inserts integer into the sorted tree.
   * Smaller Integers will be placed into the left subtree, larger ones into
   * the right subtree. Equal ones will be ignored
   * 
   * @param i Integer to insert.
   */
  @Override
  public void insert(int i) {
    if (i > super.content_) {
      if (super.left_ == null) 
        super.left_ = new SortedIntBinTreeNode(i, null, null);
      else
        super.left_.insert(i);
    } else if (i < super.content_) {
      if (super.right_ == null) 
        super.right_ = new SortedIntBinTreeNode(i, null, null);
      else
        super.right_.insert(i);
    }
  }
}