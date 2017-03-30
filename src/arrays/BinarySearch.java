package arrays;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the no. of elements in the array");
		int n = sc.nextInt();
		int[] inp = new int[n];
		System.out.println("enter the elements of the array");
		for(int i=0; i<n; i++){
			inp[i] = sc.nextInt();
		}
		System.out.println("enter the no. to be searched");
		int no = sc.nextInt();
		sc.close();
		BinarySearch obj = new BinarySearch();
		//int resultIdx = obj.binarySearch(inp, no);
		System.out.println("Result index = "+ obj.binarySearch(inp, no));
	}
	//ex : 1 2 3 4 5 6
	public int binarySearch(int[] inp, int no){
		int midIdx, startIdx = 0, endIdx = inp.length-1;
		int resultIdx = -1;
		while(startIdx <= endIdx){
			midIdx = (startIdx + endIdx)/2;
			if(inp[midIdx] == no){
				resultIdx = midIdx;
				break;
			}
			else if(inp[midIdx] > no){
				endIdx = midIdx-1;
			}
			else{
				startIdx = midIdx+1;
			}
		}
		return resultIdx;
	}

}
