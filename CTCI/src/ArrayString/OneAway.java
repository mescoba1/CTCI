package ArrayString;

public class OneAway {

	public static void main(String[] args) {
		// given two string determine if they are one edit away from being the
		// same
		// edit letter, delete letter, or insert letter
		OneAway o = new OneAway();
		System.out.println(o.oneAway("pale", "bale"));
	}

	public boolean oneAway(String s1, String s2) {
		// already same
		if (s1.equals(s2))
			return true;

		// delete one letter from s1
		for (int i = 0; i < s1.length(); i++) {
			String temp = s1.substring(0, i) + s1.substring(i + 1);
			if (temp.equals(s2))
				return true;
		}
		// delete one letter from s2
		for (int i = 0; i < s2.length(); i++) {
			String temp = s2.substring(0, i) + s2.substring(i + 1);
			if (temp.equals(s1))
				return true;
		}
		// delete one letter from s1 and s2
		for (int i = 0; i < s1.length(); i++) {
			String oneRemovedString1 = s1.substring(0, i) + s1.substring(i + 1);
			for (int j = 0; j < s2.length(); j++) {
				String oneRemovedString2 = s2.substring(0,j) + s2.substring(j+1);
				if(oneRemovedString1.equals(oneRemovedString2))
					return true;
			}
		}
		
		return false;
	}
}
