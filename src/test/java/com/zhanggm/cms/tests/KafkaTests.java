package com.zhanggm.cms.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/kafka-producer.xml")
public class KafkaTests {
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	@Test
	public void test() {
		kafkaTemplate.send("1710f", "这是来自spring的消息");
	}
	
	
}
