package ArrayString;
import java.util.Arrays;

class CheckPerm {

	public static void main(String[] args) {
		CheckPerm cp = new CheckPerm();
		System.out.println(cp.check("cat","taco"));
	}
	
	boolean check(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		else {
			return sort(s1).equals(sort(s2));
		}
	}
	
	String sort(String s){
		char[] letters = s.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
}
