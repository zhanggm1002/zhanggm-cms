package com.zhanggm.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhanggm.cms.dao.ArticleDao;
import com.zhanggm.cms.dao.CategoryDao;
import com.zhanggm.cms.dao.ChannelDao;
import com.zhanggm.cms.pojo.Article;
import com.zhanggm.cms.pojo.Category;
import com.zhanggm.cms.pojo.Channel;
import com.zhanggm.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Channel> getChannelAll() {
		return channelDao.select(null);
	}

	@Override
	public List<Category> getCateListByChannelId(Integer channelId) {
		Category category = new Category();
		category.setChannel_id(channelId);
		return categoryDao.select(category);
	}

	@Override
	public Article getById(Integer id) {
		return articleDao.selectById(id);
	}

	@Override
	public boolean save(Article article) {
		/** 设置默认值 **/
		article.setHits(0);
		article.setHot(0);
		article.setDeleted(0);
		article.setTousuCnt(0);
		article.setCommentCnt(0);
		if(article.getId()==null) {
			/** 新增 **/
			article.setCreated(new Date());
			article.setUpdated(new Date());
			articleDao.insert(article);
		}else {
			/** 修改 **/
			article.setUpdated(new Date());
			articleDao.update(article);
		}
		return true;
	}

	@Override
	public PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> articleList = articleDao.select(article);
		/** 设置频道和分类的名称 **/
		articleList.forEach(a->{
			Channel channel = channelDao.selectById(a.getChannel_id());
			a.setChannel_name(channel.getName());
			Category cate = categoryDao.selectById(a.getCategory_id());
			a.setCategory_name(cate.getName());
		});
		return new PageInfo<>(articleList);
	}

	@Override
	public boolean deleteById(Integer id) {
		Article article = articleDao.selectById(id);
		article.setDeleted(1);
		return articleDao.update(article)>0;
	}
	@Override
	public boolean deleteByIds(String ids) {
		String[] idArr = ids.split(",");
		for(String id:idArr) {
			deleteById(Integer.parseInt(id));
		}
		return true;
	}

}
