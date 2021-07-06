package quanlysanpham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    List<SanPham> list= new ArrayList<>();
    Scanner scanner= new Scanner(System.in);
    File sanPham= new File("SanPham.csv");
    String tieude= "Code, Name, Price, Amount, Describe";
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;
    public void add(SanPham sanPham){
        list.add(sanPham);
    }
    public SanPham creat() throws Exception{
        //String code, String name, double price, int amount, String describe
        System.out.println("Nhập mã code của sản phẩm");
        String code= scanner.nextLine();
        System.out.println("Nhập name của sản phẩm");
        String name= scanner.nextLine();
        double price = getPrice();
        int amount = getAmount();
        System.out.println("Nhập mô tả của sản phầm");
        String describe= scanner.nextLine();
        return new SanPham(code,name,price,amount,describe);
    }

    private int getAmount() {
        while (true){
            try{
                System.out.println("Nhập số lượng của sản phẩm");
                int amount= Integer.parseInt(scanner.nextLine());
                return amount;
            }catch (Exception e){
                System.out.println("Vui lòng nhập lại số lượng sản phẩm!");
            }
        }

    }

    private double getPrice() {
        while(true){
            try{
                System.out.println("Nhập giá của sản phẩm");
                double price= Double.parseDouble(scanner.nextLine());
                return price;
            }catch (Exception e){
                System.out.println("Vui long nhập lại giá sản phẩm!");
            }
        }

    }
    public void update(String code){
        for(int i=0; i<list.size();i--){
            if(list.get(i).getCode().equals(code)){
                try {
                    list.set(i,creat());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    public void delete(String code){
        for (int i=0; i< list.size();i--){
            if (list.get(i).getCode().equals(code)){
                list.remove(i);
                i--;
            }
        }
    }
    public void sort(){
        SortSanPham sortSanPham= new SortSanPham();
        list.sort(sortSanPham);
    }
    public void sortPrice(){
        SortSPTheoGia sortSPTheoGia=new SortSPTheoGia();
        list.sort(sortSPTheoGia);
    }
    public void writeFile(){
        try {
            FileWriter fileWriter=new FileWriter(sanPham);
            bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(tieude);
            for(SanPham sp: list){
                bufferedWriter.newLine();
                bufferedWriter.write(sp.show());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<SanPham> readFile(){
        ArrayList<SanPham> list= new ArrayList<>();
        try {
            FileReader fileReader= new FileReader(sanPham);
            bufferedReader= new BufferedReader(fileReader);
            String line= bufferedReader.readLine();
            while ((line=bufferedReader.readLine())!=null){
                //String code, String name, double price, int amount, String describe
                String[] arrStr=line.split(",");
                list.add(new SanPham(arrStr[0],arrStr[1],Double.parseDouble(arrStr[2]),Integer.parseInt(arrStr[3]),arrStr[4]));
                //System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
