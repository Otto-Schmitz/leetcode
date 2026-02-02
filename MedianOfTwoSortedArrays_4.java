import java.lang.reflect.Array;
import java.util.Arrays;

public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);

        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (double) (nums[mid - 1] + nums[mid]) / 2;
        } else {
            return nums[mid];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_4 solution = new MedianOfTwoSortedArrays_4();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}