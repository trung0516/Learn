package LearnCode;
import java.util.Scanner;

public class giatriganx {
    public static void main(String[] args) {
        double[] array = inputArray();
        double x = inputX();
        double closestValue = findClosestValue(array, x);
        outputResult(closestValue, x);
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

    public static double inputX() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị x: ");
        return scanner.nextDouble();
    }

    public static double findClosestValue(double[] array, double x) {
        double closestValue = array[0];
        double minDifference = Math.abs(array[0] - x);

        for (int i = 1; i < array.length; i++) {
            double difference = Math.abs(array[i] - x);
            if (difference < minDifference) {
                minDifference = difference;
                closestValue = array[i];
            }
        }
        return closestValue;
    }

    public static void outputResult(double closestValue, double x) {
        System.out.println("Giá trị trong mảng gần với " + x + " nhất là: " + closestValue);
    }
}