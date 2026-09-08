package tw.brad.api;

import java.util.List;

public interface MemberDao {
	boolean addMember(Member member) throws Exception;
	boolean updateMember(Member member) throws Exception;
	boolean delMember(Member member) throws Exception;
	Member findById(long id) throws Exception;
	List<Member> findAll() throws Exception;
	Member login(String account, String passwd) throws Exception;
}
