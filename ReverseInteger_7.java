public class ReverseInteger_7 {
    public int reverse(int x) {
        long result = 0;
        
        while (x!=0) { 
            result += x%10;
            result *= 10;
            x /= 10;
        }

        result /= 10;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return x<0 ? (int) result * -1 : (int) result;
    }

    public static void main(String[] args) {
        ReverseInteger_7 reverseInteger = new ReverseInteger_7();

//        System.out.println(reverseInteger.reverse(9646324351));
        System.out.println(reverseInteger.reverse(-123));
    }
}
