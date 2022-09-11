public class Department {
    protected  String maBoPhan;
    protected String tenBoPhan;
    protected int soLuongNhanvien=0;
    public Department(){};

    public void setMaBoPhan(String tenBoPhan) {
     String temp=StringUtils.removeAccent(tenBoPhan);
        this.maBoPhan=temp.substring(0,3);
    }
    public String getMaBoPhan(){
        return maBoPhan;
    }
    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan=tenBoPhan;
    }
    public  String toString() {
        return this.tenBoPhan;
    }

    public void setSoLuongNhanvien() {
        this.soLuongNhanvien = this.soLuongNhanvien+1;
    }

    public int getSoLuongNhanvien(){
        return soLuongNhanvien;
    }
}
