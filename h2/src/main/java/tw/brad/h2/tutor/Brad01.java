package tw.brad.h2.tutor;

import tw.brad.h2.dao.CustomerDao;
import tw.brad.h2.entity.Customer;

public class Brad01 {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		Customer c1 =  dao.getById("BOLID");
		System.out.println(c1.getCname()); 
	}

}
