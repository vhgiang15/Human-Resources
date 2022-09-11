import static java.lang.Double.parseDouble;
public class BangLuong implements  Comparable<BangLuong> {
    protected String tenNV;
    protected String luong;

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;

    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getLuong() {
        return luong;
    }

    public String getTenNV() {
        return tenNV;
    }
    public BangLuong() {
        super();
    }

    @Override
    public int compareTo(BangLuong o) {
        if(parseDouble(this.luong)>parseDouble(o.luong)) {return 1;}
        else  if(parseDouble(this.luong)<parseDouble(o.luong)) {return -1;}
        else  {return 0;}

    }
}
