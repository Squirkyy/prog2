package task1;

public enum Action {
    A, B;

    public char str() {
        switch (this) {
            case A:
                return 'A';
            case B:
                return 'B';
            default:
                return ' ';
        }
    }
}
