public class Zigzag_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        int firstLine = n / numRows;
        int lastLine = firstLine - 1;
        int rest = n - (firstLine + lastLine);

        System.out.println("firstLine: " + firstLine);
        System.out.println("lastLine: " + lastLine);
        System.out.println("rest: " + rest);

        int temp = Math.ceilDiv(rest, numRows - 2);

        System.out.println("temp: " + temp);


        
        return null;
    }

    public static void main(String[] args) {
        Zigzag_6 solution = new Zigzag_6();
        String s = "PAYPALISHIRING";
        System.out.println(s.length());
        int numRows = 3;
        System.out.println(solution.convert(s, numRows));
    }
}

// xxx  xx x x x x xx
// PAY PAL ISH IRI NG

// PAHN
// ALIG
// YII
// PSR

// PAY P ALI S HIR I NG


// P   A   H   N
// A P L S I I G
// Y   I   R

// P     I    N
// A   L S  I G
// Y A   H R
// P     I

// XX      X       X
// PAYP AL ISHI RI NG

// 5 DE ESPACO
// P I N
// A

// PAYPALISHIRING
// 3x7 = 21
// 7


