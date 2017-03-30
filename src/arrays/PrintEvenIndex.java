package arrays;

import java.util.Scanner;

public class PrintEvenIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of elements in the array: ");
		int n = sc.nextInt();
		int[] inp = new int[n];
		System.out.println("Enter the elements of the array: ");
		for(int i=0; i<n; i++){
			inp[i] = sc.nextInt();
		}
		sc.close();
		PrintEvenIndex obj = new PrintEvenIndex();
		obj.printEvenIndex(inp);
	}
	
	public void printEvenIndex(int[] inp){
		for(int i=0; i<inp.length; i++){
			if(i%2 == 0){
				continue;
			}
			System.out.println(inp[i]);
		}
	}

}