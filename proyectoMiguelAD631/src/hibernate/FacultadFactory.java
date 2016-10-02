/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
/**
 *
 * @author Migue
 */
public class FacultadFactory {
 
    private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory;
 
    static 
    {
        try 
        {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate/hibernate.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } 
        
        catch (Throwable ex) 
        {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
}