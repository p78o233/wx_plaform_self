package com.example.suport.utils;/*
 * @author p78o2
 * @date 2019/9/23
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "分页返回类")
public class PageInfo<Object> {
    @ApiModelProperty(value = "总行数")
    private int count;
    @ApiModelProperty(value = "当前页码数据")
    private List<Object> list;

    public PageInfo() {
    }

    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public PageInfo(int count, List<Object> list) {

        this.count = count;
        this.list = list;
    }
}
