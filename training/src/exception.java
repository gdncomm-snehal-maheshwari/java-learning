import java.util.Scanner;

public class exception {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter a number --> ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n/10 > 0) {
            throw new Exception("Input should be single digit");
        }

        System.out.println("Single digit detected. Wohoo!!");
    }
}
