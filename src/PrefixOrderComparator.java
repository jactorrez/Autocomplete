import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class PrefixOrderComparator implements Comparator<Term>{
	
	private int numChars;
	
	public PrefixOrderComparator(int r){
		numChars = r;
	}
	
	@Override
	public int compare(Term obj1, Term  obj2) {

		String Q1 = obj1.query;
		String Q2 = obj2.query;
		int Q1Length = Q1.length() - 1;
		int Q2Length = Q2.length() - 1;
		int returnVal = 0;
		int lengthAdj;;
		
		for(int i = 0; i < numChars; i++){
			lengthAdj = i + 1;
			
			if(lengthAdj > Q1Length){
				returnVal = -1;
				break;
			} else if(lengthAdj > Q2Length){
				returnVal = 1; 
				break;
			}
			
			char Q1Char = Q1.charAt(i);
			char Q2Char = Q2.charAt(i);
			
			if(Q1Char == Q2Char){
				if(i == numChars - 1){
					returnVal = 0;
					break;
				}
				continue;
			} else if(Q1Char < Q2Char){
				returnVal = -1;;
				break;
			} else if(Q1Char > Q2Char){
				returnVal = 1;
			}
		}	
		
		return returnVal;	
	}
	
	// Unit testing
	public static void main(String[] args){
		ArrayList<Term> terms = new ArrayList<>();
		terms.add(new Term("abcdefg", 1.0));
		terms.add(new Term("abc", 1.0));
		terms.add(new Term("abcde", 1.0));
		terms.add(new Term("ab", 1.0));
		terms.add(new Term("abcdef", 1.0));
		terms.add(new Term("abcd", 1.0));
		terms.add(new Term("a", 1.0));
		
		Collections.sort(terms, new PrefixOrderComparator(3));

		for(Term t : terms){
			System.out.println(t.query);
		}
		
	}
}
