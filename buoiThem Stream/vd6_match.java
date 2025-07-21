import java.util.List;

public class vd6_match {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        boolean result1 = numbers
                .stream()
                .anyMatch((i) -> {
                    if (i >= 8) {
                        return true;
                    }
                    return false;
                });

        System.out.println(result1);


        boolean result2 = numbers
                .stream()
                .allMatch(i -> i >= 8);
        System.out.println(result2);


        boolean result3 = numbers
                .stream()
                .noneMatch(i -> i >= 8);
        System.out.println(result3);


    }
}
