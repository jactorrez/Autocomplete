import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Term implements Comparable<Term>{
	public String query;
	public double weight;
	
	// Initialize a term with the given query string and weight 
	public Term(String query, double weight){
		if(query == null)
			throw new NullPointerException(); 
		
		if(weight < 0)
			throw new IllegalArgumentException();
		
		this.query = query;
		this.weight = weight;
	}
	
	// Compare the terms in descending order by weight
	public static Comparator<Term> byReverseWeightOrder(){
		return new ReverseWeightComparator<Term>();
	}
	
	// Compare the terms in lexicographic order but using only the first r characters of each query
	public static Comparator<Term> byPrefixOrder(int r){
		if(r < 0)
			throw new IllegalArgumentException();
		
		return new PrefixOrderComparator(r);
	}
	
	// Compare the terms in lexicographic order by query
	public int compareTo(Term that){
		return this.query.compareTo(that.query);
	}
	
	// Return a string representation of the term in the following format:
	// the weight, followed by a tab, followed by the query
	public String toString(){
		return (this.query);
	}
	
	// Unit testing
	public static void main(String[] args){
		ArrayList<Term> terms = new ArrayList<Term>();
		terms.add(new Term("a", 1.0));
		terms.add(new Term("b", 2.0));
		terms.add(new Term("c", 3.0));
		terms.add(new Term("d", 4.0));
		terms.add(new Term("e", 5.0));
		
		Collections.sort(terms);
		System.out.println("Sorting...");
		
		for(Term i : terms){
			System.out.println(i.toString());
		}
	}
}
