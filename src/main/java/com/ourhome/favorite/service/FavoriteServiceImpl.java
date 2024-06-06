package com.ourhome.favorite.service;

import java.util.List;

import com.ourhome.favorite.entity.CreateRequestDto;
import com.ourhome.home.entity.Home;
import com.ourhome.favorite.dao.FavoriteDao;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao;

    FavoriteServiceImpl(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public List<Home> getFavoriteList(Long userId) {
        return favoriteDao.selectFavoritesByUserId(userId);
    }

    @Override
    public int addFavorite(CreateRequestDto createRequestDto) {
        return favoriteDao.insertFavorite(createRequestDto);
    }

    @Override
    public int removeFavorite(Long favoriteId) {
        return favoriteDao.deleteFavorite(favoriteId);
    }    
}
