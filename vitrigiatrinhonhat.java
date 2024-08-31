package LearnCode;
import java.util.Scanner;

public class vitrigiatrinhonhat {
    public static void main(String[] args) {
        double[] array = inputArray();
        int minIndex = findMinIndex(array);
        outputResult(minIndex, array[minIndex]);
    }

    public static double[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        double[] array = new double[n];
        System.out.println("Nhập các phần tử của mảng:");

        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i) + ": ");
            array[i] = scanner.nextDouble();
        }
        return array;
    }

    public static int findMinIndex(double[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void outputResult(int index, double minValue) {
        System.out.println("Vị trí của giá trị nhỏ nhất là: " + index);
    }
}