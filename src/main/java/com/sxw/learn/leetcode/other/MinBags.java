package com.sxw.learn.leetcode.other;

/**
 * [题目]:小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个 每袋的包装包装不可拆分。
 * 可是小虎现在只想购买恰好n个苹果，小虎想购买尽 量少的袋数方便携带。如果不能购买恰好n个苹果，小虎将不会购买。
 * 输入一个 整数n，表示小虎想购买的个苹果，返回最小使用多少袋子。如果无论如何都不 能正好装下，返回-1
 *
 * https://www.cnblogs.com/Gao-yubo/p/15627059.html
 */
public class MinBags {
     /**
      * 袋子分为8，6两种，想让袋子数量最少，优先选择8
      * 所以先m/8得出用几个8袋子，然后计算剩余的苹果数
      * 查看剩余的苹果树是否可以被6整除，如果可以总袋数就等于bag8 + bag6
      * 不可以就将8袋子所用数量-1，再计算剩余苹果树然后判断bag6,
      * 当bag8减到0或者剩余苹果>24时，都不用继续了（因为>24肯定优先考虑bag8）
      */
    public static int minBags(int n){
        if ((n & 1) == 1) return -1;// 奇数直接返回-1
        int bag8 = n / 8;// 装8个最多的袋子
        int bag6 = -1;// 装6个的袋子
        int rest = n - bag8 * 8;
        while (bag8 >=0 && rest < 24){// 24是最小公倍数。超过24试的结果就和之前的重复了
            bag8--;
            rest = n - bag8 * 8;
            bag6 = rest % 6 == 0 ? rest / 6 : -1;
        }
        return bag6 == -1 ? -1 : bag8 + bag6;
    }

    public static void main(String[] args) {
//        int minBags = minBags(32);
//        System.out.println(minBags);

        // 观察规律
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "/" + minBags(i));
        }
        /**
         * 输出结果:
         * 0/-1
         * 1/-1
         * 2/-1
         * 3/-1
         * 4/1
         * 5/-1
         * 6/-1
         * 7/-1
         * 8/-1
         * 9/-1
         * 10/2
         * 11/-1
         * 12/-1
         * 13/-1
         * 14/-1
         * 15/-1
         * 16/3
         * 17/-1
         * 18/-1
         * 19/-1
         * 20/-1
         * 21/-1
         * 22/4
         * 23/-1
         * 24/4
         * 25/-1
         * 26/-1
         * 27/-1
         * 28/-1
         * 29/-1
         * 30/5
         * 31/-1
         * 32/5
         * 33/-1
         * 34/-1
         * 35/-1
         * 36/-1
         * 37/-1
         * 38/6
         * 39/-1
         * 40/6
         * 41/-1
         * 42/-1
         * 43/-1
         * 44/-1
         * 45/-1
         * 46/7
         * 47/-1
         * 48/7
         * 49/-1
         * 50/-1
         * 51/-1
         * 52/-1
         * 53/-1
         * 54/8
         * 55/-1
         * 56/8
         * 57/-1
         * 58/-1
         * 59/-1
         * 60/-1
         * 61/-1
         * 62/9
         * 63/-1
         * 64/9
         * 65/-1
         * 66/-1
         * 67/-1
         * 68/-1
         * 69/-1
         * 70/10
         * 71/-1
         * 72/10
         * 73/-1
         * 74/-1
         * 75/-1
         * 76/-1
         * 77/-1
         * 78/11
         * 79/-1
         * 80/11
         * 81/-1
         * 82/-1
         * 83/-1
         * 84/-1
         * 85/-1
         * 86/12
         * 87/-1
         * 88/12
         * 89/-1
         * 90/-1
         * 91/-1
         * 92/-1
         * 93/-1
         * 94/13
         * 95/-1
         * 96/13
         * 97/-1
         * 98/-1
         * 99/-1
         */
    }
}
