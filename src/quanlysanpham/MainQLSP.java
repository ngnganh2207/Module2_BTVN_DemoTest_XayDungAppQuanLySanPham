package quanlysanpham;

import java.util.Scanner;

public class MainQLSP {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner= new Scanner(System.in);
        while (true){

            System.out.println("1. Xem toàn bộ danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm sản phẩm có giá MAX");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Exit");
            int choice=0;
            try{
                choice= Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Lựa chọn lại");
            }
            switch (choice){
                case 9:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Code, Name, Price, Amount, Describe");
                    for(SanPham sp: manager.list){
                        System.out.println(sp.show());
                    }
                    break;
                case 2:
                    SanPham sanPham=null;
                    try{
                        sanPham= manager.creat();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    manager.add(sanPham);
                    break;
                case 3:
                    System.out.println("Nhập mã code sản phẩm cần update thông tin");
                    String code3= scanner.nextLine();
                    manager.update(code3);
                    break;
                case 4:
                    System.out.println("Lưu ý: Tất cả mã code này sẽ bị xóa");
                    System.out.println("1. Tiếp tục xóa");
                    System.out.println("2. Bỏ qua việc xóa");
                    int choose= Integer.parseInt(scanner.nextLine());
                    if(choose==1){
                        System.out.println("Nhập mã code sản phẩm cần xóa");
                        String code4= scanner.nextLine();
                        manager.delete(code4);
                    }else {
                        return;
                    }
                    break;
                case 5:
                    manager.sort();
                    break;
                case 6:
                    manager.sortPrice();
                    System.out.println("Sản phâm giá đắt nhất là: "+"Mã code: "+ manager.list.get((manager.list.size())-1).getCode()+ "Tên sp: "+manager.list.get((manager.list.size())-1).getName()+" Giá: "+ manager.list.get((manager.list.size())-1).getPrice());
                    break;
            }
        }
    }
}
