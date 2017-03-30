package arrays;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort obj = new MergeSort();
		int []inp = {5,3,4,6,1,2};
		int []result = obj.mergeSort(inp);
		System.out.println(Arrays.toString(result));
		
	}

	public int[] mergeSort(int []inp){
		if(inp.length <= 1){
			return inp;
		}
		else{
			/*
			  end = 4, mid = 2
			 */
			int []right;
			int []left = new int[inp.length/2];
			if(inp.length%2 == 0){
				right = new int[inp.length/2];
			}else{
				right = new int[inp.length/2+1];
			}
			//for left array.
			for(int i=0; i<left.length; i++){
				left[i] = inp[i];
			}
			//for right array.
			for(int i=right.length-1, j = inp.length-1; i>=0; i--, j--){
				right[i] = inp[j];
			}
			return merge(mergeSort(left), mergeSort(right));
		}
	}
	// a1 : 5
	// a2 : 4
	private int[] merge(int []a1, int[]a2){
		int result[] = new int[a1.length+a2.length];
		int c1=0, c2=0;
		for(int i=0; i<result.length; i++){
			if(c1<a1.length && c2<a2.length){
				if(a1[c1] < a2[c2]){
					result[i] = a1[c1];
					c1++;
				}
				else{
					result[i] = a2[c2];
					c2++;
				}
			}
			else if(c1<a1.length){
				result[i] = a1[c1];
				c1++;
			}
			else if(c2<a2.length){
				result[i] = a2[c2];
				c2++;
			}
		}

		return result;
	}

}
