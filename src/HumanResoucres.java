import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.*;
import java.lang.String;
import static java.lang.Double.parseDouble;
import java.text.SimpleDateFormat;

public class HumanResoucres {
    public static ArrayList<Staff> dsNV = new ArrayList<Staff>();
    public static ArrayList<Department> dsBP = new ArrayList<Department>();
    public  static ArrayList<BangLuong> blNV= new ArrayList<BangLuong>();
    public static void main(String[] args){
        do {
            System.out.println("");
            System.out.println("Vui lòng chọn chức năng sử dụng");
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("2. Hiển thị các bộ phận trong công ty");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
            System.out.println("4. Thêm nhân viên mới vào công ty");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
            System.out.print("Tôi chọn chức năng số: ");
            Scanner sc = new Scanner(System.in);
            int chucNang = sc.nextInt();
            switch (chucNang) {
                case 1:
                    hienThiDanhSachNhanVien();
                    break;
                case 2:
                    hienThiBoPhan();
                    break;
                case 3:
                    hienThiNhanVienTheoBoPhan();
                    break;
                case 4:
                    themMoiNhanVien();
                    break;
                case 5:
                    timKiemNhanVien();
                    break;
                case 6:
                    hienThiBangLuong();
                    break;
                case 7:
                    hienThiBangLuongTangDan();
                    break;
                case 8:
                    hienThiBangLuongGiamDan();
                    break;
                default:
                    System.out.println("Bạn chọn sai chức năng");
                    choBanPhim();
                    break;
            }
        } while (true);
    }

