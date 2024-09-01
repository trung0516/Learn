package LearnCode;

import java.util.ArrayList;

// Lớp Customer (lớp cha)
abstract class Customer {
    private String customerId;
    private String fullName;
    private String invoiceDate; // định dạng: "ngày/tháng/năm"
    private double quantity; // số KW tiêu thụ
    private double unitPrice;

    public Customer(String customerId, String fullName, String invoiceDate, double quantity, double unitPrice) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Các getter và setter
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    // Phương thức tính thành tiền (được override trong các lớp con)
    public abstract double calculateTotalPrice();

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Full Name: " + fullName + ", Invoice Date: " + invoiceDate +
               ", Quantity: " + quantity + ", Unit Price: " + unitPrice + ", Total Price: " + calculateTotalPrice();
    }
}

// Lớp DomesticCustomer (lớp con kế thừa Customer)
class DomesticCustomer extends Customer {
    private String customerType; // "Sinh hoạt", "Kinh doanh", "Sản xuất"
    private double threshold; // Định mức

    public DomesticCustomer(String customerId, String fullName, String invoiceDate, double quantity, double unitPrice, String customerType, double threshold) {
        super(customerId, fullName, invoiceDate, quantity, unitPrice);
        this.customerType = customerType;
        this.threshold = threshold;
    }

    @Override
    public double calculateTotalPrice() {
        double quantity = getQuantity();
        double unitPrice = getUnitPrice();
        if (quantity <= threshold) {
            return quantity * unitPrice;
        } else {
            return threshold * unitPrice + (quantity - threshold) * unitPrice * 2.5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Customer Type: " + customerType + ", Threshold: " + threshold;
    }
}

// Lớp ForeignCustomer (lớp con kế thừa Customer)
class ForeignCustomer extends Customer {
    private String nationality;

    public ForeignCustomer(String customerId, String fullName, String invoiceDate, double quantity, double unitPrice, String nationality) {
        super(customerId, fullName, invoiceDate, quantity, unitPrice);
        this.nationality = nationality;
    }

    @Override
    public double calculateTotalPrice() {
        return getQuantity() * getUnitPrice();
    }

    @Override
    public String toString() {
        return super.toString() + ", Nationality: " + nationality;
    }
}

// Lớp InvoiceManager để quản lý danh sách hóa đơn
class InvoiceManager {
    private ArrayList<Customer> invoices;

    public InvoiceManager() {
        invoices = new ArrayList<>();
    }

    public void addInvoice(Customer invoice) {
        invoices.add(invoice);
    }

    public void displayAllInvoices() {
        for (Customer invoice : invoices) {
            System.out.println(invoice);
        }
    }

    public int countDomesticCustomers() {
        int count = 0;
        for (Customer invoice : invoices) {
            if (invoice instanceof DomesticCustomer) {
                count++;
            }
        }
        return count;
    }

    public int countForeignCustomers() {
        int count = 0;
        for (Customer invoice : invoices) {
            if (invoice instanceof ForeignCustomer) {
                count++;
            }
        }
        return count;
    }

    public double calculateAverageForeignCustomerPrice() {
        double total = 0;
        int count = 0;
        for (Customer invoice : invoices) {
            if (invoice instanceof ForeignCustomer) {
                total += invoice.calculateTotalPrice();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    public void displayInvoicesInSeptember2013() {
        for (Customer invoice : invoices) {
            if (invoice.getInvoiceDate().contains("09/2013")) {
                System.out.println(invoice);
            }
        }
    }
}

// Chương trình chính
public class DSHDDien {
    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();

        // Thêm một số hóa đơn mẫu
        manager.addInvoice(new DomesticCustomer("KH001", "Nguyen Van A", "01/09/2013", 150, 2000, "Sinh hoạt", 100));
        manager.addInvoice(new DomesticCustomer("KH002", "Tran Thi B", "15/09/2013", 250, 2000, "Kinh doanh", 200));
        manager.addInvoice(new ForeignCustomer("KH003", "John Doe", "10/09/2013", 300, 3000, "American"));
        manager.addInvoice(new ForeignCustomer("KH004", "Jane Smith", "20/09/2013", 400, 2500, "British"));

        // Hiển thị tất cả hóa đơn
        System.out.println("Tất cả các hóa đơn:");
        manager.displayAllInvoices();

        // Đếm số lượng khách hàng Việt Nam và nước ngoài
        System.out.println("\nSố lượng khách hàng Việt Nam: " + manager.countDomesticCustomers());
        System.out.println("Số lượng khách hàng nước ngoài: " + manager.countForeignCustomers());

        // Tính trung bình thành tiền của khách hàng nước ngoài
        System.out.println("\nTrung bình thành tiền của khách hàng nước ngoài: " + manager.calculateAverageForeignCustomerPrice());

        // Xuất ra các hóa đơn của tháng 09 năm 2013
        System.out.println("\nHóa đơn trong tháng 09/2013:");
        manager.displayInvoicesInSeptember2013();
    }
}
