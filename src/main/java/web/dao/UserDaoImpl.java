package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import web.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }
}
