import java.util.Comparator;

public class BinarySearchDeluxe {
	
	// Return the index of the first key in a[] that equals the search key, or -1 if no such key
	public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator){
		if(a == null || key == null || comparator == null)
			throw new NullPointerException();	
		
		if(a.length == 0){
			return -1;
		}
		
		int lo = 0;
		int hi = a.length;
		
		while(lo < hi){
			int mid = (lo + (hi - 1)) / 2;
			
			if(comparator.compare(key, a[mid]) <= 0){
				hi = mid;
			} else{
				lo = mid + 1;
			}
		}
		return lo;
	}
	
	// Return the index of the last key in a[] that equals the search key, or -1 if no such key
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
		System.out.println("Running...");
		if(a == null || key == null || comparator == null)
			throw new NullPointerException();	
		
		if(a.length == 0){
			return -1;
		}
		
		int lo = -1;
		int hi = a.length - 1;
		
		while(lo < hi){
			int mid = ((lo + 1) + hi) / 2;
			
			if(comparator.compare(key, a[mid]) >= 0){
				lo = mid;
			} else{
				hi = mid - 1;
			}
		}
		
		return hi;
	}
	
	// unit test
	public static void main(String[] args){
		Integer[] arr = {0,3,4,4,4,4,4,4,4,4,4,5};
      	BinarySearchDeluxe.lastIndexOf(arr, new Integer(3), new NaturalComparator<Integer>());	
	}
}
