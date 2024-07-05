package object;
import java.util.Scanner;

// Assertions are meant for testing/debugging and should never be used in production code.
public class Assertions {

    public static int[] swapInts(int[] ints) {
        return new int[]{ints[1], ints[0]};
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ints = new int[2];
        ints[0] = Integer.parseInt(scanner.nextLine());
        ints[1] = Integer.parseInt(scanner.nextLine());
        int swapNum = 0;
        swapNum = ints[0];
        ints[0] = ints[1];
        ints[1] = swapNum;
        
        

        Assertions.swapInts(ints);

        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}