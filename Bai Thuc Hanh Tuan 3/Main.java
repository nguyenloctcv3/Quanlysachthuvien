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

        // 66Thuc hanh tuan 4
        // Bai 1: Kiem tra hop le
        if (s.donGia <= 0 || s.soLuong < 0 || s.namXuatBan < 1900 || s.namXuatBan > 2026) {
            System.out.println("Du lieu khong hop le");
            return;
        }

        // Bai 2: Phan loai gia
        String loaiGia;
        if (s.donGia < 50000) {
            loaiGia = "Sach gia thap";
        } else if (s.donGia <= 100000) {
            loaiGia = "Sach gia trung binh";
        } else if (s.donGia <= 200000) {
            loaiGia = "Sach gia cao";
        } else {
            loaiGia = "Sach gia dac biet";
        }

        // Bai 3: Phan loai ton kho
        String tonKho;
        if (s.soLuong == 0) {
            tonKho = "Het sach";
        } else if (s.soLuong <= 5) {
            tonKho = "Sap het";
        } else if (s.soLuong <= 20) {
            tonKho = "Con it";
        } else {
            tonKho = "Con nhieu";
        }

        // Bai 4: switch chon loai sach
        System.out.println("Chon loai sach (1-Sach giao khoa, 2-Sach tham khao, 3-Sach chuyen nganh, 4-Sach khac): ");
        int loai = sc.nextInt();

        String tenLoai;
        switch (loai) {
            case 1:
                tenLoai = "Sach giao khoa";
                break;
            case 2:
                tenLoai = "Sach tham khao";
                break;
            case 3:
                tenLoai = "Sach chuyen nganh";
                break;
            case 4:
                tenLoai = "Sach khac";
                break;
            default:
                tenLoai = "Loai sach khong hop le";
        }

        System.out.println("Loai gia: " + loaiGia);
        System.out.println("Ton kho: " + tonKho);
        System.out.println("Loai sach: " + tenLoai);

        sc.close();
    }
}