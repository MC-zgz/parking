package com.zgz.park.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户留言表
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("park_message")
@ApiModel(value="Message对象", description="用户留言表")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "留言id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "留言内容")
    private String content;

    @ApiModelProperty(value = "留言人")
    private String userName;

    @ApiModelProperty(value = "回复者")
    private String adminName;

    @ApiModelProperty(value = "回复内容")
    private String reply;

    @ApiModelProperty(value = "留言创建时间")
    private Date createTime;

    @ApiModelProperty(value = "留言回复时间")
    private Date updateTime;


}
