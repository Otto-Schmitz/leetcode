import java.util.HashMap;
import java.util.Set;

public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        HashMap<Integer, String> a = new HashMap<>();
        a.put(1, "I");
        a.put(5, "V");
        a.put(10, "X");
        a.put(50, "L");
        a.put(100, "C");
        a.put(500, "D");
        a.put(1000, "M");

        HashMap<String, Integer> b = new HashMap<>();
        b.put("I", 1);
        b.put("V", 5);
        b.put("X", 10);
        b.put("L", 50);
        b.put("C", 100);
        b.put("D", 500);
        b.put("M", 1000);

        int t = num / 1000;
        num = num % 1000;
        int h = num / 100;
        num = num % 100;
        int d = num / 10;
        num %= 10;

        System.out.println("Milhares: " + t);
        System.out.println("Centenas: " + h);
        System.out.println("Dezenas: " + d);
        System.out.println("Unidades: " + num);

        // System.out.println(num);
        // Para repetir uma String em Java, use o método repeat() a partir do Java 11
        // System.out.println("M".repeat(3));

        String s = "";

        if (t > 0) {
            s = "M".repeat(t);
        }
        System.out.println(s);
        if (h > 0) {
            int full = h * 100;
            while(true) {
                String min = firstLess(a, full);
                s += min;
                int q = b.get(min);
                full -= q;

                if (full == 0) break;
            }
        }

        if (d > 0) {
            int full = d * 10;
            while(true) {
                String min = firstLess(a, full);
                s += min;
                int q = b.get(min);
                full -= q;

                if (full == 0) break;
            }
        }

        System.out.println(s);

        return null;
    }

    public String firstLess(HashMap<Integer, String> a, int num) {
        if (a.containsKey(num)) return a.get(num);

        Set<Integer> keys = a.keySet();

        Integer min = keys.stream()
            .filter(k -> k < num)
            .max(Integer::compareTo)
            .orElse(null);

        System.out.println(num);

        return a.get(min);
    }

    public static void main(String[] args) {
        // caso de teste para intToRoman
        IntegerToRoman_12 solution = new IntegerToRoman_12();
        int num = 1749;
        String roman = solution.intToRoman(num);
        System.out.println("Número: " + num + " -> Romano: " + roman);
    }
}