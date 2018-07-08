package su.svn.WebApp003.models;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("userDAO")
public class UserDAO {

    @PersistenceContext(unitName = "jta")
    private EntityManager entityManager;

    // Добавляем User-а В базу данных
    // @Transactional
    public UserDataSet add(UserDataSet user) {
        return entityManager.merge(user);
    }

    // Получаем пользователя по id
    public UserDataSet get(long id) {
        return entityManager.find(UserDataSet.class, id);
    }

    // обновляем пользователя
    // если User которого мыпытаемся обновить нет,
    // то запишется он как новый
    public void update(UserDataSet user){
        add(user);
    }

    // удаляем User по id
    public void delete(long id) {
        entityManager.remove(get(id));
    }

    // Получаем все пользователей с БД
    public List<UserDataSet> getAll() {
        TypedQuery<UserDataSet> namedQuery = entityManager.createNamedQuery(
                "User.getAll", UserDataSet.class
        );
        return namedQuery.getResultList();
    }
}
