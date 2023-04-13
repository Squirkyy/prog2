import java.util.Arrays;

public class IntList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intToList(1241)));
    }

    public static int countNumbers (int num) {
        return (int)(Math.log10(num)+1);
    }

    public static int[] intToList(int value) {
        int[] list = new int[countNumbers(value)];
        int i = 0;
        while (value > 0) {
            int remainer = value % 10;
            list[i] = remainer;
            
        }
        return list;
    }

}