package com.example.api.entity.vo;/*
 * @author p78o2
 * @date 2019/9/26
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "用户管理获取用户列表")
public class UserGetVo {

    @ApiModelProperty(value = "公众号关注总人数")
    private int total;
    @ApiModelProperty(value = "本次拉取的人数，最大值10000")
    private int count;
    @ApiModelProperty(value = "本次返回的openid们")
    private List<String> openIds;
    @ApiModelProperty(value = "本次拉取的openid最后的一个值,如果人数大于10000，用于下次拉取的参数")
    private int nextOpenid;

    public UserGetVo() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

    public int getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(int nextOpenid) {
        this.nextOpenid = nextOpenid;
    }

    public UserGetVo(int total, int count, List<String> openIds, int nextOpenid) {
        this.total = total;
        this.count = count;
        this.openIds = openIds;
        this.nextOpenid = nextOpenid;
    }
}
