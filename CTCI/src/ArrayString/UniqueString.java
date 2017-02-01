package ArrayString;
public class UniqueString {
	String s;
	public static void main(String[] args) {
		UniqueString u = new UniqueString("racecar");
		System.out.println(u.isUnique());
	}
	
	UniqueString(String s){
		this.s = s;
	}
	
	public boolean isUnique(){
		int time = 0;
		boolean unique = true;
		for(int i = 0; i < s.length(); i++){
			//for(int j = 0; j < s.length();  j++){
			for(int j = s.length()-1; j >= 0; j--){
				time++;
				if(s.charAt(i) == s.charAt(j) && i != j){
					System.out.println(time);
					return false;
				}
			}
		}
		System.out.println(time);
		return unique;
	}
	
	public boolean solution(){
		//ascii table
		boolean weHaveIt[] = new boolean[128];
		for(int i = 0; i < s.length(); i++){
			int var = s.charAt(i);
			if(weHaveIt[var]){
				return true;
			}
		}
		return false;
	}

}
