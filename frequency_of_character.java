 Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class Frequency {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int count=0;
        System.out.println("enter the string");
        String string= sc.nextLine();
        char []stringArray= string.toCharArray();
        System.out.println("enter the character to be searched");
        char search = sc.next().charAt(0);
        for (int i=0; i<string.length();i++){
            if (stringArray[i]==search){
                count++;}
            }
        if(count==0){
            System.out.println(search +" isn't present in the string");}
        else{
            System.out.println(search + "is present "+count +"times");}
        }
    }
