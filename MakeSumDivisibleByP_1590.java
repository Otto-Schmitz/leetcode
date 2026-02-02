import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MakeSumDivisibleByP_1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sumTotal = Arrays.stream(nums).mapToLong(x -> (long) x).sum();
        long remainder = sumTotal % p;

        if (remainder == 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            long numMod = ((long) nums[i]) % p;
            if (numMod == remainder) {
                long tempSum = sumTotal - nums[i];
                if (tempSum % p == 0) {
                    return 1;
                }
            }
        }

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 2; i < n; i++) {
            List<List<Integer>> listOfLists = new ArrayList<>();
            for (int j = 0; j < n; j += i) {
                int end = Math.min(j + i, n);
                List<Integer> subList = list.subList(j, end);

                if (subList.size() != i) {
                    subList = list.subList(j-(i-1), end);
                }
                
                listOfLists.add(subList);
            }
            for (List<Integer> subList : listOfLists) {
                long tempSum = subList.stream().mapToLong(Integer::longValue).sum();
                // System.out.println("tempSum: " + tempSum);
                if (tempSum % p == remainder) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MakeSumDivisibleByP_1590 solution = new MakeSumDivisibleByP_1590();
        // int[] nums = {1000000000,1000000000,1000000000};
        // int p = 3;
        // int[] nums = {7,7,2,5,9,2,6};
        // int p = 5;
        int[] nums = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        int p = 26;
        System.out.println(solution.minSubarray(nums, p));
    }
}