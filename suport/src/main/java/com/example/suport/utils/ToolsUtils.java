package com.example.suport.utils;/*
 * @author p78o2
 * @date 2019/9/27
 */

import com.google.common.collect.Lists;

import java.util.List;

public class ToolsUtils<T> {
    //    切割list
    public List<List<T>> splitList(List<T> list, int groupSize) {
        return Lists.partition(list, groupSize); // 使用guava
    }
}
