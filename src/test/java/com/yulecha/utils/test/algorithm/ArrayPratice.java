package com.yulecha.utils.test.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * @ClassName：ArrayPratice
 * @Description：初级算法-数组
 * @Author：MaRui
 * @Date：2020/10/21 15:48
 * @Version 1.0
 **/
public class ArrayPratice {

    /**
     * 删除排序数组中的重复项
     * @return 返回数组长度
     */
    @Test
    public void removeDuplicates() {
        int[] nums = {1, 1, 2};
        int back = 0;
        for (int front = 1; front < nums.length; front++) {
            if (nums[back] != nums[front]) {
                back++;
                nums[back] = nums[front];
            }
        }
//        return back + 1;
    }

    /**
     * 买卖股票的最佳时机
     */
    @Test
    public void maxProfit() {
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                count += prices[i] - prices[i-1];
            }
        }
        System.out.println(count);
    }

    /**
     * 旋转数组
     */
    @Test
    public void rotate() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        for (int step = 1; step <= k; step++) {
            for (int start = 1; start < nums.length; start++) {
                int temp = nums[0];
                nums[0] = nums[start];
                nums[start] = temp;
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
    }

    /**
     *存在重复元素
     */
    public void containsDuplicate() {
        int[] nums = {1,2,3,1};
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
//                return true;
            }
        }
//        return false;
    }

    /**
     * 只出现一次的数字
     */
    @Test
    public void singleNumber() {
        int[] nums = {4,1,2,1,2};
        int index = nums.length-1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                index = i;
                break;
            }
            i++;
        }
//        return nums[index];
    }


    /**
     * 两个数组的交集
     */
    @Test
    public void intersect() {
        /*int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int index = 0;
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                result[index++] = i;
            }
        }

        return result;*/
    }
}
