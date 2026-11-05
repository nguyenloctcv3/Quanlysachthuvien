import java.util.Scanner;

class Sach {
    String maS;
    String tenS;
    String tenTacGia;
    int soLuong;
    double donGia;
    int namXB;
}

public class BTT52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach[] ds = new Sach[0];
        int n = 0;
        int luaChon;

        int tongSoLuong = 0;
        double tongGiaTri = 0;

        // ==================== BÀI 3 ====================
        do {
            System.out.println("\n========== QUAN LY SACH ==========");
            System.out.println("1. Nhap thong tin sach");
            System.out.println("2. Xem tong so luong sach");
            System.out.println("3. Xem tong gia tri sach");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.println("==================================");
            System.out.print("Nhap lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                // ==================== BÀI 1 ====================
                case 1:
                    do {
                        System.out.print("Nhap so luong cuon sach can nhap: ");
                        n = sc.nextInt();
                        sc.nextLine();
                        if (n <= 0) {
                            System.out.println("n phai lon hon 0! Vui long nhap lai.");
                        }
                    } while (n <= 0);

                    ds = new Sach[n];
                    tongSoLuong = 0;
                    tongGiaTri = 0;

                    for (int i = 0; i < n; i++) {
                        ds[i] = new Sach();

                        System.out.println("\n--- Nhap sach thu " + (i + 1) + " ---");
                        
                        System.out.print("Ma sach: ");
                        ds[i].maS = sc.nextLine();

                        System.out.print("Ten sach: ");
                        ds[i].tenS = sc.nextLine();

                        System.out.print("Ten tac gia: ");
                        ds[i].tenTacGia = sc.nextLine();

                        System.out.print("Don gia: ");
                        ds[i].donGia = sc.nextDouble();

                        System.out.print("So luong: ");
                        ds[i].soLuong = sc.nextInt();

                        System.out.print("Nam xuat ban: ");
                        ds[i].namXB = sc.nextInt();
                        sc.nextLine();

                        // ==================== BÀI 2 ====================
                        tongSoLuong += ds[i].soLuong;
                        tongGiaTri += ds[i].donGia * ds[i].soLuong;
                    }
                    System.out.println(">> Da nhap thanh cong " + n + " cuon sach vao mang!");
                    break;

                case 2:
                    if (ds.length == 0) {
                        System.out.println("[!] Chua co du lieu! Vui long nhap sach o muc 1 truoc.");
                    } else {
                        System.out.println("Tong so luong sach: " + tongSoLuong);
                    }
                    break;

                case 3:
                    if (ds.length == 0) {
                        System.out.println("[!] Chua co du lieu! Vui long nhap sach o muc 1 truoc.");
                    } else {
                        System.out.printf("Tong gia tri tat ca cac sach: %.0f%n", tongGiaTri);
                    }
                    break;

                // ==================== BÀI 4 ====================
                case 4:
                    if (ds.length == 0) {
                        System.out.println("[!] Chua co du lieu! Vui long nhap sach o muc 1 truoc.");
                        break;
                    }

                    System.out.print("Nhap ma sach can tim: ");
                    String maCanTim = sc.nextLine();
                    boolean timThay = false;

                    for (int i = 0; i < ds.length; i++) {
                        if (ds[i].maS.equals(maCanTim)) {
                            System.out.println("=> TIM THAY SACH:");
                            System.out.println("- Ten sach: " + ds[i].tenS);
                            System.out.println("- Tac gia: " + ds[i].tenTacGia);
                            System.out.println("- Nam XB: " + ds[i].namXB);
                            System.out.printf("- Don gia: %.0f%n", ds[i].donGia);
                            System.out.println("- So luong: " + ds[i].soLuong);
                            timThay = true;
                            break;
                        }
                    }

                    if (!timThay) {
                        System.out.println("=> Khong tim thay sach co ma: " + maCanTim);
                    }
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (luaChon != 0);

        sc.close();
    }
}