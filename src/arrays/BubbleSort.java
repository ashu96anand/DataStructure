package arrays;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		int[] inp = {5,4,3,2,1};
		obj.bubbleSort(inp);
		System.out.println(Arrays.toString(inp));


	}
	// 5 4 3 2 1
	public void bubbleSort(int[] arr){
        for(int i = 0; i<arr.length; i++){
            for (int j = 1; j < arr.length-i; j++){
                if (arr[j-1] > arr[j])
                {
                    
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            
        }
        
    }
}
