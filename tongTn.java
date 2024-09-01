package LearnCode;
import java.util.Scanner;

public class tongTn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị n từ người dùng
        System.out.print("Nhập giá trị của n: ");
        int n = scanner.nextInt();

        // Tính tổng T(n) bằng đệ quy
        double result = TongT(n);

        // In kết quả
        System.out.println("T(" + n + ") = " + result);

        // Đóng Scanner
        scanner.close();
    }

    public static double TongT(int n) {
        if (n == 1) {
            return 1.0 / 2;
        }
        return TongT(n - 1) + (double) n / (n + 1);
    }
}
