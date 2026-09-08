package tw.brad.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MemberDaoImpl implements MemberDao{
	// Application => 共用 Connection Pool
	private static HikariDataSource dataSource;
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/brad");
		config.setUsername("root");
		config.setPassword("root");
		
		// 優化
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(4);
		config.setConnectionTimeout(10*1000);
		
		dataSource = new HikariDataSource(config);
	}
	
	private static final RowMapper<Member> MEMBER_MAPPER = rs -> new Member(
			rs.getLong("id"),
			rs.getString("account"),
			rs.getString("passwd"),
			rs.getString("name")
			);
	
	private static final String SQL_ADD = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE member SET pssswd = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM member WHERE id = ?";
	private static final String SQL_QUERY_ID = "SELECT id, account, passwd, name FROM member WHERE id = ?";
	private static final String SQL_QUERY_ALL = "SELECT id, account, passwd, name FROM member";
	private static final String SQL_QUERY_ACCOUNT = "SELECT id, account, passwd, name FROM member WHERE account = ?";
	
	@Override
	public boolean addMember(Member member) throws Exception {
		if (findByAccount(member.getAccount()) != null) {return false;}
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_ADD)){
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
			return pstmt.executeUpdate() > 0;
		}
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE)){
			pstmt.setString(1, BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
			pstmt.setLong(2, member.getId());
			return pstmt.executeUpdate() > 0;
		}	
	}

	@Override
	public boolean delMember(Member member) throws Exception {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE)){
			pstmt.setLong(1, member.getId());
			return pstmt.executeUpdate() > 0;
		}	
	}

	@Override
	public Member findById(long id) throws Exception {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ID)){
			pstmt.setLong(1, id);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					Member member = MEMBER_MAPPER.mapRow(rs);
					return member;
				}
			}
			return null;
		}	
	}

	@Override
	public List<Member> findAll() throws Exception {
		List<Member> list = new ArrayList<Member>();
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ALL)){
			try(ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					Member member = MEMBER_MAPPER.mapRow(rs);
					list.add(member);
				}
			}
			return list;
		}		
	}

	private Member findByAccount(String account) throws Exception {
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_ACCOUNT)){
			pstmt.setString(1, account);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					Member member = MEMBER_MAPPER.mapRow(rs);
					return member;
				}
			}
			return null;
		}	
	}
	
	
	@Override
	public Member login(String account, String passwd) throws Exception {
		Member member = findByAccount(account);
		if (member != null && BCrypt.checkpw(passwd, member.getPasswd())) {
			return member;
		}
		return null;
	}

	
}
