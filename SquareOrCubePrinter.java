package basil_vazhathottathil;

import java.util.Random;

public class SquareOrCubePrinter {
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
    private int randomGenerated;
    private boolean generatedOrNot = false;

    public synchronized void generateNumber() {
        while (generatedOrNot) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        randomGenerated = new Random().nextInt(20);
        System.out.println("Generated random is: " + randomGenerated);
        generatedOrNot = true;
        notifyAll();
    }

    public synchronized void printEven() throws InterruptedException {
        while (!generatedOrNot || randomGenerated % 2 != 0) {
            wait();
        }
        System.out.println("The square of the value: " + randomGenerated * randomGenerated);
        generatedOrNot = false;

    }

    public synchronized void printOdd() throws InterruptedException {
        while (!generatedOrNot || randomGenerated % 2 == 0) {
            wait();
        }
        System.out.println("The cube of the value: " + randomGenerated * randomGenerated * randomGenerated);
        generatedOrNot = false;
  
    }
}

class NumberGenerator extends Thread {
    private NumberManager nm;

    public NumberGenerator(NumberManager nm) {
        this.nm = nm;
    }

    public void run() {
        while (true) {
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
    private NumberManager nm;

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
    private NumberManager nm;

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
