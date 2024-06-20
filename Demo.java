import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

	
	
	public static void main(String[] args) {
		
		
		   List<List<String>> list = Arrays.asList(
				   Arrays.asList("Geeks", "GFG"), 
				   Arrays.asList("GeeksforGeeks", "gfg")); 
		   
		   list.stream().flatMap(x -> x.stream()).collect(Collectors.toList()).forEach(System.out::println);;
	}
}
