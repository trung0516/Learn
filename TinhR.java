package LearnCode;
import java.util.Scanner;

public class TinhR {
    public static double TongR(int n) {
        if (n == 0) {
            return 0;  
        } else if (n == 1) {
            return Math.sqrt(1);  
        } else {
            return Math.sqrt(n + TongR(n - 1));  
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Nhập giá trị n (n >= 0): ");
            n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Giá trị n phải lớn hơn hoặc bằng 0. Vui lòng nhập lại.");
            }
        } while (n < 0);

        double result = TongR(n);
        System.out.println("Giá trị của R(" + n + ") là: " + result);
    }
}