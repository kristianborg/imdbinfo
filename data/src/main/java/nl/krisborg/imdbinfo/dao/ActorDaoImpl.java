package nl.krisborg.imdbinfo.dao;

import nl.krisborg.imdbinfo.dto.Actor;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Kris
 * @since 14-feb-2010
 */
@Transactional
public class ActorDaoImpl extends AbstractBaseDao implements ActorDao {

    public Number getNumActors(){
        return (Number) getSessionFactory().getCurrentSession().createCriteria(Actor.class)
                .setProjection(Projections.rowCount()).uniqueResult();

    }

    public void saveOrUpdate(Actor actor) {
        sessionFactory.getCurrentSession().saveOrUpdate(actor);
    }

    public Set<Actor> getActors() {
        Criteria criteria = getSessionFactory().getCurrentSession()
                .createCriteria(Actor.class);
        Set<Actor> result = new HashSet<Actor>(criteria.list());
        return result;
    }

    public Actor getActorByUrl(String url) {
        Criteria criteria = getSessionFactory().getCurrentSession()
                .createCriteria(Actor.class);
        criteria.add(Restrictions.eq("url", url));
        return (Actor)criteria.uniqueResult();
    }
}
