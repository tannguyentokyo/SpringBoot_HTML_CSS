import java.util.List;

public class zbaitap10 {
    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 1800, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 5000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        ZEmployee employee6 = new ZEmployee("John F", 30, 1800, "HR");
        ZEmployee employee7 = new ZEmployee("John G", 20, 1000, "test");

        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

//        Bài 10: Danh sách các phòng ban có người tên bắt đầu bằng 'L' có lương trên 3000
//        Yêu cầu:
//        Từ List<Employee>:
//
//
//        Lọc người có tên bắt đầu 'J' và lương > 3000
//        Lấy ra danh sách phòng ban duy nhất (không trùng)

        List<String> result = employeeList
                .stream()
                .filter(i -> i.getName().startsWith("J") && i.getSalary() > 3000)
                .map(ZEmployee::getDepartment)
                .distinct()
                .toList();
        System.out.println(result);

    }
}
