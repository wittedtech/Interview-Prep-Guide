package String;
import java.util.ArrayList;
import java.util.List;

class ReverseStringPingPong {
    public static void main(String[] args) {
        String sentence = "The Quick Brown Fox Jump over the Cat";
        String reversed = reverseAlternately(sentence);
        System.out.println(reversed);
    }

    public static String reverseAlternately(String sentence) {
        String[] words = sentence.split(" ");
        List<String> reversedWords = new ArrayList<>();
        for (String word : words) {
            reversedWords.add(new StringBuilder(word).reverse().toString());
        }
        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = reversedWords.size() - 1;
        boolean takeFromLeft = false;

        while (left <= right) {
            if (takeFromLeft) {
                result.append(reversedWords.get(left)).append(" ");
                left++;
            } else {
                result.append(reversedWords.get(right)).append(" ");
                right--;
            }
            takeFromLeft = !takeFromLeft;
        }

        return result.toString().trim();
    }
}