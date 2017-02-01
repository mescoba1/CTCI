package ArrayString;

import java.util.ArrayList;

public class PalinPerm {
	public static void main(String[] args) {
		// Palindrone Permutation
		// input: Tact Coa
		// output: True(Permutations: "taco cat", "atco cta", etc.)
		String input = "Taco cat";
		input.toLowerCase();
		char[] let = input.toCharArray();
		PalinPerm p = new PalinPerm();
		boolean result = p.isPalindrone(let);
		System.out.println(result);
		//palindrone will either be 2 of each letter or 2 of each letter plus a unique letter	
	}
	public boolean isPalindrone(char[] arr){
		int[] countTable = generateCountTable(arr);
		return maxOneOdd(countTable);
	}
	
	public int[] generateCountTable(char[] arr){
		int[] table = new int[26];
		int index = -1;
		for(char c : arr){
			int a = Character.getNumericValue('a');
			int z = Character.getNumericValue('z');
			int val = Character.getNumericValue(c);
			if( val >= a && val <= z){
				index = val - a;
				table[index]++;
			}
		}
		return table;
	}
	
	public boolean maxOneOdd(int[] table){
		boolean oneOdd = false;
		for(int t : table){
			if(t % 2 == 1){
				if(oneOdd){
					return false;
				}
				oneOdd = true;
			}
		}
		return true;
	}
}
