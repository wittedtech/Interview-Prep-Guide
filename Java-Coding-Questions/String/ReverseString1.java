package String;
public class ReverseString1{
    public static void main(String [] args){
        String str = "The Quick Brown Fox Jump Over";
        String str1 = ("");

        for(int i=0 ; i<str.length(); i++){
            char ch = str.charAt(i);
            str1 = ch+str1;
        }

        System.out.println(str1);
    }
}