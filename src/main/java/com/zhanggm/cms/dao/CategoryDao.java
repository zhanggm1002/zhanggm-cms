package com.zhanggm.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zhanggm.cms.pojo.Category;

public interface CategoryDao extends BaseDao<Category>{
	@Select("SELECT id FROM cms_category where channel_id=#{channelId}")
	List<Integer> selectIdList(Integer channelId);
}
