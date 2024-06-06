package com.ourhome.home.dao;

import org.apache.ibatis.jdbc.SQL;

import com.ourhome.home.util.BoundingBox;
import com.ourhome.home.util.SearchCondition;

public class HomeSqlProvider {

	public String selectHomes(SearchCondition searchCondition) {
		return new SQL() {{
			BoundingBox boundingBox = searchCondition.getBoundingBox();

			SELECT("*");
			FROM("home");
			
			if (searchCondition.getAddress() != null &&
					!searchCondition.getAddress().equals("")) {
				WHERE("address LIKE CONCAT('%', #{address}, '%')");
			}
			
			if (searchCondition.getName() != null && 
					!searchCondition.getName().equals("")) {
				WHERE("name LIKE CONCAT('%', #{name}, '%')");
			}
			
			if (boundingBox != null) {
				WHERE("lng > #{boundingBox.minLng} AND lng < #{boundingBox.maxLng} AND lat > #{boundingBox.minLat} ANd lat < #{boundingBox.maxLat}");
			}

			if (searchCondition.getLimit() > 0) {
				LIMIT(searchCondition.getLimit());
			}
		}}.toString();
	}
}
