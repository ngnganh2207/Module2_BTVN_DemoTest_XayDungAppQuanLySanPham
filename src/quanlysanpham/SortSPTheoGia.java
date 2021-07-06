package quanlysanpham;

import java.util.Comparator;

public class SortSPTheoGia implements Comparator<SanPham> {
    @Override
    public int compare(SanPham o1, SanPham o2) {
        if(o1.getPrice()>o2.getPrice()){
            return 1;
        }else if(o1.getPrice()<o2.getPrice()){
            return -1;
        }
        return 0;
    }
}
