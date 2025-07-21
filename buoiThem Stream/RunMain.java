import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RunMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result1 = numbers
                .stream()
                .filter((i) -> {
                    if (i % 3 == 0) {
                        return true;      // cách viết filer chuẩn, kết quả trả ra: 3.6.9
                    }
                    return false;
                })
                .filter((integer) -> {
                    return integer >= 6;    //cách viết ngắn gọn hơn bên trên
                })
                .collect(Collectors.toList());
        System.out.println(result1);

        System.out.println("--------------------------------------------------------------------------------------");

        List<String> result2 = numbers
                .stream()
                .filter((i) -> {
                    return i % 3 == 0;
                })
                .map((i) -> {
                    return "số chia hết cho 3:" + i;
                })
                .collect(Collectors.toList());
        for (String str : result2) {
            System.out.println(str);
        }
        System.out.println("--------------------------------------------------------------------------------------");

        Users user1 = new Users("1", "user1");
        Users user2 = new Users("2", "user test 2");
        Users user3 = new Users("3", "user3");
        Users user4 = new Users("4", "user test 4");
        Users user5 = new Users("5", "user test 5");

        List<Users> usersList = List.of(user1, user2, user3, user4, user5);
        List<String> result3 = usersList
                .stream()
                .filter((user) -> {
                    return user.name.contains("test");
                })
                .map((user) -> {

                    return "tester: " + user.name;
                })
                .collect(Collectors.toList());
        for (String str : result3) {
            System.out.println(str);
        }

        System.out.println("--------------------------------------------------------------------------------------");

        List<Integer> number1 = List.of(1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> result4 = number1
                .stream()
                .filter((i)->{
                    if (i % 2 == 0) {
                        return true;
                    }
                    return false;
                })
                .distinct()
                .map((i)->{
                    return "số chẵn ko trùng lặp: " + i;
                })
                .collect(Collectors.toList());
        System.out.println(result4);

        System.out.println("--------------------------------------------------------------------------------------");
        int sum = number1
                .stream()
                .filter((i)-> {
                    if(i%2!=0){
                        return true;
                    }
                    return false;
                })
                .distinct()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);






    }
}
