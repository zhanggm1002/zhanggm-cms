package com.zhanggm.cms.service;

import com.github.pagehelper.PageInfo;
import com.zhanggm.cms.pojo.Link;

public interface LinkService {
	/**
	 * @Title: save   
	 * @Description: 保存(添加　修改) 
	 * @param: @param link
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	boolean save(Link link);
	/**
	 * @Title: getPageInfo   
	 * @Description: 列表   
	 * @param: @param link
	 * @param: @param pageNum
	 * @param: @return      
	 * @return: PageInfo<Link>      
	 * @throws
	 */
	PageInfo<Link> getPageInfo(Link link,Integer pageNum);
	/**
	 * @Title: getById   
	 * @Description:　根据Id查询   
	 * @param: @param id
	 * @param: @return      
	 * @return: Link      
	 * @throws
	 */
	Link getById(Integer id);
}
