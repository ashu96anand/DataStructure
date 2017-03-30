package basicAlgorithms;

public class SquareRoot {

	public static void main(String[] args) {
		int no = Integer.MAX_VALUE;
		SquareRoot obj = new SquareRoot();
		long start = System.nanoTime();
		System.out.println(obj.squareRoot(no));
		long stop = System.nanoTime();
		System.out.println("Time taken by sqroot = " + (stop - start));
		start = System.nanoTime();
		System.out.println(obj.squareRootBetter(no));
		stop = System.nanoTime();
		System.out.println("Time taken by sqrootbetter = " + (stop - start));
	}
	
	public int squareRoot(int no) {
        if(no < 0){
            return -1;
        }
        long sqRoot = 0;
        for(long i=0; i<=no; i++){
            if(i*i <= no){
                sqRoot = i;
            } 
            else{
                break;
            }
        }
        return (int)sqRoot;
    }
    
    public int squareRootBetter(int no) {
        long left=0, right=no;
        long mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            long squareOfMid = mid * mid;
            if (squareOfMid == no) {
                break;
            } else if (squareOfMid > no) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }        
        return (int)mid;
    }

}
