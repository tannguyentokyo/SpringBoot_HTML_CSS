import java.util.List;
import java.util.stream.Collectors;

public class zbaitap5 {
    public static void main(String[] args) {
        ZEmployee employee1 = new ZEmployee("John A", 30, 1800, "dev");
        ZEmployee employee2 = new ZEmployee("John B", 20, 1000, "test");
        ZEmployee employee3 = new ZEmployee("John C", 18, 1200, "dev");
        ZEmployee employee4 = new ZEmployee("John D", 35, 4000, "test");
        ZEmployee employee5 = new ZEmployee("John E", 25, 3000, "dev");
        List<ZEmployee> employeeList = List.of(employee1, employee2, employee3, employee4, employee5);

//        Bài 5: Có nhân viên nào giỏi nhưng bị trả lương thấp không?
//                Yêu cầu:
//        Giả sử một nhân viên giỏi là người có:
//        Tuổi > 25
//        Tên chứa chữ "J"
//        Nhưng lương < 1500
//        (?) Hãy kiểm tra xem có ai như vậy không?


        List<ZEmployee> resultList = employeeList
                .stream()
                .filter((i) -> {
                    if (i.getName().contains("J") && i.getAge() > 25 && i.getSalary() < 2000) {
                        return true;
                    }
                    return false;
                })
                .toList();
        if(!resultList.isEmpty()) {
            System.out.println("Nhân viên tên có chữ J, tuổi > 25 và có lương thấp hơn 1500 là");
            for(ZEmployee employee : resultList) {
                System.out.println(employee.getName());
            }
        }else {
            System.out.println("ko có Nhân viên nào tên có chữ J, tuổi > 25 và có lương thấp hơn 1500 là");
        }

    }
}
