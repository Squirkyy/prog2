class Debug {
  public static void main(String[] args) {
    Operator[] ops = new Operator[4]; // Array 1 zu lang
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i + 1, i, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}

enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

// Should not be instanciated with right_==0 and op_==DIVIDE
class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op) {
    this.left_ = left;
    this.right_ = right;
    this.op_ = op;
  }

  double evaluate() {
    if (this.op_ == Operator.DIVIDE && right_ == 0) {
      return 0; // Check if op == divide and right == 0
    }
    switch (this.op_) {
      case ADD: // ADD
        return this.left_ + this.right_;
      case SUBTRACT: // ADD
        return this.left_ - this.right_;
      case MULTIPLY: // MULTIPLY
        return this.left_ * this.right_;
      case DIVIDE: // DIVIDE
        return this.left_ / this.right_;
      default:
        return 0.0;
    }
  }
}

/*
 * Error 1-4
 * Exception in thread "main" java.lang.Error: Unresolved compilation problems:
 * The qualified case label Operator.ADD must be replaced with the unqualified
 * enum constant ADD
 * The qualified case label Operator.SUBTRACT must be replaced with the
 * unqualified enum constant SUBTRACT
 * The qualified case label Operator.MULTIPLY must be replaced with the
 * unqualified enum constant MULTIPLY
 * The qualified case label Operator.DIVIDE must be replaced with the
 * unqualified enum constant DIVIDE
 * 
 * at Expression.evaluate(Debug.java:18)
 * at Debug.main(Debug.java:47)
 * 
 * Error 5:
 * Operator[] ops = new Operator[4]; // Array 1 zu lang
 * 
 * Error 6:
 * if (this.op_ == Operator.DIVIDE && right_ == 0) return (Double) null;
 * //Check if op == divide and right == 0
 * 
 */