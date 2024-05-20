package com.ourhome.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ourhome.home.entity.ComboboxItemDto;
import com.ourhome.home.entity.Home;
import com.ourhome.home.entity.SearchCondition;

@Mapper
public interface HomeDao {

	/**
	 * 이름이 검색 내용을 포함하는 매물만 콤보박스 아이템의 형태로 조회하는 메서드
	 * @param content 포함해야 하는 내용
	 */
	@Select("SELECT name FROM home WHERE name LIKE CONCAT('%', #{content}, '%') LIMIT 5")
	List<ComboboxItemDto> findComboboxItemsByName(String content);
	
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
	
	@SelectProvider(type = HomeSqlProvider.class, method = "selectHomes")
	@Results(id = "homeResultMap", value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "type", column = "type"),
			@Result(property = "monthlyDeposit", column = "monthly_deposit"),
			@Result(property = "monthlyPay", column = "monthly_pay"),
			@Result(property = "area", column = "area"),
			@Result(property = "roomCnt", column = "room_cnt"),
			@Result(property = "phone", column = "phone"),
			@Result(property = "registeredDate", column = "registered_date")
	})
	List<Home> findAll(SearchCondition searchCondition);
}
