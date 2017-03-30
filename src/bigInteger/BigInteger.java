package bigInteger;

public class BigInteger {

	public static void main(String[] args) {
		BigInt no1 = new BigInt(Long.MAX_VALUE);
		BigInt no2 = new BigInt(Long.MAX_VALUE);
		BigInt sum = no1.add(no2);
		BigInt product = no1.multiply(no2);
		System.out.println("Sum of the nos. is : " + sum.valueIs);
		System.out.println("Product of the nos. is : " + product.valueIs);
	}

	public static class BigInt {
		private String valueIs;

		public BigInt(int no) {
			valueIs = String.valueOf(no);

		}
		public BigInt(long no){
			valueIs = String.valueOf(no);
		}
		public BigInt(){

		}

		public BigInt add(BigInt no) {
			// add two string numbers.
			String res = sum(valueIs, no.valueIs);
			// create an object of BigInteger with result string and return it.
			BigInt sum = new BigInt();
			sum.valueIs = res;
			return sum;
		}

		/*
            no1 = "12345"
            no2 =   "125"
            sum = "12470"
            "07421"
		 */
		private String sum(String no1, String no2){
			// get no at index i from no1.
			// get no at index j from no2.
			// carry = 0.

			// in a loop
			// add no at index i from no1 and no at index j from no2 and carry.
			// reset carry.
			StringBuilder sb = new StringBuilder("");
			int l1 = no1.length();
			int l2 = no2.length();
			int carry = 0;
			/*
              String res;
            // no1 = 99, no2 = 9
            //no1 = 99, no2 = 09
            if(l1 > l2){
            	no2 = addZero(no1, no2);
            	l2 = no2.length();
            }
            else{
            	no1 = addZero(no1, no2);
            	l1 = no1.length();
            }
            for(int i=l2-1; i>=0; i--){
        		int s = (no1.charAt(i)-'0') + (no2.charAt(i)-'0') + carry;
        		carry = 0;
        		if(s > 9){
        			sb.append(s-10);
        			carry++;
        		}
        		else{
        			sb.append(s);
        		}
        	}
			 */

			int i=l1-1, j=l2-1;
			while (i >= 0 || j >= 0) {
				int no1_i = (i >= 0) ? (no1.charAt(i)-'0') : 0;
				int no2_j = (j >= 0) ? (no2.charAt(j) - '0') : 0; 
				int s = no1_i + no2_j + carry;
				carry = 0;
				if(s > 9){
					sb.append(s-10);
					carry = 1;
				}
				else{
					sb.append(s);
				}
				i--;
				j--;
			}
			if(carry == 1){
				sb.append(1);
			}
			sb = sb.reverse();
			//res = sb.toString();
			//return res;
			return sb.toString();

		}
		/*
		    private String addZero(String no1, String no2){
			StringBuilder sb = new StringBuilder();
			int l1 = no1.length();
			int l2 = no2.length();
			if(l1 > l2){
				//no. of zeroes to be added = l1-l2
				for(int i=0; i<(l1-l2); i++){
					sb.insert(i, 0);
				}
				sb.toString();
				no2 = sb + no2;
				return no2;
			}
			else{
				for(int i=0; i<(l2-l1); i++){
					sb.insert(i, 0);
				}
				sb.toString();
				no1 = sb + no1;
				return no1;
			}
		}
		*/


		public BigInt multiply(BigInt no) {
			String res = multiply(valueIs, no.valueIs);
			BigInt product = new BigInt();
			product.valueIs = res;
			return product;    
		}   

		/*
         1234
         x 23
         3702
        2468x
ans =     28382       

		 */
		private String multiply(String no1, String no2) {
			String larger, smaller;
			if (no1.length() >= no2.length()) {
				larger = no1;
				smaller = no2;
			} else {
				larger = no2;
				smaller = no1;
			}

			String res = multiply(larger, smaller.charAt(smaller.length()-1) - '0');
			for (int i=smaller.length()-2, zeros=1; i>=0; i--, zeros++) {
				String product = multiply(larger, smaller.charAt(i) - '0');
				product = addZeros(product, zeros);
				res = sum(res, product);

			}
			return res;
		}

		/*
         inp = "1234"
         no =      5;
         carry = 1
         sb = 0716
		 */
		private String multiply(String inp, int no) {
			StringBuilder sb = new StringBuilder();
			int carry = 0;
			for(int i=inp.length()-1; i>=0; i--){
				int r = (inp.charAt(i)-'0')*no + carry;                

				if(r<10){
					sb.append(r);
					carry = 0;
				}
				else{
					carry = r/10;
					sb.append(r%10);
				}               
			}

			if(carry != 0){
				sb.append(carry);
			}
			sb = sb.reverse();
			//System.out.println(sb.toString());
			return sb.toString();
		}

		private String addZeros(String inp, int zeros) {
			StringBuilder sb = new StringBuilder();
			sb.append(inp);
			for(int i=0; i<zeros; i++){
				sb.append(0);
			}
			return sb.toString();
		}

	}

}
