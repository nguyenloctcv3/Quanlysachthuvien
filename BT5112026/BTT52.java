import java.util.ArrayList;
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
    static int timViTri(ArrayList<Sach> ds, String ma) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).maS.equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> dsSach = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Nhap lua chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                // 1. Them sach
                case 1:
                    Sach s = new Sach();
                    System.out.println("\n--- Nhap thong tin sach moi ---");
                    
                    System.out.print("Ma sach: ");
                    s.maS = sc.nextLine();

                    // Kiem tra trung ma sach
                    if (timViTri(dsSach, s.maS) != -1) {
                        System.out.println("Loi: Ma sach da ton tai trong he thong!");
                        break;
                    }

                    System.out.print("Ten sach: ");
                    s.tenS = sc.nextLine();

                    System.out.print("Ten tac gia: ");
                    s.tenTacGia = sc.nextLine();

                    // Kiem tra don gia > 0
                    do {
                        System.out.print("Don gia: ");
                        s.donGia = sc.nextDouble();
                        if (s.donGia <= 0) {
                            System.out.println("Don gia phai lon hon 0! Vui long nhap lai.");
                        }
                    } while (s.donGia <= 0);

                    // Kiem tra so luong > 0
                    do {
                        System.out.print("So luong: ");
                        s.soLuong = sc.nextInt();
                        if (s.soLuong <= 0) {
                            System.out.println("So luong phai lon hon 0! Vui long nhap lai.");
                        }
                    } while (s.soLuong <= 0);

                    System.out.print("Nam xuat ban: ");
                    s.namXB = sc.nextInt();
                    sc.nextLine();

                    dsSach.add(s);
                    System.out.println(">> Them sach thanh cong!");
                    break;

                // 2. Hien thi sach
                case 2:
                    if (dsSach.isEmpty()) {
                        System.out.println("[!] Danh sach dang trong!");
                    } else {
                        System.out.println("\n--- DANH SACH SACH TRONG THU VIEN ---");
                        for (int i = 0; i < dsSach.size(); i++) {
                            Sach b = dsSach.get(i);
                            System.out.printf("%d. Ma: %s | Ten: %s | TG: %s | Gia: %.0f | SL: %d | NamXB: %d%n",
                                    (i + 1), b.maS, b.tenS, b.tenTacGia, b.donGia, b.soLuong, b.namXB);
                        }
                    }
                    break;

                // 3. Tim sach
                case 3:
                    if (dsSach.isEmpty()) {
                        System.out.println("[!] Danh sach dang trong!");
                        break;
                    }
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();
                    int vtTim = timViTri(dsSach, maTim);

                    if (vtTim == -1) {
                        System.out.println("=> Khong tim thay ma sach: " + maTim);
                    } else {
                        Sach b = dsSach.get(vtTim);
                        System.out.println("=> TIM THAY SACH:");
                        System.out.println("- Ma sach: " + b.maS);
                        System.out.println("- Ten sach: " + b.tenS);
                        System.out.println("- Tac gia: " + b.tenTacGia);
                        System.out.printf("- Don gia: %.0f%n", b.donGia);
                        System.out.println("- So luong: " + b.soLuong);
                        System.out.println("- Nam XB: " + b.namXB);
                    }
                    break;

                // 4. Xoa sach
                case 4:
                    if (dsSach.isEmpty()) {
                        System.out.println("[!] Danh sach dang trong!");
                        break;
                    }
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();
                    int vtXoa = timViTri(dsSach, maXoa);

                    if (vtXoa == -1) {
                        System.out.println("=> Khong tim thay ma sach de xoa!");
                    } else {
                        dsSach.remove(vtXoa);
                        System.out.println(">> Da xoa thanh cong sach co ma: " + maXoa);
                    }
                    break;

                // 5. Sua sach
                case 5:
                    if (dsSach.isEmpty()) {
                        System.out.println("[!] Danh sach dang trong!");
                        break;
                    }
                    System.out.print("Nhap ma sach can sua: ");
                    String maSua = sc.nextLine();
                    int vtSua = timViTri(dsSach, maSua);

                    if (vtSua == -1) {
                        System.out.println("=> Khong tim thay ma sach de sua!");
                    } else {
                        Sach b = dsSach.get(vtSua);
                        System.out.println("--- Nhap thong tin moi cho ma " + maSua + " ---");
                        
                        System.out.print("Ten sach moi: ");
                        b.tenS = sc.nextLine();

                        System.out.print("Ten tac gia moi: ");
                        b.tenTacGia = sc.nextLine();

                        do {
                            System.out.print("Don gia moi: ");
                            b.donGia = sc.nextDouble();
                            if (b.donGia <= 0) {
                                System.out.println("Don gia phai lon hon 0! Vui long nhap lai.");
                            }
                        } while (b.donGia <= 0);

                        do {
                            System.out.print("So luong moi: ");
                            b.soLuong = sc.nextInt();
                            if (b.soLuong <= 0) {
                                System.out.println("So luong phai lon hon 0! Vui long nhap lai.");
                            }
                        } while (b.soLuong <= 0);

                        System.out.print("Nam xuat ban moi: ");
                        b.namXB = sc.nextInt();
                        sc.nextLine();

                        System.out.println(">> Cap nhat sach thanh cong!");
                    }
                    break;

                // 6. Tinh tong so luong
                case 6:
                    if (dsSach.isEmpty()) {
                        System.out.println("[!] Danh sach dang trong!");
                    } else {
                        int tongSL = 0;
                        for (Sach b : dsSach) {
                            tongSL += b.soLuong;
                        }
                        System.out.println("Tong so luong tat ca cac sach: " + tongSL);
                    }
                    break;

                // 7. Tinh tong gia tri
                case 7:
                    if (dsSach.isEmpty()) {
                        System.out.println("[!] Danh sach dang trong!");
                    } else {
                        double tongGiaTri = 0;
                        for (Sach b : dsSach) {
                            tongGiaTri += b.donGia * b.soLuong;
                        }
                        System.out.printf("Tong gia tri tat ca cac sach: %.0f%n", tongGiaTri);
                    }
                    break;

                // 8. Thoat
                case 8:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (luaChon != 8);

        sc.close();
    }
}