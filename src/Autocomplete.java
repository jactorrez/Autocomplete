import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Autocomplete {
	
	private Term[] terms;
	
	// Initialize the data structure form the given array of terms: O(NlogN)
	public Autocomplete(Term[] terms){
		if(terms == null)
			throw new NullPointerException();
		
		Arrays.sort(terms);
		
		this.terms = terms; 
	}
	
	// Return all terms that start with the given prefix, in descending order of weight: O(logN + MlogM)
	public Term[] allMatches(String prefix){
		
		if(prefix == null)
			throw new NullPointerException();
		
		Term[] foundTerms;
		
		Term prefixTerm = new Term(prefix, 0.0);

		int prefixLength = prefix.length();

		int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefixLength));

		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefixLength));
		
		if(firstIndex != -1){
			foundTerms = new Term[(lastIndex - firstIndex) + 1];
			
			for(int i = firstIndex, j = 0; i <= lastIndex; i++){
				foundTerms[j++] = terms[i];
			}
			
			Arrays.sort(foundTerms, Term.byReverseWeightOrder());
			return foundTerms;
		}
		
		foundTerms = new Term[0];
		
		return foundTerms;
	}
	
	// Return the number of terms that start with the given prefix
	public int numberOfMatches(String prefix){
		if(prefix == null)
			throw new NullPointerException();
		
		Term prefixTerm = new Term(prefix, 0.0);
		int prefixLength = prefix.length();
		
		int firstIndex = BinarySearchDeluxe.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefixLength));
		int lastIndex = BinarySearchDeluxe.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefixLength));
		
		int amount = (lastIndex - firstIndex) + 1;
		
		return amount;
	}
	
	// Unit testing
	public static void main(String[] args){
		
		Scanner userIn = new Scanner(System.in);
	    System.out.println("Enter the file you want to use:");
		String filename = userIn.next();
		
	    System.out.println("How many matching terms to print?");
	    int k = userIn.nextInt();
	
		Term[] terms = new Term[0];
		
		try (FileReader userFile = new FileReader(filename);
			Scanner file = new Scanner(new BufferedReader(userFile))){
			int itemsInFile = file.nextInt();
			terms = new Term[itemsInFile];
			
			for(int i = 0; i < itemsInFile; i++){
				double weight = (Long.valueOf(file.nextLong())).doubleValue();
				String query = file.nextLine().trim();
				
				Term newTerm = new Term(query, weight);
				terms[i] = newTerm;
			}
		} catch (FileNotFoundException e1){
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		if(terms.length > 0){
			Autocomplete autocomp = new Autocomplete(terms);
			
			System.out.println("Search for a prefix:");
			while(userIn.hasNext()){
				String prefix = userIn.next();
				Term[] found = autocomp.allMatches(prefix);
				
				if(found.length >= k){
					for(int j = 0; j < k; j++){
						System.out.println(found[j]);
					}
				} else {
					for(Term t : found){
						System.out.println(t);
					}
				}
				System.out.println();
				System.out.println("Search for a prefix:");
			}
		}

		userIn.close();
	}

}
