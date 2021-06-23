package com.zmn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * fileName: CommonResult
 *
 * @author: zhangmengnan
 * @create: 2021/6/9 23:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    //404 not_found
    /**
     * 序列化id
     */
    private static final long serialVersionUID = -6477868212171605239L;
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
