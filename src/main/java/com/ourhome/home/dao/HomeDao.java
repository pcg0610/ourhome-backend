package com.ourhome.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ourhome.home.dto.HomeCreateRequestDto;
import com.ourhome.home.entity.Home;
import com.ourhome.home.util.SearchCondition;

@Mapper
public interface HomeDao {

	/**
	 * 아이디를 이용해 하나의 집을 가져오는 메서드
	 * @param homeId 집 아이디
	 * @return
	 */
	@Select("SELECT * "
			+ "FROM home "
			+ "WHERE id=#{homeId}")
	Home selectHomeById(long homeId);

	@SelectProvider(type = HomeSqlProvider.class, method = "selectHomes")
	@Results(id = "homeResultMap", value = {
			@Result(property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "address", column = "address"),
			@Result(property = "buildYear", column = "build_year"),
			@Result(property = "type", column = "type"),
			@Result(property = "jeonsae", column = "jeonsae"),
			@Result(property = "monthlyDeposit", column = "monthly_deposit"),
			@Result(property = "monthlyPay", column = "monthly_pay"),
			@Result(property = "area", column = "area"),
			@Result(property = "phone", column = "phone"),
			@Result(property = "registeredDate", column = "registered_date")
	})
	List<Home> selectHomeBySearchCondition(SearchCondition searchCondition);

	@Select("SELECT COUNT(*) > 0 FROM home WHERE id = #{homeId}")
	boolean selectCountById(Long homeId);

	@Insert("INSERT INTO home (user_id, name, address, build_year, type, jeonsae, monthly_deposit, monthly_pay, area) VALUE ()")
    int insertHome(HomeCreateRequestDto createRequestDto);
}
