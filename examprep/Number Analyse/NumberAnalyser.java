import java.util.*;

public class NumberAnalyser {
    String input = "";
    HashMap<Integer, LinkedList<Integer>> analysis;

    public NumberAnalyser() {
        this.analysis = new HashMap<>();
    }

    public void setInput(String s) {
        this.input = s;
    }

    void analyseSequence() {
        String[] seperated = input.split(" ");
        for (String s : seperated) {
            int i = 0;
            char[] digits = s.toCharArray();
            for (char c : digits) {
                i += Integer.parseInt(String.valueOf(c));
            }
            if (!this.analysis.containsKey(i)) {
                LinkedList<Integer> tmp = new LinkedList<>();
                tmp.add(Integer.parseInt(s));
                this.analysis.put(i, tmp);
            } else {
                this.analysis.get(i).add(Integer.parseInt(s));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var entry : this.analysis.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            for (var number : entry.getValue()) {
                sb.append(number + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}