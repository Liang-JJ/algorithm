/**
 * LeetCode 415. 字符串相加
 * 通过
 */
class SolutionL415 {
    public String addStrings(String num1, String num2) {
        String longer, shorter;
        if (num1.length() > num2.length()) {
            longer = num1;
            shorter = num2;
        } else {
            longer = num2;
            shorter = num1;
        }
        int longerLength = longer.length();
        int shorterLength = shorter.length();
        int resLength = longerLength + 1;
        char[] resChars = new char[longer.length() + 1];
        int increase = 0;

        for (int i = 0; i < longerLength; i++) {
            int a = longer.charAt(longerLength - i - 1) - '0';
            int b = shorterLength > i ? shorter.charAt(shorterLength - i - 1) - '0' : 0;
            int temp = a + b + increase;
            increase = temp / 10;
            resChars[resLength - i - 1] = (char) (temp % 10 + '0');
        }
        if (increase == 1) {
            resChars[0] = '1';
            return new String(resChars);
        } else {
            return new String(resChars, 1, longerLength);
        }

    }
}