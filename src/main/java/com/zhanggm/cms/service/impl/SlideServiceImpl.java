package com.zhanggm.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanggm.cms.dao.SlideDao;
import com.zhanggm.cms.pojo.Slide;
import com.zhanggm.cms.service.SlideService;

@Service
public class SlideServiceImpl implements SlideService{
	@Autowired
	private SlideDao slideDao;
	@Override
	public List<Slide> getAll() {
		return slideDao.select(null);
	}

}
