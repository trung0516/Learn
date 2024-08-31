package LearnCode;
import java.util.Scanner;

public class giatriduongnhonhat {
    public static void main(String[] args) {
        double[] array = inputArray();
        int minPositiveIndex = findMinPositiveIndex(array);
        outputResult(minPositiveIndex, array);
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

    public static int findMinPositiveIndex(double[] array) {
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (minIndex == -1 || array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
        }
        return minIndex; 
    }

    public static void outputResult(int index, double[] array) {
        if (index == -1) {
            System.out.println("Mảng không có giá trị dương.");
        } else {
            System.out.println("Vị trí của giá trị dương nhỏ nhất là: " + index);
        }
    }
}