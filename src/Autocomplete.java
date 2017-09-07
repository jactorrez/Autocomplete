import java.util.Arrays;
import java.util.Collections;

public class Autocomplete {
	
	private Term[] terms;
	
	// Initialize the data structure form the given array of terms: O(NlogN)
	public Autocomplete(Term[] terms){
		if(terms == null)
			throw new NullPointerException();
		
		Arrays.sort(terms);
		
		this.terms = terms; 
	}
	
	// Return all terms that start with the given prefix, in descending order of weight
	public Term[] allMatches(String prefix){
		if(prefix == null)
			throw new NullPointerException();
		
		
	}
	
	// Return the number of terms that start with the given prefix
	public int numberOfMatches(String prefix){
		if(prefix == null)
			throw new NullPointerException();
	}
	
	// Unit testing
	public static void main(String[] args){
		
	}

}
