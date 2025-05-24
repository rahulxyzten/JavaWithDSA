package KunalKushwaha.Cp2ConditonalsLoop;

public class Reverse {

    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] characters = input.toCharArray();
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            // Swap characters at left and right indices
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            // Move the pointers towards the center
            left++;
            right--;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverse(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}

