public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 srsa = new SearchInRotatedSortedArray_33();

        System.out.println(srsa.search(new int[]{4,5,6,7,0,1,2}, 6));
        System.out.println(srsa.search(new int[]{0, 1, 2, 3}, 2));
        System.out.println(srsa.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(srsa.search(new int[]{2,4,5,6,7,0,1}, 0));

    }
}
