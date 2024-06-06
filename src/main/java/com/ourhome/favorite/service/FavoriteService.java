package com.ourhome.favorite.service;

import java.util.List;

import com.ourhome.favorite.entity.CreateRequestDto;
import com.ourhome.home.entity.Home;

public interface FavoriteService {

    List<Home> getFavoriteList(Long userId);

    int addFavorite(CreateRequestDto createRequestDto);

    int removeFavorite(Long favoriteId);

}
