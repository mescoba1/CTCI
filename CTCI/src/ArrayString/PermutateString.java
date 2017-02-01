package ArrayString;

public class PermutateString {

	public static void main(String[] args) {
		char[] letters = {'a','a','b','c'};
		char[] space = new char[letters.length];
		int[] count = {1,1,1,1};
		PermutateString s = new PermutateString();
		s.permutate(letters, count,space,0);
	}

	public void permutate(char[] c, int[] count, char[] newC, int level){
		if(level == newC.length){
			printArr(newC);
			return;
		}
		
		for(int i = 0; i < c.length; i++){
			if(count[i] == 0){
				continue;
			}
			newC[level] = c[i];
			count[i]--;
			permutate(c, count, newC, level+1);
			count[i]++;
		}
	}
	public void printArr(char[] arr){
		for(char a : arr){
			System.out.print(a);
		}
		System.out.println();
	}
}
