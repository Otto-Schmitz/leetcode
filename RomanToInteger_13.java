import java.util.HashMap;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        HashMap<String, Integer> a = new HashMap<>();
        a.put("I", 1);
        a.put("V", 5);
        a.put("X", 10);
        a.put("L", 50);
        a.put("C", 100);
        a.put("D", 500);
        a.put("M", 1000);

        String[] nums = s.split("");
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = a.get(nums[i]);
            int next;

            try {
                next = a.get(nums[i + 1]);
            } catch(Exception e) {
                next = 0;
            }

            if (current >= next) {
                sum += current;
                continue;
            }

            sum += next - current;
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger_13 solution = new RomanToInteger_13();

        String[] testCases = {
            "III",      // 3
            "IV",       // 4
            "IX",       // 9
            "LVIII",    // 58
            "MCMXCIV",  // 1994
            "XL",       // 40
            "XC",       // 90
            "CD",       // 400
            "CM",       // 900
            "MMXXIV"    // 2024
        };

        for (String roman : testCases) {
            int result = solution.romanToInt(roman);
            System.out.println("Roman: " + roman + " -> Integer: " + result);
        }
    }
}
