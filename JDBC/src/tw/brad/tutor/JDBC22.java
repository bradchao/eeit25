package tw.brad.tutor;

import java.util.List;

import tw.brad.api.Member;
import tw.brad.api.MemberDao;
import tw.brad.api.MemberDaoImpl;
import tw.brad.api.MyMemberDao;

public class JDBC22 {

	public static void main(String[] args) {
//		MemberDao dao = new MemberDaoImpl();
		MemberDao dao = new MyMemberDao();
		
		String account = "tony"; String passwd = "12345678"; String name = "湯尼";
		
		Member member = new Member();
		member.setAccount(account); member.setPasswd(passwd);member.setName(name);
		try {
			if (dao.addMember(member)) {
				System.out.println("add OK");
			}else {
				System.out.println("add xx");
			}
		}catch(Exception e) {e.printStackTrace();}
		//-------------------------------
		try {
			Member member1 = dao.findById(2);
			System.out.println(member1.getAccount());
			member1.setPasswd("12345678");
			if (dao.updateMember(member1)) {
				System.out.println("Passwd Update Success");
			}else {
				System.out.println("Passwd Update Failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-------------------------------
		try {
			Member member2 = dao.login("andy", "12345678");
			if (member2 != null) {
				System.out.printf("Welcome, %s(%d)\n", member2.getName(), member2.getId());
			}else {
				System.out.println("Login Failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-------------------------------
		try {
			List<Member> members = dao.findAll();
			for (Member m :members) {
				System.out.println(m.getAccount());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
