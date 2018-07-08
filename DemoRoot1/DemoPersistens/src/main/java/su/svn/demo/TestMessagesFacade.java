package su.svn.demo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class TestMessagesFacade {
    @PersistenceContext(unitName = "com.mycompany_MavenEnterpriseApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    public void create(TestMessages TestMessages) {
        em.persist(TestMessages);
    }

    public void edit(TestMessages TestMessages) {
        em.merge(TestMessages);
    }

    public void remove(TestMessages TestMessages) {
        em.remove(em.merge(TestMessages));
    }

    public TestMessages find(Object id) {
        return em.find(TestMessages.class, id);
    }

    public List<TestMessages> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TestMessages.class));
        return em.createQuery(cq).getResultList();
    }
}
