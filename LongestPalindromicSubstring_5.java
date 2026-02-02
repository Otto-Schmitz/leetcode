public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    int pointer = Math.round(l / 2);

                    while (pointer > 0) {
                        if (s.charAt(i+pointer-1) == s.charAt(j-pointer+1)) {
                            dp[i][j] = 1;
                            pointer--;
                        }
                        else {
                            break;
                        }
                    }

                    if (l > maxLength && pointer == 0) {
                        start = i;
                        maxLength = l;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 solution = new LongestPalindromicSubstring_5();
        String s = "abbcccba";
        System.out.println(solution.longestPalindrome(s));
    }
}
