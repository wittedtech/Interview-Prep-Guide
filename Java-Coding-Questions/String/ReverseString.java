package String;

class ReverseString{
    public static void main(String[] args) {
        String sentence = "The Quick Brown Fox Jump over the Cat";
        String reversed = reverseWords(sentence);
        System.out.println(reversed);
    }

    public static String reverseWords(String sentenceString) {
        String [] words = sentenceString.split(" ");
        StringBuilder reversedSentenceString = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            String reversedWord = reverseEveryWord(words[i]);
            reversedSentenceString.append(reversedWord +" ");
        }
        return reversedSentenceString.toString().trim();
    }
    public static String reverseEveryWord(String words){
        char [] charArray = words.toCharArray();
        int left = 0;
        int right = charArray.length-1;
        while( left < right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;  
            right--;
        }
        return new String(charArray);
    }
} 