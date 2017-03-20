package in.gore;

import in.gore.entities.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Stateless
//@Local({ISimpleSession.class})
public class SimpleSessionBean implements ISimpleSession {

    @PersistenceContext(unitName = "myPersistenceUnit")
    EntityManager manager;

    private static Logger logger = Logger.getLogger(SimpleSessionBean.class.getName());
    private static AtomicLong counter = new AtomicLong();

    public SimpleSessionBean() {
        long ct = counter.incrementAndGet();
        logger.info("Bean Created: " + (new Long(ct)).toString());
    }

    public String getMessage() {
        logger.info("getMessage called");
        return "Random String";
    }

    @Override
    public long createUser() {
        User u = new User();
        u.setName("Mihir");
        manager.persist(u);
        return u.getId();
    }

    @Override
    public User getUser() {
        return manager.find(User.class, 0L);
    }
}