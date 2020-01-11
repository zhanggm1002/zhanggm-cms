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
	/**
	 * @Title: set   
	 * @Description: 设置用户头像和昵称  
	 * @param: @param user
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean set(User user);
	/**
	 * @Title: getById   
	 * @Description: 根据Id查询用户  
	 * @param: @param id
	 * @param: @return      
	 * @return: User      
	 * @throws
	 */
	public User getById(Integer id);
}
