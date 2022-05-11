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
 * 车位表
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("park_parking")
@ApiModel(value="Parking对象", description="车位表")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车位id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "车位名称")
    private String title;

    @ApiModelProperty(value = "车位价格")
    private Integer price;

    @ApiModelProperty(value = "是否使用 1（true）已使用，  0（false）未使用")
    private Boolean isUsed;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
