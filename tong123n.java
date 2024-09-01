package LearnCode;
import java.util.Scanner;

public class tong123n {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị của n: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Giá trị của n phải lớn hơn hoặc bằng 1.");
        } else {
            double result = Sumn(n);
            System.out.println("S(" + n + ") = " + result);
        }

        scanner.close();
    }

    public static double Sumn(int n) {
        if (n == 1) {
            return 1.0; 
        } else {
            return Sumn(n - 1) + 1.0 / (n * (n + 1) / 2);
        }
    }
}