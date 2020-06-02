package com.easy688.learn;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author easy688
 */
public class SubStrLength {
    public static void main(String[] args) {
        String str="abcabcdd";
        System.out.println(strSub(str));;
        System.out.println(lengthOfLongestSubstring1(str));

    }

    /**
     * 个人写法，感觉效率低点，先凑合，以后每天看一遍官方的，看看能不能理解了
     * @param s
     * @return
     */
    public static int  strSub(String s){
        Set<Character> set=null;
        //定义一个最大值变量
        int maxValue=0;
        for (int i = 0; i <s.length() ; i++) {
            //每次循环都new一个空set,用来存储比较，感觉这里效率低了
            set=new HashSet<>();
            //定义k等于当前下标,由于是新new了一个set,所以无需像官方那样将当前下标的前一个给移除掉，那样是为了每次都是以当前下标为起点
            int k=i;
            //定义一个临时最大值，用来记录
            int tempMaxValue=0;
            //while循环，从当前下标直到字符串尾
            while(k<s.length()){
                //如果不包含，即没有重复的就可以加入set集合，set集合不可重复,k++
                if(!set.contains(s.charAt(k))){
                    set.add(s.charAt(k));
                    k++;
                }else{
                    /**
                     * tempMaxValue设置为k到当前下标+1;比如abcabcbb，假设当前下标是0，即a,在下标为3时，
                     * 即a和下标0出现了相同，此时应该退出循环，因为以下标0为起点的已经结束了，此时最大长度为
                     * 3,即k-i也就是3-0
                     */
                    tempMaxValue=k-i;
                    break;
                }
            }
            //将最大值赋给maxValue，以便进行下一轮的比较
            maxValue=Math.max(maxValue,tempMaxValue);
        }
      return maxValue;
    }

    /**
     * 官方答案，还没有理解透彻
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 理解了官方的写法后自己的写法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s){
        Set<Character> set=new HashSet<>();
        int rk=0;
        int maxValue=0;
        for (int i = 0; i <s.length() ; i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(rk<s.length()&&!set.contains(s.charAt(rk))){
                set.add(s.charAt(rk));
                rk++;
            }
            maxValue=Math.max(maxValue,rk-i);
        }

        return maxValue;

    }

}
