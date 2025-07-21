import java.util.List;

public class zbaitap9 {
    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 1800, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 5000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        ZEmployee employee6 = new ZEmployee("John F", 30, 1800, "HR");
        ZEmployee employee7 = new ZEmployee("John G", 20, 1000, "test");

        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

//        Bài 9: Có phải toàn công ty đang bị trả lương dưới chuẩn?
//                Yêu cầu:
//        Nếu allMatch(p -> p.salary < 5000) thì in cảnh báo
//        Ngược lại thì in ra tên 3 người lương cao nhất (sorted)

        boolean check = employeeList
                .stream()
                .allMatch(i -> i.getSalary() < 5000);

        if(check){
            System.out.println("trả lương quá tệ");
        }else {
            List<String>result=employeeList
                    .stream()
                    .sorted((a,b)->(int)(b.getSalary()-a.getSalary()))
                    .limit(3)
                    .map(ZEmployee::getName)
                    .toList();
            System.out.println(result);
        }
    }
}
