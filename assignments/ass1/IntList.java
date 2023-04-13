import java.util.Arrays;

public class IntList {
    public static void main(String[] args) {
        testFunction();
    }

    public static int countNumbers(int num) {
        return (int) (Math.log10(num) + 1);
    }

    public static int[] intToList(int value) {
        int[] list = new int[countNumbers(value)];
        int i = countNumbers(value) - 1;
        while (value > 0) {
            int remainer = value % 10;
            list[i] = remainer;
            value = value / 10;
            i--;
        }
        return list;
    }

    public static int listToInt(int[] list) {
        int num = 0;
        int factor = 1;
        for (int i = list.length - 1; i >= 0; i--) {
            num += list[i] * factor;
            factor *= 10;
        }
        return num;
    }
    public static int[] addOne (int[] numbers) {
        return intToList(1+listToInt(numbers));
    }

    private static void testFunction() {
        int number1 = 5291;
        int number2 = 9999;
        int[] number1array = intToList(number1);
        int[] number2array = intToList(number2);
        System.out.println("countNumbers: ");
        System.out.println(number1 + " has the size: " + countNumbers(number1));
        System.out.println(number2 + " has the size: " + countNumbers(number2));
        System.out.println("");
        System.out.println("intToList:");
        System.out.println(number1 + " is the following as an array: " + Arrays.toString(number1array));
        System.out.println(number2 + " is the following as an array: " + Arrays.toString(number2array));
        System.out.println("");
        System.out.println("listToInt:");
        System.out.println(Arrays.toString(number1array) + " is the following as an int: " + listToInt(number1array));
        System.out.println(Arrays.toString(number2array) + " is the following as an int: " + listToInt(number2array));
        System.out.println("");
        System.out.println("addOne:");
        System.out.println(Arrays.toString(number1array) + " is the following when added 1: " + Arrays.toString(addOne(number1array)));
        System.out.println(Arrays.toString(number2array) + " is the following when added 1: " + Arrays.toString(addOne(number2array)));
    }
}