package students.utils.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory()
	{
		try
		{
			Configuration configuration = new Configuration();
		    configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
			return new Configuration().configure().buildSessionFactory(serviceRegistry);
		}
		catch (Throwable ex)
		{
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		if (sessionFactory != null )
			return sessionFactory;
		sessionFactory = buildSessionFactory();
		return sessionFactory;
	}

	public static void shutdown()
	{
		getSessionFactory().close();
	}
}