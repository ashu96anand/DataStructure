package basicAlgorithms;

public class StringRevAndFibonacci {

	public static void main(String []args) {
		StringRevAndFibonacci obj = new StringRevAndFibonacci();
		String no1 = "qwerty";
		int n = 10;
		System.out.println(obj.fibno(n));
		obj.printReverse(no1);
		
	}

	public void printReverse(String inp) {
		print(inp, 0);    
	}

	private void print(String inp, int idx) {
		if (idx == inp.length()) {
			return;
		}
		print(inp, idx+1);
		System.out.print(inp.charAt(idx) + " ");
	}


	/*
        Fibonnaci numbers
        0 1 1 2 3 5 8 13 ...
	 */
	/*
           n=3
           i=0, a=1, b=1
           i=1, a=1, b=2
           i=2, a=2, b=3
	 */

	public int fibonnaci(int n) {
		if(n == 0){
			return 0;
		}
		int a = 0, b = 1;
		for(int i=0; i<n; i++){
			int temp = a+b;
			a = b;
			b = temp;
		}
		return a;
	}

	/*
        Recursive approach

          4
        3    2
       2 1  1  0
      1 0  
	 */
	public int fibno(int n) {
		if (n <= 1) {
			return n;
		}
		return fibno(n-1) + fibno(n-2);
	}

}
