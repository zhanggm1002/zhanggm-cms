package com.zhanggm.cms.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanggm.cms.pojo.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring-beans.xml")
public class RedisTests {
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		/** 保存对象 **/
		Article article = new Article();
		article.setId(1);
		redisTemplate.opsForValue().set("article", article);
		Object object = redisTemplate.opsForValue().get("article");
		System.out.println(object);
		/** 保存list **/
		List<Article> list = new ArrayList<>();
		list.add(article);
		list.add(article);
		redisTemplate.opsForValue().set("list", list);
		list = (List<Article>)redisTemplate.opsForValue().get("list");
		System.out.println(list);
		
	}
}
