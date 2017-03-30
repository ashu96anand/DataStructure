package strings;

import java.util.Scanner;


public class Basics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first string: ");
		String str1 = sc.next();
		System.out.println("Enter second string: ");
		String str2 = sc.next();
		sc.close();
		Basics obj = new Basics();
		boolean res = obj.equals(str1, str2);
		System.out.println("Equal : " + res);
		
		Basics obj1 = new Basics();
		boolean res1 = obj1.isAnagram(str1, str2);
		System.out.println("Is Anagram : " + res1);
		
		Basics obj2 = new Basics();
		boolean res2 = obj2.hasUniqueChar(str1);
		System.out.println("Has Unique Character : " + res2);
		
	}
	
	public boolean equals(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() != str2.length()){
			return false;
		}
		for(int i=0; i<str1.length(); i++){
			if(str1.charAt(i) != str2.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	public boolean isAnagram(String str1, String str2){
		
		int[] count1 = getCount(str1);
		int[] count2 = getCount(str2);
		for(int i=0; i<count1.length; i++){
			if(count1[i] != count2[i]){
				return false;
			}
		}
		return true;
	}
	
	public boolean hasUniqueChar(String inp){
		int[] count = getCount(inp);
		for(int i=0; i<inp.length(); i++){
			if(count[i] > 1){
				return false;
			}
		}
		return true;
	}
	
	private int[] getCount(String inp){
		int[] count = new int[26];
		for(int i=0; i<inp.length(); i++){
			int j = inp.charAt(i)-'a';
			count[j]++;
		}
		return count;
	}
}
