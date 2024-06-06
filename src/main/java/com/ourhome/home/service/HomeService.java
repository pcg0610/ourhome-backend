package com.ourhome.home.service;

import java.util.List;

import com.ourhome.home.dto.HomeCreateRequestDto;
import com.ourhome.home.entity.Home;
import com.ourhome.home.util.SearchCondition;

public interface HomeService {
	
	List<Home> getHomeList(SearchCondition searchCondition);

	Home getHome(Long homeId);

    boolean exists(Long homeId);

	int addHome(HomeCreateRequestDto createRequestDto);
}
