import java.util.Comparator;

public class ReverseWeightComparator<T> implements Comparator<Term>{
	
	@Override
	public int compare(Term obj1, Term obj2){
		double firstWeight = (-1 * obj1.weight);
		double secondWeight = (-1 * obj2.weight);
		
		if(firstWeight < secondWeight){
			return -1;
		} else if(firstWeight > secondWeight){
			return 1;
		} else {
			return 0;
		}
	}
}
