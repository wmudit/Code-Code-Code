package String;

public class PermutationInString {

	public static boolean checkInclusion(String s1, String s2) {
		int l1 = s1.length(), l2 = s2.length();
		int[] map1 = new int[26];
		int[] map2 = new int[26];
		for(int i = 0; i < l1; i++) {
			map1[s1.charAt(i) - 'a']++;
			map2[s2.charAt(i) - 'a']++;
		}
		for(int i = 0; i < l2 - l1; i++) {
			if(isMatch(map1, map2))
				return true;
			map2[s2.charAt(l1 + i) - 'a']++;
			map2[s2.charAt(i) - 'a']--;
		}
		return isMatch(map1, map2);
	}
	
	public static boolean isMatch(int[] a1, int[] a2) {
		for(int i = 0; i < 26; i++) {
			if(a1[i] != a2[i])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbqaooo"));
	}
}
