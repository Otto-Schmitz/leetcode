

public class StringToIntegerAtoi_8 {
    public int myAtoi(String s) {
        s = s.strip();
        char[] a = s.toCharArray();

        boolean isNegative = false;
        String result = "0";
        
        for (int i = 0; i < a.length; i++) {
            char tmp = a[i];

            if (i == 0 && tmp == '+' || tmp == '-') {
                if (tmp == '-') isNegative = true;
                continue;
            }

            if (!String.valueOf(tmp).matches("\\d")) {
                break;
            }
            result += tmp;
        }

        long finalResult = Long.parseLong(result);

        if (finalResult > Integer.MAX_VALUE || finalResult < Integer.MIN_VALUE) return isNegative ? (int)Integer.MIN_VALUE : (int)Integer.MAX_VALUE;

        return isNegative ? (int)finalResult * -1 : (int)finalResult;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi_8 stringToIntegerAtoi_8 = new StringToIntegerAtoi_8();
        System.out.println(stringToIntegerAtoi_8.myAtoi("+42")); // 42
        System.out.println(stringToIntegerAtoi_8.myAtoi("-042")); // -42
        System.out.println(stringToIntegerAtoi_8.myAtoi("   -042")); // -42
        System.out.println(stringToIntegerAtoi_8.myAtoi("1337c0d3")); // 1337
        System.out.println(stringToIntegerAtoi_8.myAtoi("0-1")); // 0
        System.out.println(stringToIntegerAtoi_8.myAtoi("words and 987")); // 0
        System.out.println(stringToIntegerAtoi_8.myAtoi(".42.")); // 0
        System.out.println(stringToIntegerAtoi_8.myAtoi("42.")); // 42
        System.out.println(stringToIntegerAtoi_8.myAtoi("4.2")); // 4
        System.out.println(stringToIntegerAtoi_8.myAtoi("-91283472332")); // -2147483648
        System.out.println(stringToIntegerAtoi_8.myAtoi("+-")); // 0 "
        System.out.println(stringToIntegerAtoi_8.myAtoi("+0 123")); // 0
        System.out.println(stringToIntegerAtoi_8.myAtoi("+1")); // 1
        System.out.println(stringToIntegerAtoi_8.myAtoi("4193 with words")); // 4193
        System.out.println(stringToIntegerAtoi_8.myAtoi("20000000000000000000"));
        
    }
}
