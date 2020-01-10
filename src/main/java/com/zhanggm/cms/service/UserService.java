package com.zhanggm.cms.service;

import com.zhanggm.cms.pojo.User;

public interface UserService {
	/**
	 * @Title: register   
	 * @Description: 用户注册   
	 * @param: @param user
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean register(User user);
	
	/**
	 * @Title: getByUsername   
	 * @Description: 根据登录名查询用户   
	 * @param: @param userName
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	public User getByUsername(String userName);
	/**
	 * @Title: locked   
	 * @Description: 是否禁用   
	 * @param: @param userName
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean locked(String userName);
}
