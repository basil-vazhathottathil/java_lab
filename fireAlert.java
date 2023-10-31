import java.util.Scanner;
public class fireAlert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("is fire detected?\n"+"Enter Y or n: ");
        char response = scan.next().charAt(0);
        if(response =='Y'){
            System.out.print("\n\n\n");
            System.out.println("enter grid no: ");
            int gridno=scan.nextInt();
            Detector d=new Detector();
            SmokeDetector sd=new SmokeDetector();
            d.alarm();
            sd.detect();
            d.sendLocation(gridno);
            EmergencyProtocol ep=new EmergencyProtocol();
            ep.emergencyBroadcast();
            ep.lockElevators();
            ep.callFireDepartment();         
        }
        else{
            System.out.print("\n\n\n");
            System.out.println("all green");
        }
    }
}

 class Detector{
    public void alarm(){
        System.out.println("ALERT!");
    }
    public void sendLocation(int gridno){
        System.out.println("fire at grid no :"+ gridno);
    }
}

class SmokeDetector extends Detector{
    public void detect(){
        System.out.println("Smoke detected");
    }
}

class EmergencyProtocol{
    public void emergencyBroadcast(){
        System.out.print("\n\n\n\nMove to emergency exits in a calm and orderly manner\n"+
        "Do not use elevators\n"+"Do not panic\n"+"women and children first\n"+"\n\n\n");
    }
    public void lockElevators(){
        System.out.println("Elevators locked");
    }
    public void callFireDepartment(){
        System.out.println("Fire Department called");
    }
}