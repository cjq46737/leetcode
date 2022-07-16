/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.longestsubstring
 * @className com.cjq.leetcode.algorithm.longestsubstring.CalLongestSubstring
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.longestsubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * CalLongestSubstring
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * abcabcbb =3,
 * @author chenjunqi
 * @date 2022年05月16日 下午10:04
 * @version 3.0.0
 */
public class CalLongestSubstring {

    public static void main(String[] args) {
        // 2
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));

        // 3
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));

        // 3
        String s2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));

        // 4
        String s3 = "jbpnbwwd";
        System.out.println(lengthOfLongestSubstring(s3));
    }

    /**
     * CalLongestSubstring
     * @description 真正的计算逻辑
     * @param s 给点字符串
     * @return 不重复字串最长长度
     * @author chenjunqi
     * @date 2022/5/16 下午10:05
     * @version 3.0.0
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (set.contains(temp)) {
                    maxLength = Math.max(maxLength, set.size());
                    set.clear();
                    break;
                } else {
                    set.add(temp);
                    maxLength = Math.max(maxLength, set.size());
                }
            }
        }
        return maxLength;
    }
}
