package tw.brad.hibernate.tutor;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.hibernate.util.HibernateUtil;

public class Brad09 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();

			String sql = """
					INSERT INTO cust
						(cname, tel, birthday)
					VALUES
						(:cname, :tel, :birth)
					""";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("cname", "test1");
			query.setParameter("tel", "123");
			query.setParameter("birth", "1999-01-02");
			
			int n = query.executeUpdate();
			System.out.println(n);
			
			transaction.commit();
		}
	}
}
