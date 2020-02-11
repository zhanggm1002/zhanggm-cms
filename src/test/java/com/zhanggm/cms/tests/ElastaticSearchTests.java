package com.zhanggm.cms.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhanggm.cms.elaticsearch.ArticleElastic;
import com.zhanggm.cms.elaticsearch.ArticleElasticsearchRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/elasticsearch.xml")
public class ElastaticSearchTests {
	@Autowired
	private ArticleElasticsearchRepository articleElasticsearchRepository;
	
	@Test
	public void test() {
		ArticleElastic ae = new ArticleElastic();
		ae.setId(1);
		ArticleElastic save = articleElasticsearchRepository.save(ae);
		System.out.println(save);
	}
}
