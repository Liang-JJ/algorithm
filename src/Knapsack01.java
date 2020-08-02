/**
 * @author Liang Junjie
 * @version 1.0.0
 * @since 2020/5/18 10:51
 */
public class Knapsack01 {
    public int knapsack01(int[] w, int[] v, int c) {
        // TODO 判断w.lenght 和 v.length
        int n = w.length;
        if (n == 0) {
            return 0;
        }
        Integer[] mem = new Integer[c + 1];
        for (int j = 0; j <= c; j++) {
            mem[j] = w[0] > j ? 0 : v[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= 0; j--) {
                if (j >= w[i]) {
                    mem[j] = Math.max(mem[j], mem[j - w[i]] + v[i]);
                } else {
                    break;
                }
            }
        }
        return mem[c];
    }
}
