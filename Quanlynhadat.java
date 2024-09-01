package LearnCode;

import java.util.ArrayList;

// Lớp RealEstate (lớp cha)
class RealEstate {
    private String transactionId;
    private String transactionDate;
    private double unitPrice;
    private double area;

    public RealEstate(String transactionId, String transactionDate, double unitPrice, double area) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.unitPrice = unitPrice;
        this.area = area;
    }

    // Các getter và setter
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // Phương thức tính thành tiền (được override trong các lớp con)
    public double calculateTotalPrice() {
        return area * unitPrice;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Date: " + transactionDate + ", Unit Price: " + unitPrice + ", Area: " + area;
    }
}

// Lớp LandTransaction (lớp con kế thừa RealEstate)
class LandTransaction extends RealEstate {
    private String landType; // "A", "B", "C"

    public LandTransaction(String transactionId, String transactionDate, double unitPrice, double area, String landType) {
        super(transactionId, transactionDate, unitPrice, area);
        this.landType = landType;
    }

    @Override
    public double calculateTotalPrice() {
        if (landType.equalsIgnoreCase("A")) {
            return getArea() * getUnitPrice() * 1.5;
        } else {
            return getArea() * getUnitPrice();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Land Type: " + landType + ", Total Price: " + calculateTotalPrice();
    }
}

// Lớp HouseTransaction (lớp con kế thừa RealEstate)
class HouseTransaction extends RealEstate {
    private String houseType; // "Cao cấp", "Thường"
    private String address;

    public HouseTransaction(String transactionId, String transactionDate, double unitPrice, double area, String houseType, String address) {
        super(transactionId, transactionDate, unitPrice, area);
        this.houseType = houseType;
        this.address = address;
    }

    @Override
    public double calculateTotalPrice() {
        if (houseType.equalsIgnoreCase("Cao cấp")) {
            return getArea() * getUnitPrice();
        } else {
            return getArea() * getUnitPrice() * 0.9;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", House Type: " + houseType + ", Address: " + address + ", Total Price: " + calculateTotalPrice();
    }
}

// Lớp TransactionManager để quản lý danh sách giao dịch
class TransactionManager {
    private ArrayList<RealEstate> transactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(RealEstate transaction) {
        transactions.add(transaction);
    }

    public void displayAllTransactions() {
        for (RealEstate transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public int countLandTransactions() {
        int count = 0;
        for (RealEstate transaction : transactions) {
            if (transaction instanceof LandTransaction) {
                count++;
            }
        }
        return count;
    }

    public int countHouseTransactions() {
        int count = 0;
        for (RealEstate transaction : transactions) {
            if (transaction instanceof HouseTransaction) {
                count++;
            }
        }
        return count;
    }

    public double calculateAverageLandTransactionPrice() {
        double total = 0;
        int count = 0;
        for (RealEstate transaction : transactions) {
            if (transaction instanceof LandTransaction) {
                total += transaction.calculateTotalPrice();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    public void displayTransactionsInSeptember2013() {
        for (RealEstate transaction : transactions) {
            if (transaction.getTransactionDate().contains("09/2013")) {
                System.out.println(transaction);
            }
        }
    }
}

// Chương trình chính
public class Quanlynhadat {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();

        // Thêm một số giao dịch mẫu
        manager.addTransaction(new LandTransaction("GD001", "01/09/2013", 1000, 100, "A"));
        manager.addTransaction(new LandTransaction("GD002", "15/09/2013", 800, 200, "B"));
        manager.addTransaction(new HouseTransaction("GD003", "10/09/2013", 2000, 300, "Cao cấp", "123 ABC Street"));
        manager.addTransaction(new HouseTransaction("GD004", "20/09/2013", 1500, 250, "Thường", "456 DEF Street"));

        // Hiển thị tất cả giao dịch
        System.out.println("Tất cả các giao dịch:");
        manager.displayAllTransactions();

        // Đếm số lượng giao dịch đất và nhà
        System.out.println("\nSố lượng giao dịch đất: " + manager.countLandTransactions());
        System.out.println("Số lượng giao dịch nhà: " + manager.countHouseTransactions());

        // Tính trung bình thành tiền của giao dịch đất
        System.out.println("\nTrung bình thành tiền của giao dịch đất: " + manager.calculateAverageLandTransactionPrice());

        // Xuất ra các giao dịch của tháng 9 năm 2013
        System.out.println("\nGiao dịch trong tháng 9/2013:");
        manager.displayTransactionsInSeptember2013();
    }
}
