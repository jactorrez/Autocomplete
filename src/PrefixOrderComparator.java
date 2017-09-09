import java.util.Comparator;

public class PrefixOrderComparator implements Comparator<Term>{
	
	private int numChars;
	
	public PrefixOrderComparator(int r){
		numChars = r;
	}
	
	@Override
	public int compare(Term obj1, Term  obj2) {

		String Q1 = obj1.query;
		String Q2 = obj2.query;
		int Q1Length = Q1.length();
		int Q2Length = Q2.length();
		int returnVal = 0;
		int lengthAdj;
		
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
				returnVal = -1;
				break;
			} else if(Q1Char > Q2Char){
				returnVal = 1;
				break;
			}
		}	
		
		return returnVal;	
	}
	
	// Unit testing
	public static void main(String[] args){
		Term[] arr = new Term[5];
		arr[0] = new Term("company", 1.0);
		arr[1] = new Term("complete", 1.0);
		arr[2] = new Term("companion", 1.0);
		arr[3] = new Term("completely", 1.0);
		arr[4] = new Term("comply", 1.0);

		Term key = new Term("poop", 1.0);
		int keyLen = key.query.length();
		
     	Comparator<Term> comp = new PrefixOrderComparator(keyLen);
     	
     	System.out.println(comp.compare(key, arr[2]));
	
		
	}
}
