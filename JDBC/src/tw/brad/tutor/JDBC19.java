package tw.brad.tutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tw.brad.api.Food;
import tw.brad.api.JdbcTool;
import tw.brad.api.Member;
import tw.brad.api.RowMapper;

public class JDBC19 {
	public static void main(String[] args) {
		JdbcTool jdbc = new JdbcTool();
		
		String sql = """
				SELECT id, name, tel
				FROM food
				WHERE name LIKE ?
				""";
		
		List<Food> foods = jdbc.query(sql, new RowMapper<Food>() {
			@Override
			public Food mapRow(ResultSet rs) throws SQLException {
				Food food = new Food();
				food.setId(rs.getLong("id"));
				food.setName(rs.getString("name"));
				food.setTel(rs.getString("tel"));
				return food;
			}
		}, "%餐廳%");
		
		for (Food food : foods) {
			System.out.printf("%d:%s:%s\n", food.getId(), food.getName(), food.getTel());
		}
		
		
	}
}
