package nl.krisborg.imdbinfo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author Kris
 * @since 14-feb-2010
 */
public abstract class AbstractBaseDao {
    
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
