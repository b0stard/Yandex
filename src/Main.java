import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        long n = scanner.nextLong();

        long number = 1;
        long count = 0;

        long[] multiples = new long[3];
        multiples[0] = a;
        multiples[1] = b;
        multiples[2] = c;

        Arrays.sort(multiples);


        while (count < n && number <= 1000000000000000000L) {

            if (checkDivisibility(number, multiples)) {
                count++;
            }
            number++;
        }

        if (count == n) {
            System.out.println(number - 1);
        } else {
            System.out.println(-1);
        }
    }


    private static boolean checkDivisibility(long number, long[] multiples) {

        int firstIndex = Arrays.binarySearch(multiples, number);
        if (firstIndex < 0) {
            firstIndex = -firstIndex - 1;
        }


        if (firstIndex < 3 && multiples[firstIndex] == number) {
            return (firstIndex + 1 < 3) || (firstIndex + 2 < 3);
        }
        return false;
    }
}