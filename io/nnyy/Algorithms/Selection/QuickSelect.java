package io.nnyy.Algorithms.Selection;

public class QuickSelect
{
    /**
     * @param nums Unsorted array
     * @param k    k-th smallest element to return
     * @return k-th smallest element
     */
    public int quickSelect(int[] nums, int k)
    {
        // Boundary check omitted

        int i = 0;
        int j = nums.length - 1;

        while (true)
        {
            int pos = partition(nums, i, j);

            if (pos == k - 1) return nums[pos];
            else if (pos < k - 1) i = pos + 1;
            else j = pos - 1;
        }
    }

    private int partition(int[] nums, int i, int j)
    {
        int pivot = nums[j];

        int k = j - 1;
        while (i <= k)
        {
            if (nums[i] <= pivot) i++;
            else
            {
                swap(nums, i, k);
                k--;
            }
        }

        swap(nums, i, j);
        return i;
    }

    private void swap(int[] nums, int i, int j)
    {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}