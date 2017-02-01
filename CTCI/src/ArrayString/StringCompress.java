package ArrayString;

public class StringCompress {

	public static void main(String[] args) {
		StringCompress s = new StringCompress();
		System.out.println("final: " + s.compress("aabccccaaa"));
	}

	public String compress(String s){
		s.toLowerCase();
		int count = 1;
		String compressed = "";
		for(int i = 0; i < s.length()-1; i++){
			System.out.println(compressed);
			if(s.charAt(i) == s.charAt(i+1)){
				count++;
				if( (i+1) >= s.length()){
					compressed = compressed.concat(s.charAt(i) + Integer.toString(count));
				}
			} else {
				compressed = compressed.concat(s.charAt(i) + Integer.toString(count));
				count = 1;
			}
		}
		
		if(compressed.length() >= s.length()) return s;
		else return compressed;
	}
}
