import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zbaitap1 {

    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 2000, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 4000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5);


//        Bài 1: Danh sách nhân viên "trẻ – giàu – tiềm năng"
//        Yêu cầu:
//        Từ danh sách List<Employee>, hãy lọc ra những người:
//        Tuổi dưới 30 (filter)
//                Lương trên 2000
//        Sắp xếp theo lương giảm dần (sorted)
//                Trả về danh sách tên nhân viên (map -> collect List<String>)

        List<String> nameList1 = employeeList
                .stream()
                .filter((i) -> {
                    if (i.getAge() <= 30 && i.getSalary() >= 2000) {
                        return true;
                    }
                    return false;
                })
                .sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))  //sao lại phải viết (int)
                .map((i) -> {

                    return i.getName();
                })
                .collect(Collectors.toList());

        System.out.println("Những nhân viên dưới 30 tuổi và lương trên 2000 theo thứ tự lương giảm dần: ");
        for (String name : nameList1) {
            System.out.println(name);
        }


        System.out.println("------------------------------------------------------------------------");

//        Bài 2: Kiểm tra tính đa dạng tuổi
//        Yêu cầu:
//        Kiểm tra xem trong công ty có:
//        Tất cả mọi người > 18 tuổi (allMatch)
//        Có ít nhất 1 người < 22 tuổi (anyMatch)
//        Không ai > 65 tuổi (noneMatch)
//        Trả về true nếu cả 3 điều kiện đều thỏa.

        int check = 0;

        boolean ageCheck18 = employeeList
                .stream()
                .allMatch(i -> i.getAge() >= 18);

        if (ageCheck18) {
            System.out.println("tất cả nhân viên đều trên 18 tuổi");
        } else {
            check = 1;
            System.out.println("có nhân viên dưới 18 tuổi");
        }

        boolean ageCheck22 = employeeList
                .stream()
                .anyMatch(i -> i.getAge() < 22);

        if (ageCheck22) {
            System.out.println("có nhân viên dưới 22 tuổi");
        } else {
            check = 1;
            System.out.println("ko có nhân viên nào dưới 22 tuổi");
        }

        boolean ageCheck65 = employeeList
                .stream()
                .noneMatch(i -> i.getAge() > 65);
        if (ageCheck65) {
            System.out.println("ko có nhân viên trên 65 tuổi");
        } else {
            check = 1;
            System.out.println("có nhân viên trên 65 tuổi");
        }

        if (check == 1) {
            System.out.println("cty ko phù hợp: False");
        } else {
            System.out.println("cty phù hợp: True");
        }

        System.out.println("------------------------------------------------------------------------");

//        Bài 3: Tổng lương phòng IT – chỉ người có năng lực
//        Yêu cầu:
//        Tính tổng lương (sum) của các nhân viên:
//        Thuộc phòng dev (filter)
//        Tuổi < 35
//        Tên dài hơn 3 ký tự (filter)
//                Dùng mapToDouble để cộng lương


        double result3 = employeeList
                .stream()
                .filter(i -> i.getAge() <= 35 && i.getDepartment().equals("dev") && i.getName().length() >= 3)
                .limit(2)
                .mapToDouble(ZEmployee::getSalary)
                .sum();

        System.out.println(result3);

    String a="abC";
    String b="Abcs";
        System.out.println(b.compareToIgnoreCase(a));
    }
}
