package LearnCode;
import java.util.Scanner;



public class vitrichandautien {
    public static void main(String[] args) {
        int[] array = inputArray();
        int evenIndex = findFirstEvenIndex(array);
        outputResult(evenIndex);
    }

    // Hàm để nhập mảng từ người dùng
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");

        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i ) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Hàm tìm vị trí của giá trị chẵn đầu tiên trong mảng
    public static int findFirstEvenIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {  // Kiểm tra nếu phần tử là số chẵn
                return i;
            }
        }
        return -1;  // Trả về -1 nếu không có giá trị chẵn
    }

    // Hàm xuất kết quả
    public static void outputResult(int index) {
        if (index == -1) {
            System.out.println("Mảng không có giá trị chẵn.");
        } else {
            System.out.println("Vị trí của giá trị chẵn đầu tiên là: " + index);
        }
    }
}