package quanlysanpham;

import java.util.Comparator;

public class SortSanPham implements Comparator<SanPham> {
    @Override
    public int compare(SanPham o1, SanPham o2) {
        return o1.getCode().compareTo(o2.getCode());
    }
}
