package tw.brad.api;

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
	private static final String SQL_UPDATE = "";
	private static final String SQL_DELETE = "";
	private static final String SQL_QUERY_ID = "";
	private static final String SQL_QUERY_ALL = "";
	private static final String SQL_QUERY_ACCOUNT = "";
	
	
	@Override
	public boolean addMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member login(String account, String passwd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
