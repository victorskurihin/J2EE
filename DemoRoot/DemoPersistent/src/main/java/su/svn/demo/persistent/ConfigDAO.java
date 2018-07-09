package su.svn.demo.persistent;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
// @ApplicationScoped
public class ConfigDAO {
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
        return namedQuery.getResultList();
    }
}
