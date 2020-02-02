package com.zhanggm.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhanggm.cms.dao.CommentDao;
import com.zhanggm.cms.dao.UserDao;
import com.zhanggm.cms.pojo.Comment;
import com.zhanggm.cms.pojo.User;
import com.zhanggm.cms.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;

	@Override
	public boolean add(Comment comment) {
		comment.setCreated(new Date());
		return commentDao.insert(comment)>0;
	}

	@Override
	public PageInfo<Comment> getPageInfo(Integer articleId, Integer pageNo, Integer pageSize) {
		Comment comment = new Comment();
		comment.setArticleId(articleId);
		PageHelper.startPage(pageNo, pageSize);
		List<Comment> commentList = commentDao.select(comment);
		commentList.forEach(c->{
			User user = userDao.selectById(c.getUserId());
			c.setNickname(user.getNickname());
			c.setHeadimg(user.getHeadimg());
		});
		return new PageInfo<>(commentList);
	}

}
