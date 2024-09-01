package LearnCode;

import java.util.Scanner;

public class tongn_n1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị của n từ bàn phím
        System.out.print("Nhập giá trị của n: ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện n >= 1
        if (n < 1) {
            System.out.println("Giá trị của n phải lớn hơn hoặc bằng 1.");
        } else {
            // Tính tổng S(n)
            double result = tongn(n);
            System.out.println("S(" + n + ") = " + result);
        }

        scanner.close(); 
    }

    public static double tongn(int n) {
        if (n == 1) {
            return 1.0 / (1 * 2); 
        } else {
            return tongn(n - 1) + 1.0 / (n * (n + 1));
        }
    }
}