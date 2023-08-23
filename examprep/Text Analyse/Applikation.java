public class Applikation {
    /**
     * runs the application by calling the static input and analyising it on loop
     * until terminated or specified
     * 
     * @param args Console args
     */
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Wie lautet ihre Eingabe?");
            TextAnalyzer test = new TextAnalyzer();
            test.setText(TextInput.readLine());
            test.analyseText();
            System.out.println(test);
            System.out.println("Wollen Sie noch einen Text analyisieren? (y/n)");
            String input = TextInput.readLine();
            if (input.equals("y")) {
                continue;
            } else {
                break;
            }
        }

    }

}
