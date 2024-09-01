
package LearnCode;
import java.util.Scanner;

public class xMuN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị của x và n từ bàn phím
        System.out.print("Nhập giá trị của x: ");
        int x = scanner.nextInt();
        System.out.print("Nhập giá trị của n: ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện n >= 1
        if (n < 1) {
            System.out.println("Giá trị của n phải lớn hơn hoặc bằng 1.");
        } else {
            double result = Tongx(x, n);
            System.out.println("S(" + x + ", " + n + ") = " + result);
        }

        scanner.close(); 
    }

    public static double Tongx(int x, int n) {
        if (n == 1) {
            return x; 
        } else {
            return Tongx(x, n - 1) + Math.pow(x, n);
        }
    }
}
