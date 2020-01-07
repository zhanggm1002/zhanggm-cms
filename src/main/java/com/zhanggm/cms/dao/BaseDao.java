package com.zhanggm.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhanggm.cms.pojo.User;

public interface BaseDao<T> {
	/**
	 * @Title: select   
	 * @Description: 按条件查询   
	 * @param: @param user
	 * @param: @return      
	 * @return: List<User>      
	 * @throws
	 */
	List<User> select(User user);
	/**
	 * @Title: selectById   
	 * @Description: 根据Id查询   
	 * @param: @param id
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	User selectById(Integer id);
	/**
	 * @Title: insert   
	 * @Description: 新增   
	 * @param: @param user
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	int insert(User user);
	/**
	 * @Title: update   
	 * @Description: 修改   
	 * @param: @param user
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	int update(User user);
	/**
	 * @Title: delete   
	 * @Description: 删除   
	 * @param: @param ids
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	int delete(@Param("ids") String ids);
}
