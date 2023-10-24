package com.example.pp_2_3_1_boot.Dao;

import com.example.pp_2_3_1_boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public void update(long id, User updateUser) {
        User userToBeUpdate = entityManager.find(User.class, id);

        userToBeUpdate.setFirstName(updateUser.getFirstName());
        userToBeUpdate.setLastName(updateUser.getLastName());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    public void delete(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
