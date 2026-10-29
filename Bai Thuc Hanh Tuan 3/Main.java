import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    String tacGia;
    int namXuatBan;
    double donGia;
    int soLuong;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach s = new Sach();

        // Bai 1: Nhap thong tin sach
        System.out.print("Nhap ma sach: ");
        s.maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        s.tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        s.tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        s.namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        s.donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        s.soLuong = sc.nextInt();

        // Bai 2, 3, 4: Tinh toan
        double thanhTien = s.donGia * s.soLuong;
        double phiVanChuyen = 0.05 * thanhTien;
        double tongTien = thanhTien + phiVanChuyen;

        // Hien thi ket qua
        System.out.println("\n--- THONG TIN SACH ---");
        System.out.println("Ma sach: " + s.maSach);
        System.out.println("Ten sach: " + s.tenSach);
        System.out.println("Tac gia: " + s.tacGia);
        System.out.println("Nam xuat ban: " + s.namXuatBan);
        System.out.printf("Don gia: %.0f\n", s.donGia);
        System.out.println("So luong: " + s.soLuong);
        System.out.printf("Thanh tien: %.0f\n", thanhTien);
        System.out.printf("Phi van chuyen: %.0f\n", phiVanChuyen);
        System.out.printf("Tong tien: %.0f\n", tongTien);
        
        sc.close();
    }
}