import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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
		
		if((lo == a.length) || (comparator.compare(key, a[lo]) != 0)){
			return -1;
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
		try(Scanner scan = new Scanner(new BufferedReader(new FileReader("cities.txt")))) {
			int size = scan.nextInt();
			Term[] terms = new Term[size];
			
			for(int i = 0; i < size; i++){
				double weight = (Long.valueOf(scan.nextLong())).doubleValue();
				String query = scan.nextLine().trim();
				terms[i] = new Term(query, weight);
			}
			
			Arrays.sort(terms);

			Term key = new Term("W", 0.0);
			int keyLen = key.query.length();
			
	     	int index = BinarySearchDeluxe.firstIndexOf(terms, key, new PrefixOrderComparator(keyLen));	
	     	System.out.println(index);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
