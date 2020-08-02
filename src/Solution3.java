import java.util.*;

class Solution3 {

    private static final Map<Character, String> ALPHA_MAP = new HashMap<>();

    static {
        ALPHA_MAP.put('2', "abc");
        ALPHA_MAP.put('3', "def");
        ALPHA_MAP.put('4', "ghi");
        ALPHA_MAP.put('5', "jkl");
        ALPHA_MAP.put('6', "mno");
        ALPHA_MAP.put('7', "pqrs");
        ALPHA_MAP.put('8', "tuv");
        ALPHA_MAP.put('9', "wxyz");
    }

    public List<String> calc(String s) {

        if (s == null || "".equals(s)) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>(16);
        calc2(s, "", 0, res);
        return res;
    }

    private void calc2(String s, String current, int pos, List<String> res) {
        if (s.length() == pos) {
            res.add(current);
            return;
        }
        char[] chars = ALPHA_MAP.get(s.charAt(pos)).toCharArray();
        for (char aChar : chars) {
            calc2(s, current + aChar, pos + 1, res);
        }
    }


}