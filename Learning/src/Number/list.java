package Number;

import java.util.Arrays;
import java.util.List;

public class list {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4);
        l.forEach(System.out::println);
        System.out.println(l);
    }
}
