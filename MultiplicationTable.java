package basil_vazhathottathil;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Calc calculator= new Calc();
        int num1,num2,num3;
        System.out.println("enter the table you want to run thread1");
        num1=sc.nextInt();
        System.out.println("enter the table you want to run thread2");
        num2=sc.nextInt();
        System.out.println("enter the table you want to run thread3");
        num3=sc.nextInt();

        Thread1 first =new Thread1(calculator, num1);
        Thread2 second =new Thread2(calculator, num2);
        Thread3 third=new Thread3(calculator, num3);

        first.start();
        second.start();
        third.start();
    }
}


class Calc{
    public synchronized void multiplier(int x) {
        for (int i = 1; i < 11; i++) {
            System.out.println(x + "*" + i + "=" + x * i);
        }
    }
}

class Thread1 extends Thread {
    Calc calculator;
    int num1;

    public Thread1(Calc calculator, int num1) {
        this.calculator = calculator;
        this.num1 = num1;
    }

    public void run() {
        try {
            calculator.multiplier(num1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {
    Calc calculator;
    int num2;

    public Thread2(Calc calculator, int num2) {
        this.calculator = calculator;
        this.num2 = num2;
    }

    public void run() {
        try {
            calculator.multiplier(num2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread3 extends Thread {
    Calc calculator;
    int num3;

    public Thread3(Calc calculator, int num3) {
        this.calculator = calculator;
        this.num3 = num3;
    }

    public void run() {
        try {
            calculator.multiplier(num3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
