package com.ourhome.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ourhome.home.dao.HomeDao;
import com.ourhome.home.dto.HomeCreateRequestDto;
import com.ourhome.home.entity.Home;
import com.ourhome.home.util.SearchCondition;

@Service
public class HomeServiceImpl implements HomeService {
	
	private final HomeDao homeDao;
	
	HomeServiceImpl(HomeDao homeDao) {
		this.homeDao = homeDao;
	}

	@Override
	public Home getHome(Long homeId) {
		return homeDao.selectHomeById(homeId);
	}

	@Override
	public List<Home> getHomeList(SearchCondition searchCondition) {
		return homeDao.selectHomeBySearchCondition(searchCondition);
	}

	@Override
	public boolean exists(Long homeId) {
		return homeDao.selectCountById(homeId);
	}

	@Override
	public int addHome(HomeCreateRequestDto createRequestDto) {
		return homeDao.insertHome(createRequestDto);
	}

}
