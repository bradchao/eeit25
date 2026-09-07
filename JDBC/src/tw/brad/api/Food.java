package tw.brad.api;

public class Food {
	private long id;
	private String name, city, town, addr, tel, feature;
	
	public Food(long id, String name, String city, String town, String addr, String tel, String feature) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.town = town;
		this.addr = addr;
		this.tel = tel;
		this.feature = feature;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	
	
}
