package com.example.three.bean.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * Created by admin on 2017/9/30.
 */
@TargetUrl("https://www.oschina.net/question/\\d+\\_\\d+")
public class ArticleMagic {

	@ExtractBy(value = "/html/body/section/main/article/header/header[1]/span/html()")
	private String title;

	@ExtractBy(value = "/html/body/section/main/article/header/section/main/header/section/html()")
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
