package com.example.three.bean.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductType implements Serializable {

    private static final long serialVersionUID = 6289882344566249536L;

    private Integer code;

    private String name;
}
