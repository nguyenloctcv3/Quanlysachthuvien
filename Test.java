import java.util.Scanner;
import java.util.ArrayList;
import java.time.Year;


class Sach{
    // Yêu cầu 1 : Tất cả thuộc tính của lớp Sach phải được khai báo với từ khóa private
	private String maSach; 
	private String tieuDe;
	private String tacGia;
	private int namXuatBan;
	private int soLuong;
    // Yêu cầu 2: Cung cấp đầy đủ các phương thức public getters(phương thức truy cập)
    // và setters (phương thức sửa đổi) cho tất cả các thuộc tính của lớp Sach
    public String getMaSach(){
        return this.maSach;
    }
    public void setMaSach(String maSach){
        this.maSach = maSach;
    }

    public String getTieuDe(){
        return this.tieuDe;
    }
    public void setTieuDe(String tieuDe){
        this.tieuDe = tieuDe;
    }

    public String getTacGia(){
        return this.tacGia;
    }
    public void setTacGia(String tacGia){
        this.tacGia = tacGia;
    }

    public int getNamXuatBan(){
        return this.namXuatBan;
    }
    //Trong setNamXuatBan(int namXuatBan): Đảm bảo namXuatBan không lớn hơn năm hiện tại hoặc 
    // nhỏ hơn một giá trị hợp lý nào đó (ví dụ: if(namXuatBan > 0 && namXuatBan <= currentYear)).
    public void setNamXuatBan(int namXuatBan){
        int currentYear;
        currentYear = Year.now().getValue();
        if(namXuatBan > 0 && namXuatBan <= currentYear){
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Nam khong hop le");
        }
    }

    public int getSoLuong(){
        return this.soLuong;
    }
    // Trong setSoLuong(int soLuong): Đảm bảo soLuong không âm (if
    // (soLuong >= 0)).
    public void setSoLuong(int soLuong){
        if(soLuong >= 0){
            this.soLuong = soLuong;
        } else {
            System.out.println("So luong khong hop le");
        }
    }

    public Sach(){

    }
    // Thêm một constructor có tham số đầy đủ vào lớp Sach, cho phép
    // khởi tạo tất cả các thuộc tính (maSach, tieuDe, tacGia, namXuatBan, soLuong) khi
    // tạo một đối tượng Sach.
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong){
        setMaSach(maSach);
        setTieuDe(tieuDe);
        setTacGia(tacGia);
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }
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
			if(ds.get(i).getMaSach().equals(ma)){
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
		s.setMaSach(ma);
		System.out.print("Tieu de: ");
		s.setTieuDe(sc.nextLine());
		System.out.print("Tac gia: ");
		s.setTacGia(sc.nextLine());
        // Kiểm tra năm xuất bản nhập lại nếu nhập sai
		int nam;
        int currentYear = Year.now().getValue();
		do {
            System.out.println("Nam xuat ban: ");
            nam = sc.nextInt();
            sc.nextLine();
            s.setNamXuatBan(nam);
        } while (nam <= 0 || nam > currentYear);
		// Kiểm tra nhập lại số lượng nếu nhập sai
        int slg;
        do {
            System.out.println("Nhap so luong: ");
            slg = sc.nextInt();
            sc.nextLine();
            s.setSoLuong(slg);
        } while (slg < 0);

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
		Sach s = new Sach("S0001", "Toi thay hoa vang tren co xanh", "Nguyen Nhat Anh", 2005, 10);
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