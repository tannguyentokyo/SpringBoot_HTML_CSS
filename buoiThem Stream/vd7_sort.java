import java.util.List;
import java.util.stream.Collectors;

public class vd7_sort {
    public static void main(String[] args) {
        Users user1 = new Users("1", "user1");
        Users user2 = new Users("2", "user2");
        Users user3 = new Users("3", "user3");
        Users user4 = new Users("4", "user4");
        Users user5 = new Users("5", "user5");

        List<Users> users = List.of(user1, user2, user3, user4, user5);

//               List<Integer> sortedNumber3 = numbers.stream()
//                .sorted((a, b) -> b - a) // Giảm dần
//                .sorted((a, b) -> a - b) // Tăng dần
//                .collect(Collectors.toList());

        List<String> result = users
                .stream()
                .filter(i -> Integer.parseInt(i.getId()) >= 3)
                .sorted((a,b)->Integer.parseInt(b.getId())-Integer.parseInt(a.getId()))  //  b - a : giảm dần
                .map(Users::getName)            // cú pháp: <Tên class> :: <Tên hàm>
                .collect(Collectors.toList());
        for (String s : result) {
            System.out.println(s);
        }



    }
}
