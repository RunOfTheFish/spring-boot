package com.example.three.task;

import com.example.three.bean.model.ArticleMagic;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;

/**
 * Created by admin on 2017/9/30.
 */
@Component
public class WebMagicTask {

	/*@Scheduled(cron = "0 0/1 * * * ?")
	public void statusCheck() {
		System.out.println("爬虫定时器开始");
		OOSpider.create(Site.me().setSleepTime(1000)
				, new ConsolePageModelPipeline(), ArticleMagic.class)
				.addUrl("http://www.oschina.net/question/tag/java").thread(5).run();
	}*/
}
