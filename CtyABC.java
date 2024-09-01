package LearnCode;

import java.util.Date;

public class CtyABC {
public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private double heSoLuong;
    private double luongCoBan;

    // Constructor 1: Mặc định
    public NhanVien() {
    }

    // Constructor 2: Với tất cả thuộc tính
    public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, String diaChi, double heSoLuong, double luongCoBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    // Constructor 3: Không có địa chỉ
    public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, double heSoLuong, double luongCoBan) {
        this(maNhanVien, hoTen, ngaySinh, "", heSoLuong, luongCoBan);
    }

    // Constructor 4: Không có ngày sinh và địa chỉ
    public NhanVien(String maNhanVien, String hoTen, double heSoLuong, double luongCoBan) {
        this(maNhanVien, hoTen, null, "", heSoLuong, luongCoBan);
    }

    // Constructor 5: Chỉ có mã nhân viên và họ tên
    public NhanVien(String maNhanVien, String hoTen) {
        this(maNhanVien, hoTen, null, "", 0, 0);
    }

    // Getter và Setter
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        if (heSoLuong >= 0) {
            this.heSoLuong = heSoLuong;
        } else {
            throw new IllegalArgumentException("Hệ số lương không thể âm.");
        }
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        if (luongCoBan >= 0) {
            this.luongCoBan = luongCoBan;
        } else {
            throw new IllegalArgumentException("Lương cơ bản không thể âm.");
        }
    }

    public double tinhLuong() {
        return heSoLuong * luongCoBan;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", heSoLuong=" + heSoLuong +
                ", luongCoBan=" + luongCoBan +
                ", luong=" + tinhLuong() +
                '}';
    }
}
}