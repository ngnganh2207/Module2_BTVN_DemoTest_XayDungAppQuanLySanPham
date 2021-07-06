package quanlysanpham;

public class SanPham {
    private String code;
    private String name;
    private double price;
    private int amount;
    private String describe;

    public SanPham() {
    }

    public SanPham(String code, String name, double price, int amount, String describe) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String show() {
        return code+", " + name+ ", " + price +", " + amount+", "+ describe;
    }
}
