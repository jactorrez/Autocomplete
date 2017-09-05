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
		
		if(Q1Length < Q2Length){
			return -1;
		} else if(Q1Length > Q2Length){
			return 1;
		}
		
		for(int i = 0; i < numChars; i++){
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
}
