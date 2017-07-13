package io.nnyy.Algorithms.Randomness;

import java.util.*;

public class FisherYatesShuffle
{
    public void shuffle(int[] nums)
    {
        if (nums == null || nums.length == 0) return;

        Random r = new Random();

        for (int i = nums.length - 1; i >= 0; i--)
        {
            int j = r.nextInt(i + 1);

            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
    }
}