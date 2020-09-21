package com.aituigu.recursion;

/**
 * @author aaa
 */
public class MiGong {

    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int [][] map = new int[8][7];
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 上下全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板 1 表示挡板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1,1);
        System.out.println("小球走过，地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    // 说明
    // 1. map 表示地图
    // 2. i，j 表示从地图的哪个位置开始出发(1,1)
    // 3. 如果小清能到map[6][5] 位置，则说明通路找到。
    // 4. 约定： 当map[i][j] 为 0 表示该点没有走过的当为 1 表示墙，2 表示通路可以走，3 表示该点已经走过，但是走不通
    // 5. 在走迷宫时，需要确定一个策略 下-->右-->上-->左

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            // 如果当前这个点还没走过
            if (map[i][j] == 0) {
                // 按照策略 下-->右-->上-->左 走
                // 假定该点是可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 说明该点是走不通的，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // 如果map[i][j] != 0, 可能是1，2，3
                return false;
            }
        }
    }

}