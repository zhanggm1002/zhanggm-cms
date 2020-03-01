package com.zhanggm.cms.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class RedisTests {
	@Autowired
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		redisTemplate.opsForValue().set("name", "cms");
	}
	
}
