package com.example.three.bean.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
  private boolean success;
  private String msg;
  private Object data;
}
