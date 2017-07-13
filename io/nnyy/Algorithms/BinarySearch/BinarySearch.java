package io.nnyy.Algorithms.BinarySearch;

public class BinarySearch
{
    /**
     * The following method will search for the first occurrance of int {@paramref target}
     * in sorted array {@paramref nums}.  If {@paramref target} cannot be found, then it
     * will return the last number smaller than {@paramref target}, as long as it exists;
     * otherwise it will return -1.
     *
     * @param nums   A sorted int array.
     * @param target The int to search in {@paramref target}.
     */
    public int binarySearch(int[] nums, int target)
    {
        if (nums == null || nums.length == 0) return -1;

        int l = 0;
        int h = nums.length - 1;

        while (l <= h)
        {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target)
            {
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else h = mid - 1;
            }
            else if (nums[mid] > target) h = mid - 1;
            else l = mid + 1;
        }

        return h;
    }
}