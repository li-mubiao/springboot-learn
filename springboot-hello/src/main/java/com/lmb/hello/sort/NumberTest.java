package com.lmb.hello.sort;

import java.util.Arrays;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-27 15:23
 */
public class NumberTest {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1,3,4,2}, 6);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >i ; j--) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
                continue;
            }
        }
        return null;
    }
}