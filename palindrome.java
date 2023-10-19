import java.util.Scanner;
public class Palindrome {
	public static void main(String [] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the string");
		String word = sc.next();
		boolean ifPalindrome= checking(word);
		if (ifPalindrome) {
			System.out.println("the given word is a palindrome");
		}
		else {
			System.out.println("the given word is NOT a palindrome");
		}
		}
	static boolean checking(String word) {
		char []stringArray= word.toCharArray();
		int stringLength = word.length();
		for (int i=0; i<stringLength;i++) {
			if (stringArray[i]!=stringArray[stringLength-i-1]) {
				return false;
			}
		}
		return true;
	}

}

