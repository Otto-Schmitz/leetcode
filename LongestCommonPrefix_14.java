public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public String longestCommonPrefix_v1(String[] strs) {
        if (strs.length == 1) return strs[0];
        String result = "";

        for (int i = 0; i < strs.length - 1; i++) {
            StringBuilder temp = new StringBuilder();

            char[] current = strs[i].toCharArray();
            char[] after = strs[i + 1].toCharArray();

            for (int j = 0; j < Math.min(current.length, after.length); j++) {
                boolean isEqual = current[j] == after[j];

                if (!isEqual) {
                    if (j == 0) return "";
                    break;
                }
                temp.append(current[j]);
            }

            String tempStr = temp.toString();

            if ((!tempStr.isEmpty() && result.isEmpty()) || tempStr.length() < result.length()) result = tempStr;
        }

        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 lcp = new LongestCommonPrefix_14();
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(lcp.longestCommonPrefix(new String[]{"dog","racecar","car"}));

        System.out.println(lcp.longestCommonPrefix(new String[]{"a"})); // "a"
        System.out.println(lcp.longestCommonPrefix(new String[]{"", ""})); // ""
        System.out.println(lcp.longestCommonPrefix(new String[]{"", "abc"})); // ""
        System.out.println(lcp.longestCommonPrefix(new String[]{"abc", "abc"})); // "abc"
        System.out.println(lcp.longestCommonPrefix(new String[]{"abc", "ab", "a"})); // "a"
        System.out.println(lcp.longestCommonPrefix(new String[]{"prefix", "preach", "prevent"})); // "pre"
        System.out.println(lcp.longestCommonPrefix(new String[]{"interview", "internet", "internal"})); // "inter"
        System.out.println(lcp.longestCommonPrefix(new String[]{"same", "same", "same"})); // "same"
        System.out.println(lcp.longestCommonPrefix(new String[]{"different", "diff", "dif"})); // "dif"
        System.out.println(lcp.longestCommonPrefix(new String[]{"x", "y", "z"})); // ""
        System.out.println(lcp.longestCommonPrefix(new String[]{"aa", "aaa", "aaaa"})); // "aa"
        System.out.println(lcp.longestCommonPrefix(new String[]{"abab", "aba", "abc"})); // "ab"
        System.out.println(lcp.longestCommonPrefix(new String[]{"leetcode", "leet", "le"})); // "le"
        System.out.println(lcp.longestCommonPrefix(new String[]{"reflower", "flow", "flight"})); // ""
        System.out.println(lcp.longestCommonPrefix(new String[]{"c", "c"})); // "c"
        System.out.println(lcp.longestCommonPrefix(new String[]{"cir", "car"})); // "c"
        System.out.println(lcp.longestCommonPrefix(new String[]{"aaaaaaaaaa", "aaaaaaaaab"})); // "aaaaaaaaa"
        System.out.println(lcp.longestCommonPrefix(new String[]{"abcde", "abcxy", "abcz"})); // "abc"
        System.out.println(lcp.longestCommonPrefix(new String[]{"alone", "", "also"})); // ""
        System.out.println(lcp.longestCommonPrefix(new String[]{"mismatch", "mis", "mission"})); // "mis"


    }
}
