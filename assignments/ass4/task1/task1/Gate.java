package task1;

public class Gate {

    String symbol = "XOR";
    int[] bitpossibilities = { 0, 1 };

    public boolean evaluate(boolean a, boolean b) {
        return false;
    }

    public void table() {
        StringBuilder sb = new StringBuilder();
        sb.append("|A|");
        sb.append("");
        sb.append("|B|");
        sb.append("");
        sb.append("|A ");
        sb.append(symbol);
        sb.append(" B|");
        sb.append("\n");
        int width = sb.length() - 1;
        for (int i = 0; i < width; i++) {
            sb.append("-");
        }
        sb.append("\n");
        for (int a : bitpossibilities) {
            for (int b : bitpossibilities) {
                sb.append("|" + a + "|");
                sb.append("|" + b + "|");
                sb.append("|   " + (a ^ b) + "   |");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}