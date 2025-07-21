import java.util.List;

public class zbaitap8 {
    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 1800, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 4000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        ZEmployee employee6 = new ZEmployee("John F", 30, 1800, "HR");
        ZEmployee employee7 = new ZEmployee("John G", 20, 1000, "test");

        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

//        Bài 8: Danh sách nhân viên có lương trùng nhau (xếp theo tên)
//        Yêu cầu:
//        Lọc ra những người có lương trùng với ít nhất 1 người khác
//        Sắp xếp theo tên tăng dần
//        Trả về List<String> chứa tên

        List<String>result=employeeList
                .stream()
                .filter(i->employeeList
                        .stream()
                        .anyMatch(j->j.getSalary()==i.getSalary()&&j!=i))
                .sorted((a,b)->a.getName().compareToIgnoreCase(b.getName()))
                .map(ZEmployee::getName)
                .toList();
        System.out.println(result);




    }
}
