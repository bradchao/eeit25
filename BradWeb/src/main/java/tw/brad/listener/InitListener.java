package tw.brad.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("init");
		ServletContextListener.super.contextInitialized(sce);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("destroy");
		ServletContextListener.super.contextDestroyed(sce);
	}


}
