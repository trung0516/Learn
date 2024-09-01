package LearnCode;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class arrandsort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Kích thước của mảng A và B
        int sizeA = nhapKichThuocMang(scanner, "A");
        int sizeB = nhapKichThuocMang(scanner, "B");

        // Tạo mảng A và B với giá trị ngẫu nhiên
        int[] A = taoMang(scanner, sizeA, "A");
        int[] B = taoMang(scanner, sizeB, "B");

        // Sắp xếp mảng A và B tăng dần
        sapXepMangTangDan(A);
        sapXepMangTangDan(B);

        // Trộn mảng A và B theo thứ tự giảm dần
        int[] C = tronMangGiamDan(A, B);

        // In mảng kết quả
        inMang("Mảng kết quả sau khi trộn và sắp xếp giảm dần", C);
    }

    public static int nhapKichThuocMang(Scanner scanner, String tenMang) {
        System.out.print("Nhập số lượng phần tử của mảng " + tenMang + ": ");
        return scanner.nextInt();
    }

    public static int[] taoMang(Scanner scanner, int size, String tenMang) {
        Random random = new Random();
        int[] array = new int[size];

        System.out.println("Nhập giá trị cho mảng " + tenMang + " (nhập -1 để phát sinh ngẫu nhiên): ");
        for (int i = 0; i < size; i++) {
            int input = scanner.nextInt();
            if (input == -1) {
                array[i] = random.nextInt(100); 
            } else {
                array[i] = input;
            }
        }
        return array;
    }

    // Hàm sắp xếp mảng tăng dần
    public static void sapXepMangTangDan(int[] array) {
        Arrays.sort(array);
    }

    public static int[] tronMangGiamDan(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = A.length - 1; 
        int j = B.length - 1; 
        int k = 0; 

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                C[k++] = A[i--];
            } else {
                C[k++] = B[j--];
            }
        }

        while (i >= 0) {
            C[k++] = A[i--];
        }

        while (j >= 0) {
            C[k++] = B[j--];
        }

        return C;
    }

    public static void inMang(String message, int[] array) {
        System.out.println(message + ": " + Arrays.toString(array));
    }
}