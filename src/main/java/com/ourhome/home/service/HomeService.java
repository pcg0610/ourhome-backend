package com.ourhome.home.service;

import java.util.List;

import com.ourhome.home.entity.Home;

public interface HomeService {

	Home getHome(long homeId);

	List<Home> getFavoritesList(long userId);
}
