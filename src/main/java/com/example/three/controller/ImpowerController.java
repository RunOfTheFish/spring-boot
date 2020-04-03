package com.example.three.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.three.bean.entity.Impower;
import com.example.three.service.ImpowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("impower")
public class ImpowerController {

    @Resource
    private ImpowerService impowerService;

    /**
     * 列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Page<Impower> page, Model model) {
        model.addAttribute("page", impowerService.getPage(page));
        return "/impower/list";
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("productList", impowerService.getProductList());
        return "/impower/add";
    }

    /**
     * 用户保存
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Impower impower) {

        impowerService.save(impower);
        return "redirect:/impower/list";
    }

}
