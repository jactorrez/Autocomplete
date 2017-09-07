import java.util.Arrays;
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
	
	// Unit test
	public static void main(String[] args){
		Term[] arr = new Term[5];
		arr[0] = new Term("company", 1.0);
		arr[1] = new Term("complete", 1.0);
		arr[2] = new Term("companion", 1.0);
		arr[3] = new Term("completely", 1.0);
		arr[4] = new Term("comply", 1.0);
		
		Arrays.sort(arr);
		for(Term t : arr){
			System.out.println(t.query);
		}
		
		Term key = new Term("compa", 1.0);
		int keyLen = key.query.length();
		
     	int index = BinarySearchDeluxe.lastIndexOf(arr, key, new PrefixOrderComparator(keyLen));	
     	System.out.println(index);
	}
}
