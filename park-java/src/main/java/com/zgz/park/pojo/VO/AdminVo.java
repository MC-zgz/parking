package com.zgz.park.pojo.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author willie
 * @date 2022/5/10
 */
@Data
public class AdminVo {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
}
