import java.util.ArrayList;
import java.util.Scanner;

// Xay dung cac lop voi chuc nang thua ke lop Sach
class Sach {
    String maSach;
    String ngayNhap;
    double donGia;
    int soLuong;
    String nhaXB;

    void nhap(Scanner sc) {
        System.out.print("Ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Ngay nhap (dd/mm/yyyy): ");
        ngayNhap = sc.nextLine();

        System.out.print("Don gia: ");
        donGia = sc.nextDouble();

        System.out.print("So luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();

        System.out.print("Nha xuat ban: ");
        nhaXB = sc.nextLine();
    }

    void xuat() {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ngay nhap: " + ngayNhap);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Nha xuat ban: " + nhaXB);
    }
}

class SachGiaoKhoa extends Sach {
    String tinhTrang;

    @Override
    void nhap(Scanner sc) {
        super.nhap(sc);
        do {
            System.out.print("Tinh trang (Moi/Cu): ");
            tinhTrang = sc.nextLine();
        } while (!tinhTrang.equalsIgnoreCase("Moi") && !tinhTrang.equalsIgnoreCase("Cu"));
    }

    @Override
    void xuat() {
        super.xuat();
        System.out.println("Tinh trang: " + tinhTrang);
        System.out.println("Thanh tien: " + thanhTien());
        System.out.println();
    }

    double thanhTien() {
        if (tinhTrang.equalsIgnoreCase("Moi")) {
            return soLuong * donGia;
        }
        return soLuong * donGia * 0.5;
    }
}

class SachThamKhao extends Sach {
    double thue;

    @Override
    void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Thue: ");
        thue = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    void xuat() {
        super.xuat();
        System.out.println("Thue: " + thue);
        System.out.println("Thanh tien: " + thanhTien());
        System.out.println();
    }

    double thanhTien() {
        return soLuong * donGia + thue;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SachGiaoKhoa> dsSGK = new ArrayList<>();
        ArrayList<SachThamKhao> dsSTK = new ArrayList<>();

        //  Nhap danh sach cac loai sach
        System.out.print("Nhap so sach giao khoa: ");
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            System.out.println("\nSach giao khoa thu " + (i + 1));
            SachGiaoKhoa s = new SachGiaoKhoa();
            s.nhap(sc);
            dsSGK.add(s);
        }

        System.out.print("\nNhap so sach tham khao: ");
        int k = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < k; i++) {
            System.out.println("\nSach tham khao thu " + (i + 1));
            SachThamKhao s = new SachThamKhao();
            s.nhap(sc);
            dsSTK.add(s);
        }

        //  Xuat danh sach cac loai sach
        System.out.println("\nDANH SACH SACH GIAO KHOA\n");
        for (int i = 0; i < dsSGK.size(); i++) {
            dsSGK.get(i).xuat();
        }

        System.out.println("DANH SACH SACH THAM KHAO\n");
        for (int i = 0; i < dsSTK.size(); i++) {
            dsSTK.get(i).xuat();
        }

        //  Tinh tong thanh tien cho tung loai
        double tongSGK = 0;
        for (int i = 0; i < dsSGK.size(); i++) {
            tongSGK += dsSGK.get(i).thanhTien();
        }

        double tongSTK = 0;
        for (int i = 0; i < dsSTK.size(); i++) {
            tongSTK += dsSTK.get(i).thanhTien();
        }

        System.out.println("Tong thanh tien sach giao khoa: " + tongSGK);
        System.out.println("Tong thanh tien sach tham khao: " + tongSTK);

        // Tinh trung binh cong don gia cua cac sach tham khao
        if (dsSTK.size() > 0) {
            double tongDonGia = 0;
            for (int i = 0; i < dsSTK.size(); i++) {
                tongDonGia += dsSTK.get(i).donGia;
            }
            System.out.println("Trung binh cong don gia sach tham khao: " + (tongDonGia / dsSTK.size()));
        } else {
            System.out.println("Khong co sach tham khao.");
        }

        // Xuat ra cac sach giao khoa cua nha xuat ban X
        System.out.print("\nNhap nha xuat ban X: ");
        String x = sc.nextLine();
        System.out.println();

        int dem = 0;
        for (int i = 0; i < dsSGK.size(); i++) {
            if (dsSGK.get(i).nhaXB.equalsIgnoreCase(x)) {
                dsSGK.get(i).xuat();
                dem++;
            }
        }

        if (dem == 0) {
            System.out.println("Khong co sach giao khoa cua NXB " + x);
        }

        sc.close();
    }
}