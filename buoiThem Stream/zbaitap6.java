import java.util.Arrays;
import java.util.List;

public class zbaitap6 {
    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 1800, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 4000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        ZEmployee employee6 = new ZEmployee("John F", 30, 1800, "HR");
        ZEmployee employee7 = new ZEmployee("John G", 20, 1000, "test");

        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

//        Bài 6: Top 5 người lương cao nhất nhưng không thuộc phòng HR
//        Yêu cầu:
//        Bỏ qua người ở phòng HR
//        Sắp xếp theo lương giảm dần
//        Lấy 5 người đầu tiên (.limit(5))
//        Trả về tên của họ

        List<String> result = employeeList
                .stream()
                .filter(i -> !i.getDepartment().equals("HR"))
                .limit(5)
                .sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))
                .map(ZEmployee::getName)
                .toList();

        System.out.println(result);

    }
}
