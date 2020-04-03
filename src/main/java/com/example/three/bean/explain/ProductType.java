package com.example.three.bean.explain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum ProductType {

    BAIDU_FACE(1, "百度人脸识别服务"),
    TX_FINGER(2, "腾讯指纹服务"),
    ALI_CAR(3, "阿里自动驾驶服务");

    private int code;
    private String description;

    public static Optional<ProductType> byCode(int code) {
        return EnumSet.allOf(ProductType.class).stream().filter(in -> in.code == code).findFirst();
    }
}
