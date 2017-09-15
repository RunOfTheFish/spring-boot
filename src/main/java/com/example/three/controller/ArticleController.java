package com.example.three.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.three.bean.entity.Column;
import com.example.three.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 2017/9/11.
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {

	@Autowired
	private ColumnService columnService;

	@RequestMapping(value="", method = RequestMethod.GET)
	public String columnList(Page<Column> page, Model model) {

		model.addAttribute("page", columnService.selectColumnPage(page));
		return "/columnList";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String columnAdd() {
		return "/columnAdd";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveColumn(Column column) {
		columnService.saveColumn(column);
		return "redirect:/article";
	}
}
