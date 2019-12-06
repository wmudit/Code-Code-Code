
public class ValidPalindrome {

	 public static boolean isPalindrome(String s) {
	        if (s.isEmpty()) {
	        	return true;
	        }
	        int head = 0, tail = s.length() - 1;
	        char cHead, cTail;
	        while(head <= tail) {
	        	cHead = s.charAt(head);
	        	cTail = s.charAt(tail);
	        	if (!Character.isLetterOrDigit(cHead)) {
	        		head++;
	        	} else if(!Character.isLetterOrDigit(cTail)) {
	        		tail--;
	        	} else {
	        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
	        			return false;
	        		}
	        		head++;
	        		tail--;
	        	}
	        }
	        
	        return true;
	    }
	 
	 public static void main (String[] args) {
		 long startTime = System.currentTimeMillis();
		 System.out.println(isPalindrome("hufahasufagiufhoafbadiufhaif ahf iueghiusdgh aoeifh siheiusghisghdsioghsgdiuhgdsoife uaehgo isghiose "));
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 System.out.println(totalTime);
	 }
}
