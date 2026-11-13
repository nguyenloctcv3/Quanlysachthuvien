import java.util.Scanner;
import java.util.ArrayList;

// Yêu cầu 1: Tạo 1 lớp có tên là Sach để biểu diễn thông tin về 1 cuốn sách
class Sach{
	String maSach; 
	String tieuDe;
	String tacGia;
	int namXuatBan;
	int soLuong;
	// Yêu cầu 2: Tạo 1 phương thức hienThiThongTin() 
	void hienThiThongTin(){
		System.out.println("Ma sach: " + this.maSach);
		System.out.println("Tieu de: " + this.tieuDe);
		System.out.println("Tac gia: " + this.tacGia);
		System.out.println("Nam xuat ban: " + this.namXuatBan);
		System.out.println("So luong: " + this.soLuong);
	}
}
// Yêu cầu 3: Xây dựng lớp Test để tạo đối tương từ lớp Sach
public class Test{
	// Xây dựng hàm tìm vị trí
	static int timViTri(ArrayList<Sach> ds, String ma){
		for(int i = 0; i < ds.size(); i++){
			if(ds.get(i).maSach.equals(ma)){
				return i;
			}
		}
		return -1;
	}
	
	// Chức năng thêm sách
	static void themSach(ArrayList<Sach> ds, Scanner sc){
		String ma;
		int vt;
		System.out.println("Them sach moi");
        do {
        System.out.print("Ma sach: ");
        ma = sc.nextLine();
    
        if (ma.equals("")) {
        System.out.println("Ma sach khong duoc de trong");
        vt = -1; 
        } else {
            vt = timViTri(ds, ma);
            if (vt != -1) {
                System.out.println("Ma sach da ton tai");
        }
    }
} while (ma.equals("") || vt != -1);
		Sach s = new Sach();
		s.maSach = ma;
		System.out.print("Tieu de: ");
		s.tieuDe = sc.nextLine();
		System.out.print("Tac gia: ");
		s.tacGia = sc.nextLine();
		System.out.print("Nam xuat ban: ");
		s.namXuatBan = sc.nextInt();
		sc.nextLine();
		System.out.print("So luong: ");
		s.soLuong = sc.nextInt();
		sc.nextLine();
		ds.add(s);
		System.out.println("Da nhap sach thanh cong");
	}
	// Chức năng xóa sách
	static void xoaSach(ArrayList<Sach> ds, Scanner sc){
		String ma;
		int vt;
		if(ds.size() == 0){
			System.out.println("Danh sach dang trong");
			return;
		}
		System.out.println("Nhap ma sach can xoa: ");
		ma = sc.nextLine();
		vt = timViTri(ds, ma);
		if(vt != -1){
			ds.remove(vt);
			System.out.println("Da xoa thanh cong sach co ma: " + ma);
		} else{
			System.out.println("Khong tim thay sach co ma: " + ma);
			return;
		}
	}
	// Chức năng hiển thị toàn bộ Sach
	static void hienThiDanhSach(ArrayList<Sach> ds){
		if(ds.size() == 0){
			System.out.println("Danh sach dang trong");
			return;
		}
		for(int i = 0; i < ds.size(); i++){
			System.out.println("Sach thu " + (i+1) + ":");
			ds.get(i).hienThiThongTin();
		}
	}
	// Chức nằng tìm sách
	static void timSach(ArrayList<Sach> ds, Scanner sc){
		String ma;
		int vt;
		if(ds.size() == 0){
			System.out.println("Danh sach dang trong");
			return;
		}
		System.out.println("Nhap ma sach can tim: ");
		ma = sc.nextLine();
		vt = timViTri(ds, ma);
		if(vt != -1){
			System.out.println("Da tim thay sach co ma " + ma);
			System.out.println("Thong tin cua sach la: ");
			ds.get(vt).hienThiThongTin();
		} else {
			System.out.println("Khong tim thay sach co ma " + ma);
			return;
		}
	}
		public static void main(String[] args){
		ArrayList<Sach> ds = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Sach s = new Sach();
		s.maSach = "S0001";
		s.tieuDe = "Toi thay hoa vang tren co xanh";
		s.tacGia = "Nguyen Nhat Anh";
		s.namXuatBan = 2005;
		s.soLuong = 10;
		ds.add(s);
		// Yêu cầu 4: Tạo và quản lí sách bằng ArrayList 
		int luaChon;
		do{
			System.out.println("Quan li sach");
			System.out.println("1. Them sach");
			System.out.println("2. Hien thi danh sach sach");
			System.out.println("3. Xoa sach");
			System.out.println("4. Tim sach");
			System.out.println("0. Thoat");
			System.out.println("Nhap lua chon: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon){
				case 1: 
					themSach(ds, sc);
					break;
				case 2: 
					hienThiDanhSach(ds);
					break;
				case 3: 
					xoaSach(ds, sc);
					break;
				case 4: 
					timSach(ds, sc);
					break;
				case 0: 
					System.out.println("Thoat chuong trinh");
					break;
				default:
					System.out.println("Nhap cac so tu 0 den 4");
			}
		} while (luaChon != 0);
	}
}