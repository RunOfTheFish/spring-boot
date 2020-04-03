package com.example.three.bean.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@TableName("impower")
@Data
public class Impower extends BaseEntity<Impower>{

    private static final long serialVersionUID = -2903038105463806799L;

    private String name;
    @TableField("product_type")
    private Integer productType;

    @TableField(exist = false)
    private String productName;

    @TableField("receive_info")
    private String receiveInfo;
    @TableField("physical_address")
    private String physicalAddress;
    @TableField("disk_address")
    private String diskAddress;
    @TableField("start_time")
    private Date startTime;

    @TableField(exist = false)
    private String startTimeStr;
    @TableField("end_time")
    private Date endTime;

    @TableField(exist = false)
    private String endTimeStr;

    @TableField("burn_num")
    private String burnNum;

    private Integer state;

    @TableField(exist = false)
    private String stateName;

    private String key;

    @TableField("public_key")
    private String publicKey;

    @TableField("private_key")
    private String privateKey;

    @TableField("send_info")
    private String sendInfo;

    @TableField("auth_info")
    private String authInfo;

}
