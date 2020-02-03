package com.zhanggm.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zhanggm.cms.pojo.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * @Title: selectByUsername   
	 * @Description: 根据用户名查找用户   
	 * @param: @param userName
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	@Select("select * from cms_user where username=#{userName}")
	User selectByUsername(String userName);
	/**
	 * @Title: selectIdList   
	 * @Description: 查询头像和昵称不为空的用户Id   
	 * @param: @return      
	 * @return: List<Integer>      
	 * @throws
	 */
	@Select("SELECT id FROM cms_user WHERE headimg IS NOT NULL AND nickname IS NOT NULL")
	List<Integer> selectIdList();

}
