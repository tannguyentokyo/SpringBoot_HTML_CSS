import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class zbaitap4 {
    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 2000, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 4000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5);


//        Bài 4: Danh sách nhân viên chưa đủ chuẩn nhưng... đầy tiềm năng
//        Yêu cầu:
//        Những người lương < 1000 nhưng tên bắt đầu bằng chữ 'T'
//        Sắp xếp theo tuổi tăng dần (sorted)
//                Trả về List<Employee>

        List<ZEmployee> resultList = employeeList
                .stream()
                .filter(i -> i.getSalary() <= 1000 && i.getName().startsWith("J"))
                .sorted((a, b) -> a.getAge() - b.getAge())
                .collect(Collectors.toList());
        System.out.println("Những nhân viên tên bắt đầu bằng chữ J và lương ít hơn 1000: ");
        for (ZEmployee employee : resultList) {
            System.out.println(employee.getName());
        }


    }
}
