package com.example.three.controller;

import com.alibaba.fastjson.JSON;
import com.example.three.bean.model.Response;
import com.example.three.service.ImpowerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("api")
public class ApiController {

    @Resource
    private ImpowerService impowerService;

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    @ResponseBody
    public String auth(@RequestParam("data") String data) {
        Response response = impowerService.apiAuth(data);
        return JSON.toJSONString(response);
    }

}
