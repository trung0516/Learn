package LearnCode;

import java.util.ArrayList;

// Lớp Invoice (lớp cha)
abstract class Invoice {
    private String invoiceId;
    private String invoiceDate; // định dạng: "ngày/tháng/năm"
    private String customerName;
    private String roomId;
    private double unitPrice;

    public Invoice(String invoiceId, String invoiceDate, String customerName, String roomId, double unitPrice) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.roomId = roomId;
        this.unitPrice = unitPrice;
    }

    // Các getter và setter
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
        return "Invoice ID: " + invoiceId + ", Date: " + invoiceDate + ", Customer: " + customerName +
               ", Room ID: " + roomId + ", Unit Price: " + unitPrice + ", Total Price: " + calculateTotalPrice();
    }
}

// Lớp HourlyInvoice (lớp con kế thừa Invoice)
class HourlyInvoice extends Invoice {
    private double hours;

    public HourlyInvoice(String invoiceId, String invoiceDate, String customerName, String roomId, double unitPrice, double hours) {
        super(invoiceId, invoiceDate, customerName, roomId, unitPrice);
        this.hours = hours;
    }

    @Override
    public double calculateTotalPrice() {
        if (hours > 30) {
            throw new IllegalArgumentException("Hourly invoice cannot be used for more than 30 hours.");
        }
        double effectiveHours = hours > 24 ? 24 : hours;
        return effectiveHours * getUnitPrice();
    }

    @Override
    public String toString() {
        return super.toString() + ", Hours: " + hours;
    }
}

// Lớp DailyInvoice (lớp con kế thừa Invoice)
class DailyInvoice extends Invoice {
    private int days;

    public DailyInvoice(String invoiceId, String invoiceDate, String customerName, String roomId, double unitPrice, int days) {
        super(invoiceId, invoiceDate, customerName, roomId, unitPrice);
        this.days = days;
    }

    @Override
    public double calculateTotalPrice() {
        return days * getUnitPrice();
    }

    @Override
    public String toString() {
        return super.toString() + ", Days: " + days;
    }
}

// Lớp InvoiceManager để quản lý danh sách hóa đơn
class InvoiceMNG {
    private ArrayList<Invoice> invoices;

    public InvoiceMNG() {
        invoices = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public void displayAllInvoices() {
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }

    public int countHourlyInvoices() {
        int count = 0;
        for (Invoice invoice : invoices) {
            if (invoice instanceof HourlyInvoice) {
                count++;
            }
        }
        return count;
    }

    public int countDailyInvoices() {
        int count = 0;
        for (Invoice invoice : invoices) {
            if (invoice instanceof DailyInvoice) {
                count++;
            }
        }
        return count;
    }

    public double calculateAverageDailyInvoicePrice() {
        double total = 0;
        int count = 0;
        for (Invoice invoice : invoices) {
            if (invoice instanceof DailyInvoice) {
                total += invoice.calculateTotalPrice();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    public void displayInvoicesInSeptember2013() {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceDate().contains("09/2013")) {
                System.out.println(invoice);
            }
        }
    }
}

// Chương trình chính
public class HoaDonThuePhongg {
    public static void main(String[] args) {
        InvoiceMNG manager = new InvoiceMNG();

        // Thêm một số hóa đơn mẫu
        manager.addInvoice(new HourlyInvoice("INV001", "01/09/2013", "Nguyen Van A", "P001", 100, 10));
        manager.addInvoice(new HourlyInvoice("INV002", "15/09/2013", "Tran Thi B", "P002", 120, 25));
        manager.addInvoice(new DailyInvoice("INV003", "10/09/2013", "Le Van C", "P003", 200, 5));
        manager.addInvoice(new DailyInvoice("INV004", "20/09/2013", "Pham Thi D", "P004", 250, 3));

        // Hiển thị tất cả hóa đơn
        System.out.println("Tất cả các hóa đơn:");
        manager.displayAllInvoices();

        // Đếm số lượng hóa đơn theo giờ và theo ngày
        System.out.println("\nSố lượng hóa đơn theo giờ: " + manager.countHourlyInvoices());
        System.out.println("Số lượng hóa đơn theo ngày: " + manager.countDailyInvoices());

        // Tính trung bình thành tiền của hóa đơn theo ngày
        System.out.println("\nTrung bình thành tiền của hóa đơn theo ngày: " + manager.calculateAverageDailyInvoicePrice());

        // Xuất ra các hóa đơn của tháng 09 năm 2013
        System.out.println("\nHóa đơn trong tháng 09/2013:");
        manager.displayInvoicesInSeptember2013();
    }
}
