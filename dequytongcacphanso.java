package LearnCode;
import java.util.Scanner;

public class dequytongcacphanso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị của n từ bàn phím
        System.out.print("Nhập giá trị của n: ");
        int n = scanner.nextInt();
        
        // Tính tổng S(n)
        double result = Tongcacphanso(n);
        System.out.println("S(" + n + ") = " + result);

        scanner.close(); // Đóng Scanner sau khi sử dụng
    }

    // Hàm đệ quy tính tổng các phân số
    public static double Tongcacphanso(int n) {
        if (n == 1) {
            return 1.0;
        } else {
            return Tongcacphanso(n - 1) + 1.0 / n;
        }
    }
}