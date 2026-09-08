package tw.brad.tutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import tw.brad.api.JdbcTool;
import tw.brad.api.Member;
import tw.brad.api.RowMapper;

public class JDBC19 {
	public static void main(String[] args) {
		JdbcTool jdbc = new JdbcTool();
		
		String sql = """
				SELECT id, account, name
				FROM member
				""";
		
		List<Member> members = jdbc.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs) throws SQLException {
				return new Member(rs.getLong("id"), rs.getString("account"),null, rs.getString("name"));
			}
		});
		
		for (Member member : members) {
			System.out.printf("%d:%s:%s\n", member.getId(), member.getAccount(), member.getName());
		}
		
		
	}
}
