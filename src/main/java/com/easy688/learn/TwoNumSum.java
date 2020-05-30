package com.easy688.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyuhui
 */
public class TwoNumSum {
    /**
     *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        twoSum2(nums,target);
    }

        /**
         *最简单的解法，冒泡排序;时间复杂度：O(n^2);空间复杂度：O(1)
         * @param nums
         * @param target
         * @return
         */
        public static void twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        System.out.println(i+":"+j);
                    }
                }
            }
        }

        /**
         * 两遍hash；时间复杂度：O(n)；空间复杂度：O(n)
         * @param nums
         * @param target
         */
        public static  void twoSum1(int[] nums, int target){
             //将数组装入map,利用map的key的不可重复性，将值设为key,下标设为value
            Map<Integer,Integer> map=new HashMap<>(16);
            for (int i = 0; i <nums.length ; i++) {
                map.put(nums[i],i);
            }
            //再次循环数组，将差值求出，然后利用map的key的不可重复性来判断差值是否存在，并且不是当前循环到的数组个体本身
            for (int j = 0; j<nums.length ; j++) {
                int complete=target-nums[j];
                if(map.containsKey(complete)&&map.get(complete)!=nums[j]){
                    System.out.println(map.get(complete)+":"+j);
                }
            }

        }

        /**
         * 一次哈希解法;时间复杂度：O(n);空间复杂度：O(n)
         * @param nums
         * @param target
         */
        public static void  twoSum2(int[] nums, int target){
            Map<Integer,Integer> map=new HashMap<>(16);
            for (int i = 0; i <nums.length ; i++) {
                int complete=target-nums[i];
                if(map.containsKey(complete)){
                    System.out.println(map.get(complete)+":"+i);
                }
                map.put(nums[i],i);
            }

        }


}
