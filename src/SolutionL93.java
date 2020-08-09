import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 93 复原IP地址 通过
 */
class SolutionL93 {

    private static final String ZERO = "0";

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>(16);
        compute(res, s, "", 0, 0);
        return res;
    }

    /**
     * 递归遍历所有可能的IP地址
     *
     * @param res          结果集
     * @param s            输入字符串
     * @param currentStr   当前字符串
     * @param currentIndex 当前遍历下标
     * @param currentNum   当前已有数字个数
     */
    private void compute(List<String> res, String s, String currentStr, int currentIndex, int currentNum) {
        int length = s.length();
        if (currentIndex > length) {
            return;
        }
        if (currentNum >= 4) {
            if (currentIndex == length) {
                res.add(currentStr);
            }
            return;
        }
        if (currentNum > 0) {
            currentStr = currentStr + '.';
        }
        if (currentIndex + 1 <= length) {
            String nextNum1 = s.substring(currentIndex, currentIndex + 1);
            if (checkNum(nextNum1)) {
                compute(res, s, currentStr + nextNum1, currentIndex + 1, currentNum + 1);
            }
        }
        if (currentIndex + 2 <= length) {
            String nextNum2 = s.substring(currentIndex, currentIndex + 2);
            if (checkNum(nextNum2)) {
                compute(res, s, currentStr + nextNum2, currentIndex + 2, currentNum + 1);
            }
        }
        if (currentIndex + 3 <= length) {
            String nextNum3 = s.substring(currentIndex, currentIndex + 3);
            if (checkNum(nextNum3)) {
                compute(res, s, currentStr + nextNum3, currentIndex + 3, currentNum + 1);
            }
        }
    }

    /**
     * 检查当前数字满足条件
     *
     * @param s 数字字符串
     * @return 是否符合
     */
    private boolean checkNum(String s) {
        if (s.startsWith(ZERO) && s.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }

}