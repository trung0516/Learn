package LearnCode;
import java.util.Scanner;

public class demsoluongsonguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị của n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Giá trị của n phải là số nguyên dương.");
        } else {
            int digitCount = demchuso(n);
            System.out.println("Số lượng chữ số của " + n + " là: " + digitCount);
        }

        scanner.close(); 
    }

    public static int demchuso(int n) {
        if (n < 10) {
            return 1; 
        } else {
            return 1 + demchuso(n / 10);
        }
    }
}