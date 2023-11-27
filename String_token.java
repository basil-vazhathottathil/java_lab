import java.util.Scanner;
import java.util.StringTokenizer;

public class String_Tokenizer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers");
        String numbers = sc.nextLine();

        StringTokenizer st = new StringTokenizer(numbers);
        int integers, sum = 0;

        System.out.println("The integers are:");
        while (st.hasMoreElements()) {
            integers = Integer.parseInt(st.nextToken());
            System.out.print(integers + "  ");
            sum += integers;
        }
        System.out.println("\nThe sum is " + sum);
    }
}
