package com.ourhome.home.dao;

import org.apache.ibatis.jdbc.SQL;

import com.ourhome.home.entity.SearchCondition;

public class HomeSqlProvider {

	public String selectHomes(SearchCondition searchCondition) {
		return new SQL() {{
			SELECT("*");
			FROM("home");
			
			StringBuilder whereClause = new StringBuilder();
			
			if (searchCondition.getAddress() != null &&
					!searchCondition.getAddress().equals("")) {
				whereClause.append("address LIKE CONCAT('%', #{address}, '%') ").append(searchCondition.getMatchTypeName()).append(" ");
			}
			
			if (searchCondition.getName() != null && 
					!searchCondition.getName().equals("")) {
				whereClause.append("name LIKE CONCAT('%', #{name}, '%') ").append(searchCondition.getMatchTypeName()).append(" ");
			}
			
			if (whereClause.length() > 0) {
				int lastIndex = whereClause.lastIndexOf(searchCondition.getMatchTypeName());
                whereClause.setLength(lastIndex - 1);  // Remove the last conditionType and the space before it
                WHERE(whereClause.toString());
			}
		}}.toString();
	}
}
