import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("give a random numeber between 1 and 10 inclusive");
        String answer = Integer.toString((int)(Math.random()*10 + 1));

        String message = sc.nextLine() ;
        while (!message.equals("end") && !message.equals(answer)){
            System.out.println("Wrong answer");
            System.out.println("give a random numeber between 1 and 10 inclusive");
            message = sc.nextLine() ;
        }
        sc.close();
        if (message != "end"){System.out.println("correct the answer was " + answer);return;}
        System.out.println("you have given up");
        return;
    }
}
