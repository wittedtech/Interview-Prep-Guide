package String;
/*
 * My Mistake was calling a function unneccessary and assigning boolean variable which i was using to track 
 * alternate reversing order of words. 
 * after checking it thoroughly i commented the unnecessary calling of function and the code works.
 * also added diiferent approach for better optimisation in a different file named as "ReverseStringPingPong".

 */
public class ReverseStringPingPongBruteForce {
    public static void main(String[] args) {
        String sentence = "The Quick Brown Fox Jump over the Cat";
        String reversed = reverseAlternately(sentence);
        System.out.println(reversed);
    }

    public static String reverseAlternately(String sentence) {
        char[] words = sentence.toCharArray();
        //reverseEveryWord(words, 0, words.length - 1);

        int n = words.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (words[i] == ' ') {
                reverseEveryWord(words, start, i - 1);
                start = i + 1; //skipping the space from character array by increasing start with +1.
            }
        }
        reverseEveryWord(words, start, n - 1);

        String[] wordArray = new String(words).split(" ");

        int left = 0;
        int right = wordArray.length - 1;
        StringBuilder result = new StringBuilder();

        boolean takeFromLeft = false;
        while (left <= right) {
            if (takeFromLeft) {
                result.append(wordArray[left]).append(" ");
                left++;
            } else {
                result.append(wordArray[right]).append(" ");
                right--;
            }
            takeFromLeft = !takeFromLeft;
        }

        return result.toString().trim();
    }

    public static void reverseEveryWord(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
