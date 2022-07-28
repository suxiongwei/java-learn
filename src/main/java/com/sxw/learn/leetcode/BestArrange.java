package com.sxw.learn.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [题目描述]：一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你每一个项目开始的时间和结束的时间。你来安排宣讲的日程，要求会议室进行的宣讲的场次最多，返回最多的宣讲场次。
 */
public class BestArrange {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint){
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (Program program : programs) {
            if (program.start >= timePoint){
                result++;
                timePoint = program.end;
            }
        }
        return result;
    }
}
