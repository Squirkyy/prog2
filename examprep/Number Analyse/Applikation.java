import java.util.Scanner;

public class Applikation {

    public static void main(String[] args) {
        NumberAnalyser na = new NumberAnalyser();
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.println("What does your sequence look like?");
            String input = sn.nextLine();
            na.setInput(input);
            na.analyseSequence();
            System.out.println(na.toString());
            System.out.println("Do you want to analyse another Sequence? (y/n)");
            String prompt = sn.nextLine();
            if (!(prompt.toLowerCase().trim().equals("y")))
                break;
        }
        sn.close();
    }
}