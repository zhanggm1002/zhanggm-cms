package com.zhanggm.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhanggm.cms.pojo.Article;
import com.zhanggm.cms.pojo.Category;
import com.zhanggm.cms.pojo.Channel;

public interface ArticleService {
	/**
	 * @Title: getChannelAll   
	 * @Description: 查询所有频道   
	 * @param: @return      
	 * @return: List<Channel>      
	 * @throws
	 */
	List<Channel> getChannelAll();
	/**
	 * @Title: getCateListByChannelId   
	 * @Description: 根据频道Id查询分类列表   
	 * @param: @param channelId
	 * @param: @return      
	 * @return: List<Category>      
	 * @throws
	 */
	List<Category> getCateListByChannelId(Integer channelId);
	/**
	 * @Title: getById   
	 * @Description: 根据Id查询文章   
	 * @param: @param id
	 * @param: @return      
	 * @return: Article      
	 * @throws
	 */
	Article getById(Integer id);
	/**
	 * @Title: save   
	 * @Description: 保存文章   
	 * @param: @param article
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	boolean save(Article article);
	/**
	 * @Title: getPageInfo   
	 * @Description: 分页查询文章   
	 * @param: @param article
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return      
	 * @return: PageInfo<Article>      
	 * @throws
	 */
	PageInfo<Article> getPageInfo(Article article,Integer pageNum,Integer pageSize);
	/**
	 * @Title: deleteById   
	 * @Description: 根据Id删除文章  
	 * @param: @param id
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	boolean deleteById(Integer id);
	/**
	 * 
	 * @Title: deleteById   
	 * @Description: 根据Ids批量删除   
	 * @param: @param ids      
	 * @return: void      
	 * @throws
	 */
	boolean deleteByIds(String ids);
}
