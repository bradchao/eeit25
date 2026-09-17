package tw.brad.hibernate.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.hibernate.entity.Account;
import tw.brad.hibernate.util.HibernateUtil;

public class Brad10 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();

			String sql = """
					SELECT * FROM account
					""";
			NativeQuery<Account> query = session.createNativeQuery(sql, Account.class);
			List<Account> list = query.getResultList();
			System.out.println(list.size());
			for (Account account : list) {
				System.out.printf("%s:%s:%s:%s:%s\n", 
						account.getId(),
						account.getName(),
						account.getEmail(),
						account.getBirthday(),
						account.getEnable()
						);
			}
			
			transaction.commit();
		}
	}
}
