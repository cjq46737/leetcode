/*
 * @projectName leetcode
 * @package com.cjq.leetcode.algorithm.dp
 * @className com.cjq.leetcode.algorithm.dp.ShortestPath
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.leetcode.algorithm.dp;

import java.util.List;

/**
 * ShortestPath
 * @description 动态规划计算最短路径
 * @author chenjunqi
 * @date 2022年05月14日 下午2:02
 * @version 3.0.0
 */
public class ShortestPath {

    /**
     * ShortestPath
     * @description 计算从上到小的最短路径。动态规划
     * @param triangle 全路径
     * @return 最短路径
     * @author chenjunqi
     * @date 2022/5/14 下午2:09
     * @version 3.0.0
     */
    public static int getShortestPath(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            List<Integer> integers = triangle.get(0);
            int count = integers.get(0);
            for (int i = 1; i < integers.size(); i++) {
                if (integers.get(i) < count) {
                    count = integers.get(i);
                }
            }
            return count;
        }
        List<Integer> temp = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> values = triangle.get(i);
            for (int j = 0; j < values.size(); j++) {
                temp.set(j, values.get(j) + Math.min(temp.get(j), temp.get(j + 1)));
            }
        }
        return temp.get(0);
    }
}
