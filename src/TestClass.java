import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestClass {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        while (true){
            arrayList.add(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)).intern());
        }
    }


    public static void test1() {
        Instant start = Instant.now();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s = s + "a";
        }
        Instant end = Instant.now();
        s.intern();
        System.out.println(Duration.between(start, end));
    }

    private static void test2() {

        Instant start = Instant.now();
        StringBuilder s = new StringBuilder(100000);
        for (int i = 0; i < 100000; i++) {
            s.append("a");
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }
}
