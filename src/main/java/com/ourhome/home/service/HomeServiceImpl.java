package com.ourhome.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ourhome.home.dao.HomeDao;
import com.ourhome.home.entity.Home;

@Service
public class HomeServiceImpl implements HomeService {
	
	private final HomeDao homeDao;
	
	HomeServiceImpl(HomeDao homeDao) {
		this.homeDao = homeDao;
	}

	@Override
	public Home getHome(long homeId) {
		return homeDao.findOne(homeId);
	}

	@Override
	public List<Home> getFavoritesList(long userId) {
		return homeDao.findAllByUserId(userId);
	}

}
