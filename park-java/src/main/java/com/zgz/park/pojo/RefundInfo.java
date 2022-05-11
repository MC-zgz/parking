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
 * 退款信息表
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("park_refund_info")
@ApiModel(value="RefundInfo对象", description="退款信息表")
public class RefundInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "退款单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商户订单编号")
    private String orderNo;

    @ApiModelProperty(value = "商户退款单编号")
    private String refundNo;

    @ApiModelProperty(value = "支付系统退款单号")
    private String refundId;

    @ApiModelProperty(value = "原订单金额")
    private Integer totalFee;

    @ApiModelProperty(value = "退款金额")
    private Integer refund;

    @ApiModelProperty(value = "退款原因")
    private String reason;

    @ApiModelProperty(value = "退款状态")
    private String refundStatus;

    @ApiModelProperty(value = "申请退款返回参数")
    private String contentReturn;

    @ApiModelProperty(value = "退款结果通知参数")
    private String contentNotify;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
