package com.ourhome.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ourhome.home.entity.Home;

@Mapper
public interface HomeDao {

	/**
	 * 아이디를 이용해 하나의 집을 가져오는 메서드
	 * @param homeId 집 아이디
	 * @return
	 */
	@Select("SELECT * "
			+ "FROM home "
			+ "WHERE id=${homeId}")
	Home findOne(long homeId);

	/**
	 * 사용자 아이디를 이용해 사용자가 즐겨찾기한 집들을 가져오는 메서드
	 * @param userId 사용자 아이디
	 * @return
	 */
	@Select("SELECT h.id, h.address, h.type, h.jeonsae, h.monthly_deposit, h.monthly_pay, h.area, h.room_cnt, h.phone, h.registered_date "
			+ "FROM home h "
			+ "JOIN favorite_home fh "
			+ "ON h.id = fh.home_id "
			+ "WHERE fh.user_id = ${userId}")
	List<Home> findAllByUserId(long userId);
}
