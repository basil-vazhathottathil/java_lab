package sjc22cs040;

import java.util.Random;

public class MultithreadOddEven {
    public static void main(String[] args) {
        NumberManager numberManager = new NumberManager();
        NumberGenerator ng = new NumberGenerator(numberManager);
        EvenPrinter even = new EvenPrinter(numberManager);
        OddPrinter odd = new OddPrinter(numberManager);
        ng.start();
        even.start();
        odd.start();
    }
}

class NumberManager {
    public int randomGenerated;
    public boolean generatedOrNot = false;

    public synchronized void generateNumber() {
            randomGenerated = new Random().nextInt(99) + 2;
            System.out.println("generated random is :  " + randomGenerated);
            generatedOrNot = true;
            notifyAll();
    }

    public synchronized void printEven() throws InterruptedException {
        while (!generatedOrNot || randomGenerated % 2 != 0) {
            wait();
        }
        for (int i = 2; i < randomGenerated; i += 2) {
        	System.out.print(i + "  ");
        }
        System.out.println();
        generatedOrNot = false;
    }
    
	public synchronized void printOdd() throws InterruptedException{
		while(!generatedOrNot || randomGenerated%2==0) {
			wait();
		}
		for (int i=3 ;i < randomGenerated;i+=2) {
			System.out.print(i+"  ");
		}
		System.out.println();
		generatedOrNot=false;
	}
}

class NumberGenerator extends Thread {
    NumberManager nm;

    public NumberGenerator(NumberManager nm) {
        this.nm = nm;
    }

    public void run() {
       while(true) {
    	   nm.generateNumber();
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

class EvenPrinter extends Thread {
    NumberManager nm;

    public EvenPrinter(NumberManager nm) {
        this.nm = nm;
    }

    public void run() {
        while (true) {
            try {
                nm.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddPrinter extends Thread {
    NumberManager nm;

    public OddPrinter(NumberManager nm) {
        this.nm = nm;
    }

    public void run() {
        while (true) {
            try {
                nm.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
