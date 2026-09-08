package tw.brad.api;

import java.util.List;

public class MyMemberDao implements MemberDao{

	private static final RowMapper<Member> MEMBER_MAPPER = rs -> new Member(
			rs.getLong("id"),
			rs.getString("account"),
			rs.getString("passwd"),
			rs.getString("name")
			);
	
	private static final String SQL_ADD = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE member SET passwd = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM member WHERE id = ?";
	private static final String SQL_QUERY_ID = "SELECT id, account, passwd, name FROM member WHERE id = ?";
	private static final String SQL_QUERY_ALL = "SELECT id, account, passwd, name FROM member";
	private static final String SQL_QUERY_ACCOUNT = "SELECT id, account, passwd, name FROM member WHERE account = ?";
	
	@Override
	public boolean addMember(Member member) throws Exception {
		if (findByAccount(member.getAccount()) != null) {return false;}
		
		String hashPasswd = BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt());
		
		return JdbcToolV2.update(SQL_ADD, member.getAccount(), hashPasswd, member.getName()) > 0;

	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		String hashPasswd = BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt());
		
		return JdbcToolV2.update(SQL_UPDATE, hashPasswd, member.getId()) > 0;
	}

	@Override
	public boolean delMember(Member member) throws Exception {
		return JdbcToolV2.update(SQL_DELETE, member.getId()) > 0;
	}

	@Override
	public Member findById(long id) throws Exception {
		List<Member> members = JdbcToolV2.query(SQL_QUERY_ID, MEMBER_MAPPER, id);
		if (members.size() > 0) {
			return members.get(0);
		}
		return null;
	}

	@Override
	public List<Member> findAll() throws Exception {
		return JdbcToolV2.query(SQL_QUERY_ALL, MEMBER_MAPPER);
	}

	@Override
	public Member login(String account, String passwd) throws Exception {
		Member member = findByAccount(account);
		if (member != null && BCrypt.checkpw(passwd, member.getPasswd())) {
			return member;
		}
		return null;
	}
	
	private Member findByAccount(String account) throws Exception {
		List<Member> members = JdbcToolV2.query(SQL_QUERY_ACCOUNT, MEMBER_MAPPER, account);
		if (members.size() > 0) {
			return members.get(0);
		}
		return null;
	}	

}
