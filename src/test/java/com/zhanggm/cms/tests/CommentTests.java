package com.zhanggm.cms.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.zhanggm.cms.pojo.Comment;
import com.zhanggm.cms.service.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring-beans.xml")
public class CommentTests {
	@Autowired
	private CommentService commentService;
	
	@Test
	public void add() {
		Comment comment = new Comment();
		comment.setArticleId(160);
		comment.setContent("评论测试");
		comment.setUserId(223);
		commentService.add(comment);
	}
	
	@Test
	public void getPageInfo() {
		PageInfo<Comment> pageInfo = commentService.getPageInfo(160, 1, 6);
		System.out.println(pageInfo.getList().get(0));
	}
}
