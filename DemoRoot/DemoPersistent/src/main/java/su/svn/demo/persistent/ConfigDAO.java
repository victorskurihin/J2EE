package su.svn.demo.persistent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ConfigDAO {
    private final static Logger LOG =  LogManager.getLogger(ConfigDAO.class);

    @PersistenceContext(unitName = "jta")
    private EntityManager entityManager;

    public ConfigDataSet add(ConfigDataSet config) {
        return entityManager.merge(config);
    }

    public ConfigDataSet get(long id) {
        return entityManager.find(ConfigDataSet.class, id);
    }

    public void update(ConfigDataSet config) {
        add(config);
    }

    public void delete(long id) {
        entityManager.remove(get(id));
    }

    public List<ConfigDataSet> getAll() {
        TypedQuery<ConfigDataSet> namedQuery = entityManager.createNamedQuery(
                "Config.getAll", ConfigDataSet.class
        );
        LOG.info("namedQuery {}", namedQuery.toString());
        return namedQuery.getResultList();
    }
}
