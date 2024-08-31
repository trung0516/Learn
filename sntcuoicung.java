package LearnCode;
import java.util.Scanner;

public class sntcuoicung {
    public static void main(String[] args) {
        int[] array = inputArray();
        int lastPrimeIndex = findLastPrimeIndex(array);
        outputResult(lastPrimeIndex, array);
    }

    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");

        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findLastPrimeIndex(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (isPrime(array[i])) {
                return i;
            }
        }
        return -1;  
    }

    public static void outputResult(int index, int[] array) {
        if (index == -1) {
            System.out.println("Mảng không có số nguyên tố.");
        } else {
            System.out.println("Vị trí của số nguyên tố cuối cùng là: " + index);
        }
    }
}