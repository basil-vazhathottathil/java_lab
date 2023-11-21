package basil_vazhathottathil;
import java.util.Scanner;
public class TryCatchDemo {
	public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		char Choice='Y';
		while (Choice=='Y') {
			System.out.println("Program to perform Division");
			System.out.println("Enter the Number-1");
			int num1= sc.nextInt();
			System.out.println("Enter the Number-2");
			int num2= sc.nextInt();
			try {
				System.out.println("result"+ num1/num2);
			}
			catch(ArithmeticException e){
				System.out.println("/ by zero");
			}
			finally {
				System.out.println("End of Operation");
				System.out.println("Do you want to continue Y or N");
				Choice=sc.next().charAt(0);
			}
		}	
	}
}
