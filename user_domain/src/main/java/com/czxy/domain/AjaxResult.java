package com.czxy.domain;
import	java.util.List;

import java.util.List;

public class AjaxResult {

    private String msg;
    private List list;
    private Object object;
    private Boolean flag;

    public AjaxResult() {
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "msg='" + msg + '\'' +
                ", list=" + list +
                ", object=" + object +
                ", flag=" + flag +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public AjaxResult(String msg, List list, Object object, Boolean flag) {
        this.msg = msg;
        this.list = list;
        this.object = object;
        this.flag = flag;
    }
}
