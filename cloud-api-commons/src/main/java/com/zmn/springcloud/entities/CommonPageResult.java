package com.zmn.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class CommonPageResult<T> implements Serializable {
    private static long serialVersionUID=-6477868212171605239L;
    //总记录
    private Long totals;
    //页数
    private Integer pageNumber;
    //每页记录数
    private Integer pageSize;
    //结果集
    private List<T> result;

    public CommonPageResult(List<T> result) {
        this.result = result;
    }

    public CommonPageResult(Long totals, Integer pageNumber, Integer pageSize) {
        this.totals = totals;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
