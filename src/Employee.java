import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.lang.Double.parseDouble;

public class Employee extends Staff implements ICalculator{
    public int soGioLamThem;
    public double salary1;
    public Employee(){
        super();
    }

    public int getSoGioLamThem() {
        return soGioLamThem;
    }
    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem=soGioLamThem;
    }

    public void displayInformation()
    {
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-25s%-15s\n", this.maNV,this.tenNV,"Nhân viên",this.tuoiNV,this.heSoLuong,dateFormat.format(this.ngayVaoLam),this.boPhan,this.soNgayNghi);
    }
    public double  calculateSalary(){
        return  this.heSoLuong*3000000+this.soGioLamThem*200000;

    }
}
