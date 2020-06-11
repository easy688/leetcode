package com.easy688.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @author easy688
 */
public class ReverseMaxSub {
    public static  String longestPalindrome(String s) {
        if(s==null||s.equalsIgnoreCase("")){
            return null;
        }
        Map<Integer,String> map=new HashMap<>(16);
        for (int i = 0; i <s.length() ; i++) {
            int k=i;
            while(k<s.length()){
                String subStr=s.substring(i,k+1);
                String rSubStr=new StringBuilder(subStr).reverse().toString();
                if(s.charAt(i)==s.charAt(k)&&subStr.equalsIgnoreCase(rSubStr)){
                    map.put(k-i+1,subStr);
                }
                k++;
            }
        }
        Set<Integer> set=map.keySet();
        Object[] arrs=set.toArray();
        Arrays.sort(arrs);
        return map.get(arrs[arrs.length-1]);

    }

    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome(s));
    }
}
