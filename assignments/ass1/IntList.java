public class IntList {
    public static void main(String[] args) {
        System.out.println(listToInt(intToList(9826)));
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
}