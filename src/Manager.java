import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.lang.Double.parseDouble;

public class Manager extends  Staff implements ICalculator{
    protected String chucDanh;
    public String getChucDanh(){
        return chucDanh;
    }
    public void setChucDanh(String chucDanh) {
        this.chucDanh=chucDanh;
    }
    public Manager() {
        super();
    };
    public void displayInformation()
    {
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-25s%-15s\n", this.maNV,this.tenNV,this.chucDanh,this.tuoiNV,this.heSoLuong,dateFormat.format(this.ngayVaoLam),this.boPhan,this.soNgayNghi);
    };
    public double  calculateSalary(){
        double luong;
        if(this.chucDanh.equalsIgnoreCase("Business Leader")){
            luong= this.heSoLuong*5000000+ 8000000;
        } else if(this.chucDanh.equalsIgnoreCase("Project Leader"))
        {
            luong=this.heSoLuong*5000000+5000000;
        } else luong=this.heSoLuong*5000000+6000000;
        return luong;
    }

}
