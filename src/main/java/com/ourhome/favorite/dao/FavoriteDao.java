package com.ourhome.favorite.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.ourhome.favorite.entity.CreateRequestDto;
import com.ourhome.home.entity.Home;

@Mapper
public interface FavoriteDao {

    @Select("SELECT h.* FROM favorite f JOIN home h ON f.homeId = h.id WHERE f.user_id = #{userId}")
    @ResultMap("homeResultMap")
    public List<Home> selectFavoritesByUserId(Long userId);

    @Insert("INSERT INTO favorite (user_id, home_id) VALUE (#{userId}, #{homeId})")
    public int insertFavorite(CreateRequestDto createRequestDto);

    @Delete("DELETE FROM favorite WHERE id = #{favoriteId}")
    public int deleteFavorite(Long favoriteId);
    
}
