package tw.brad.api;

public class Member {
	private long id;
	private String account, passwd, name;
	
	public Member(long id, String account, String passwd, String name) {
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
