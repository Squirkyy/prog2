package debug.model;

// Abstract class that represents a binary tree. Inserting and searching are handled by derived classes.
public abstract class IntBinTreeNode {
  protected int content_;
  protected IntBinTreeNode left_, right_;

  public IntBinTreeNode(int content, IntBinTreeNode left, IntBinTreeNode right) {
    this.content_ = content;
    this.left_    = left;
    this.right_   = right;
  }

  public int getContent() {
    return this.content_;
  }

  public void setContent(int content) {
    this.content_ = content;
  }

  public IntBinTreeNode getLeft() {
    return this.left_;
  }

  public void setLeft(IntBinTreeNode left) {
    this.left_ = left;
  }

  public IntBinTreeNode getRight() {
    return this.right_;
  }

  public void setRight(IntBinTreeNode right) {
    this.right_ = right;
  }

  /**
   * Inserts integer into appropriate place in tree.
   * Inserting methodology is dictated by derived classes.
   * 
   * @param i Integer to insert.
   */
  public abstract void insert(int i);

  /**
   * Looks up, whether integer is contained within tree.
   * Searching methodology is dictated by derived classes.
   * 
   * @param i Integer to search for.
   * @return  True if integer is in tree.
   */
  public abstract boolean contains(int i);

  @Override
  public String toString() {
    return String.format(
      "(%s %d %s)",
      this.left_ == null ? "_" : this.left_.toString(),
      this.content_,
      this.right_ == null ? "_" : this.right_.toString()
    );
  }
}