import java.util.HashMap;
import java.util.Map;

/**
 * @author Liang Junjie
 * @version 1.0.0
 * @since 2020/6/4 18:54
 */
public class Main {

    public int calc(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        return calc(triangle, 0, 0, 0);
    }

    private int calc(int[][] triangle, int pos, int level, int sum) {
        if (level == triangle.length) {
            return sum;
        }
        sum = sum + triangle[level][pos];
        return Math.min(calc(triangle, pos, level + 1, sum),
                calc(triangle, pos + 1, level + 1, sum));
    }

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(1, 20);
        map.put(2, 20);
        System.out.println(map);
    }

}
