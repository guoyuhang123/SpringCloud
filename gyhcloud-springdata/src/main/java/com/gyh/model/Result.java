package com.gyh.model;

import java.util.List;

public class Result<T> {
    private Long count;
    private List<T> list;

    public Result(Long count, List<T> list) {
        this.count = count;
        this.list = list;
    }

    public Result() {
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
