package arrays;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of elements in the array: ");
		int n = sc.nextInt();
		int[] inp = new int[n];
		System.out.println("Enter the elements of the array: ");
		for(int i=0; i<n; i++){
			inp[i] = sc.nextInt();
		}
		System.out.println("Enter the no. to be searched: ");
		int no = sc.nextInt();
		sc.close();
		LinearSearch obj = new LinearSearch();
		int resIdx = obj.linearSearch(inp, no);
		System.out.println("Result index = " + resIdx);
		
	}
	
	 public int linearSearch(int[] inp, int no) {
	        for(int i=0; i<inp.length; i++) {
	            if(inp[i]==no){
	                return i;
	            }
	        }
	        return -1;
	    }
	    

}