    public static void hienThiDanhSachNhanVien(){
        if(dsNV.size()==0) {thongBao();}
        else {
            System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-25s%-15s\n","MÃ NV","TÊN NV", "CHỨC DANH","TUỔI","HỆ SỐ LƯƠNG","NGÀY VÀO LÀM","BỘ PHẬN","SỐ NGÀY NGHỈ");
            for (Staff nv : dsNV) {
                nv.displayInformation();
            }
            choBanPhim();
        }
    }
    public static void nhapNhanVienThongThuong() {
         Employee nv = new Employee();
         Scanner sc = new Scanner(System.in);
         boolean flag=true;
         System.out.print("Mã nhân viên: ");
         nv.setMaNV(sc.next());
         Scanner ten = new Scanner(System.in);
         System.out.print("Họ tên: ");
         nv.setTenNV(ten.nextLine());
         do {
             try {
                 System.out.print("Tuổi: ");
                 Scanner tuoi = new Scanner(System.in);
                 nv.setTuoiNV(tuoi.nextInt());
                 flag=true;
             } catch (Exception ex)
                {
                    System.out.println("Nhập tuổi không đúng định dạng");
                    flag=false;
                    ex.fillInStackTrace();
                }
         }
         while (flag==false);


        do {
            try {
                System.out.print("Hệ số lương: ");
                Scanner heSoLuong = new Scanner(System.in);
                nv.setHeSoLuong(heSoLuong.nextDouble());
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Hệ số lương không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Ngày vào làm: ");
                Scanner ngayVaoLam = new Scanner(System.in);
                String ngayString= ngayVaoLam.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngayString);
                nv.setNgayVaoLam(date);
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Ngày vào làm không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Bộ phận: ");
                String boPhan=new Scanner(System.in).nextLine();
                addDepartment(boPhan);
                nv.setBoPhan(boPhan);
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Bộ phận không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Số ngày nghỉ: ");
                Scanner soNgayNghi = new Scanner(System.in);
                nv.setSoNgayNghi(soNgayNghi.nextInt());
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Số ngày nghỉ không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Số giờ làm thêm: ");
                Scanner soGioLamthem = new Scanner(System.in);
                nv.setSoGioLamThem(soGioLamthem.nextInt());
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Số giờ làm thêm không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

         dsNV.add(nv);
         System.out.println("Đã thêm mới thành công nhân viên: " + nv.getTenNV());
 }
    public static void nhapNhanVienQuanLy() {
        boolean flag=true;
        Manager nv = new Manager();
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã nhân viên: ");
        nv.setMaNV(sc.next());
        Scanner ten = new Scanner(System.in);
        System.out.print("Họ tên: ");
        nv.setTenNV(ten.nextLine());
        boolean trangThaiChucDanh=false;
        do {
            System.out.print("Chức danh: 1 Business Leader;  2 Project Leader; 3 Technical Leader: ");
            Scanner chucDanh = new Scanner(System.in);
            int tenChucDanh = chucDanh.nextInt();
            switch (tenChucDanh) {
                case 1:
                    nv.setChucDanh("Business Leader");
                    trangThaiChucDanh = true;
                    break;
                case 2:
                    nv.setChucDanh("Project Leader");
                    trangThaiChucDanh = true;
                    break;
                case 3:
                    nv.setChucDanh("Technical Leader");
                    trangThaiChucDanh = true;
                    break;
                default:
                    System.out.println("Nhập sai chức danh, vui lòng nhập lại");
            };
        }while (trangThaiChucDanh==false);

        do {
            try {
                System.out.print("Tuổi: ");
                Scanner tuoi = new Scanner(System.in);
                nv.setTuoiNV(tuoi.nextInt());
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập tuổi không đúng định dạng");
                flag=false;
                ex.fillInStackTrace();
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Hệ số lương: ");
                Scanner heSoLuong = new Scanner(System.in);
                nv.setHeSoLuong(heSoLuong.nextDouble());
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Hệ số lương không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Ngày vào làm: ");
                Scanner ngayVaoLam = new Scanner(System.in);
                String ngayString= ngayVaoLam.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngayString);
                nv.setNgayVaoLam(date);
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Ngày vào làm không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);

        do {
            try {
                System.out.print("Bộ phận: ");
                String boPhan=new Scanner(System.in).nextLine();
                addDepartment(boPhan);
                nv.setBoPhan(boPhan);
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Bộ phận không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);


        do {
            try {
                System.out.print("Số ngày nghỉ: ");
                Scanner soNgayNghi = new Scanner(System.in);
                nv.setSoNgayNghi(soNgayNghi.nextInt());
                flag=true;
            } catch (Exception ex)
            {
                System.out.println("Nhập Số ngày nghỉ không đúng định dạng");
                flag=false;
            }
        }
        while (flag==false);


        dsNV.add(nv);
        System.out.println("Đã thêm mới thành công Quản lý: " + nv.getTenNV());
    }
    public static void addDepartment( String tenDepartment){
        String temp1 = StringUtils.removeAccent(tenDepartment);
        boolean exist=false;
        for(Department dp : dsBP)
        {
            String temp2= StringUtils.removeAccent(dp.tenBoPhan);
            if(temp2.equalsIgnoreCase(temp1)) {
                dp.setSoLuongNhanvien();
                exist=true;
                break;
            }
        }
        if(exist==false)
        {
            Department bp= new Department();
            bp.setTenBoPhan(tenDepartment);
            bp.setMaBoPhan(tenDepartment);
            bp.setSoLuongNhanvien();
            dsBP.add(bp);
        }
    }
    public static void hienThiBoPhan(){
        if(dsNV.size()==0) {thongBao();}
        else {
            System.out.println("Công ty hiện có " + dsBP.size() + " bộ phận như sau");
            for (Department dp : dsBP) {
                System.out.println(dp.toString());
            }
            choBanPhim();
        }
    }
    public static void hienThiNhanVienTheoBoPhan(){
        if(dsNV.size()==0) {thongBao();}
        else {
            System.out.println("DS nhân viên theo từng bộ phận:");
            for (Department dp : dsBP) {
                String boPhan = dp.toString();
                System.out.println(boPhan.toUpperCase());
                System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-15s%-15s\n","MÃ NV","TÊN NV", "CHỨC DANH","TUỔI","HỆ SỐ LƯƠNG","NGÀY VÀO LÀM","BỘ PHẬN","SỐ NGÀY NGHỈ");
                for (Staff nv : dsNV) {
                    if (nv.getBoPhan().equalsIgnoreCase(boPhan)) {
                        nv.displayInformation();
                    }
                }

            }
            choBanPhim();
        }
    }
    public static void themMoiNhanVien(){
        int tiepTucNhap;
        do {
            System.out.print("Bấm 1 dể nhập nhân viên thông thường, bấm 2 để nhập nhân viên cấp Quản lý. Tôi chọn ");
            int loaiNhanVien= new Scanner(System.in).nextInt();
            if( loaiNhanVien==1)  {nhapNhanVienThongThuong();}
            else nhapNhanVienQuanLy();
            System.out.print("Tiếp tục thêm mới ? 1 Tiếp tục; 2 Dừng ");
            tiepTucNhap = new Scanner(System.in).nextInt();
        } while (tiepTucNhap==1);
    }
    public static void timKiemNhanVien(){
        if(dsNV.size()==0) {thongBao();}
        else {
            System.out.print("Nhập tên hoặc mã nhân viên muốn tìm kiếm: ");
            Scanner sc = new Scanner(System.in);
            boolean flag = false;
            String keyWord = StringUtils.removeAccent(sc.nextLine());
            System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-25s%-15s\n","MÃ NV","TÊN NV", "CHỨC DANH","TUỔI","HỆ SỐ LƯƠNG","NGÀY VÀO LÀM","BỘ PHẬN","SỐ NGÀY NGHỈ");
            for (Staff nv : dsNV) {
                String tenNV = StringUtils.removeAccent(nv.getTenNV());
                if ((nv.maNV.equalsIgnoreCase(keyWord)) || (tenNV.equalsIgnoreCase(keyWord))) {
                    nv.displayInformation();
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Không tìm thấy nhân viên");
            }
            choBanPhim();
        }

    }
    public static void hienThiBangLuong(){
        if(dsNV.size()==0) {thongBao();}
        else {
            System.out.printf("%-12s%-20s%-15s\n","MÃ NV","TÊN NHÂN VIÊN","LƯƠNG");
            for (Staff nv : dsNV) {
                double luong = nv.calculateSalary();
                DecimalFormat dcf = new DecimalFormat("#.##");
                System.out.printf("%-12s%-20s%-15s\n",nv.getMaNV(),nv.getTenNV(),dcf.format(luong));
                BangLuong luongNV = new BangLuong();
                luongNV.setTenNV(nv.getTenNV());
                luongNV.setLuong(Double.toString(luong));
                blNV.add(luongNV);
            }
            choBanPhim();
        }
    }
    public static void hienThiBangLuongTangDan(){
        if(dsNV.size()==0) {thongBao();}
        else {
            Collections.sort(blNV);
            System.out.printf("%-20s%-15s\n","TÊN NHÂN VIÊN","LƯƠNG");
            for (BangLuong nv : blNV) {
                double luong = parseDouble(nv.getLuong());
                DecimalFormat dcf = new DecimalFormat("#.##");
                System.out.printf("%-20s%-15s\n",nv.getTenNV(),dcf.format(luong));
            }
            choBanPhim();
        }
    }
    public static void hienThiBangLuongGiamDan(){
        if(dsNV.size()==0) {thongBao();}
        else {
            Collections.sort(blNV);
            Collections.reverse(blNV);
            System.out.printf("%-20s%-15s\n","TÊN NHÂN VIÊN","LƯƠNG");
            for (BangLuong nv : blNV) {
                double luong = parseDouble(nv.getLuong());
                DecimalFormat dcf = new DecimalFormat("#.##");
                System.out.printf("%-20s%-15s\n",nv.getTenNV(),dcf.format(luong));
            }
            choBanPhim();
        }
    }
    public static void thongBao(){
        if(dsNV.size()==0) {
            System.out.println("Hiện chưa có thông tin nhân viên trong công ty");
            System.out.print("Bấm phím bất kỳ và phím Enter để quay về chức năng chính ");
            Scanner sc = new Scanner(System.in);
            String tieptuc = sc.next();
        }
    }
    public static void choBanPhim() {
        System.out.print("Bấm phím bất kỳ và phím Enter để quay về chức năng chính ");
        Scanner sc = new Scanner(System.in);
        String tiepTuc=sc.next();
    }


}
