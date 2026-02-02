import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        if (n < 2) {
            return n;
        }

        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < n) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                int v = right - left;
                maxLength = v > maxLength ? v : maxLength;
                left++;
                set = new HashSet<>();
                right = left;
                continue;
            }
            set.add(c);
            right++;    
        }

        if (maxLength < right - left || maxLength == 0 && right != 0) {
            maxLength = right - left;
        }

        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 solution = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("aab"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }
}