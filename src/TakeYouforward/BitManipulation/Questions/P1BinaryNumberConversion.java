package TakeYouforward.BitManipulation.Questions;

public class P1BinaryNumberConversion {
    public static void main(String[] args) {
        System.out.println(convertToBinary(13));
        System.out.println(convertToDecimal("1101"));
    }

    //Conversion of a Decimal number to Binary number
    public static String convertToBinary(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 1) result.append('1');
            else result.append('0');
            n = n / 2;
        }
        result.reverse();

        return result.toString();
    }

    //Conversion of a Binary number to Decimal number
    public static int convertToDecimal(String x) {
        int length = x.length();
        int pOf2 = 1, num = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (x.charAt(i) == '1') num = num + pOf2;
            pOf2 = pOf2 * 2;
        }
        return num;
    }
}
