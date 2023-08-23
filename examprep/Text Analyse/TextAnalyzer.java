import java.util.*;

public class TextAnalyzer {
    private String text;
    private HashMap<Integer, List<String>> dictionary;

    /**
     * Setter for text
     * 
     * @param text that is to be analysed
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Constructor for a non-null dictionary
     */
    public TextAnalyzer() {
        HashMap<Integer, List<String>> map = new HashMap<>();
        this.dictionary = map;
    }

    /**
     * analyises the the given text by first disecting it into a ArrayList seperated
     * by a space. Then it goes through all words and checks if it's already in a
     * list in the dictionary.
     * if this is not the case, it creates a new one and puts it in the dictionary.
     * after everything, it gets saved in the attribute
     */
    public void analyseText() {
        String[] words = text.split(" ");
        ArrayList<String> wordList = new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        for (String word : words) {
            if (dictionary.containsKey(word.length())) {
                var temp = dictionary.get(word.length());
                temp.add(word);
                dictionary.replace(word.length(), temp);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                dictionary.put(word.length(), list);
            }
        }
    }

    /**
     * Overrides the toString so that we can call the toString on the Object and it
     * returns the content of the dictionary in a row format
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var test : dictionary.entrySet()) {
            sb.append(test.getKey() + ": ");
            for (String word : test.getValue()) {
                sb.append(word + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
