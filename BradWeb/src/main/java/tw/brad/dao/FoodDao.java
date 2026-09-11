package tw.brad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tw.brad.api.Food;
import tw.brad.listener.InitListener;

public class FoodDao {
	private static final String SQL_QUERY_PAGE = """
			SELECT id, name, city, town, addr, tel, picurl
			FROM food
			ORDER BY id
			LIMIT ?, ?
			""";
	private static final String SQL_QUERY_ALL = """
			SELECT COUNT(id) count
			FROM food
			""";
	
	public List<Food> queryByPage(int page, int rpp) throws Exception {
		int spage = Math.max(1, page);
		int srpp = Math.max(1, rpp);
		int offset = (spage - 1) * srpp;
		
		List<Food> foods = new ArrayList<Food>();
		
		try (Connection conn = InitListener.getDataSource().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_PAGE);){
			
			pstmt.setInt(1, offset);
			pstmt.setInt(2, rpp);
			
			try(ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					Food food = new Food();
					food.setId(rs.getLong("id"));
					food.setName(rs.getString("name"));
					food.setTel(rs.getString("tel"));
					food.setCity(rs.getString("city"));
					food.setTown(rs.getString("town"));
					food.setAddr(rs.getString("addr"));
					food.setPicurl(rs.getString("picurl"));
					foods.add(food);
				}
			}
		}
		
		return foods;
	}
	
}
