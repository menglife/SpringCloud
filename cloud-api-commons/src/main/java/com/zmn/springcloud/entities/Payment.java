package com.zmn.springcloud.entities;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * fileName: Payment
 *
 * @author: zhangmengnan
 * @create: 2021/6/9 23:20
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {
    private Long id;
    private String serial;

}
