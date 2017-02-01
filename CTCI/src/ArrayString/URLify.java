package ArrayString;

public class URLify {

	public static void main(String[] args) {
		URLify test = new URLify();
		System.out.println(test.url("Mr. John Smith"));
		//input Mr. John Smith
		//output Mr.%20John%20Smith
	}
	
	public String url(String s){
		char[] letters = s.toCharArray();
		int spaces = 0;
		for(int i = letters.length-1; i >= 0; i--){
			if(letters[i] == ' '){
				spaces++;
			}
		}
		char[] newArr = new char[letters.length + 2*spaces];
		int index = 0;
		for(int i = 0; i < letters.length; i++){
			if(letters[i] == ' '){
				newArr[index] = '%';
				newArr[index+1] = '2';
				newArr[index+2] = '0';
				index+=3;
			} else {
				newArr[index] = letters[i];
				index++;
			}
		}
		return new String(newArr);
	}

}
