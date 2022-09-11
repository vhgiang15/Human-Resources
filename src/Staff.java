import java.util.Date;

public abstract class Staff{
    protected String maNV;
    protected String tenNV;
    protected int tuoiNV;
    protected double heSoLuong;
    protected Date ngayVaoLam;
    protected String boPhan;
    protected int soNgayNghi;
    public abstract void displayInformation();
    public abstract double calculateSalary();
    public Staff() {
        super();
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTuoiNV( int tuoiNV) {
        this.tuoiNV= tuoiNV;

    }

    public int getTuoiNV() {

        return tuoiNV;
    }

    public void setHeSoLuong( double heSoLuong) {

        this.heSoLuong=heSoLuong;
    }

    public double getHeSoLuong() {

        return heSoLuong;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {

        this.ngayVaoLam= ngayVaoLam;
    }

    public Date getNgayVaoLam() {

        return ngayVaoLam;
    }
    public void setBoPhan (String boPhan) {

        this.boPhan= boPhan;
    }
    public String getBoPhan() {

        return boPhan;
    }
    public void setSoNgayNghi( int soNgayNghi) {

        this.soNgayNghi=soNgayNghi;
    }
    public int getSoNgayNghi() {

        return soNgayNghi;
    }

}
