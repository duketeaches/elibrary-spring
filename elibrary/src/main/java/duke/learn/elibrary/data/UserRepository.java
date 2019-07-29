/**
 * 
 */
package duke.learn.elibrary.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import duke.learn.elibrary.data.model.User;

/**
 * @author Kazi
 *
 */
@Repository
public class UserRepository {

    @PersistenceContext(unitName = "entityManager")
    private EntityManager entityManager;

    public User createUser(User user) {
	if (user != null) {
	    if (user.getUserId() != null) {
		entityManager.merge(user);
	    } else {
		entityManager.persist(user);
	    }
	}
	return user;
    }

    public User getUserByUsername(Integer userId) {
	User user = null;
	try {
	    user = (User) entityManager.createQuery("select u from User u where u.userId = :userId")
		    .setParameter("userId", userId).getSingleResult();
	} catch (Exception e) {
	}
	return user;
    }

    public User getUserByUsername(String username) {
	User user = null;
	try {
	    user = (User) entityManager.createQuery("select u from User u where u.username = :username")
		    .setParameter("username", username).getSingleResult();
	} catch (Exception e) {
	}
	return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
	List<User> users = null;
	try {
	    users = (List<User>) entityManager.createQuery("select u from User u ").getResultList();
	} catch (Exception e) {
	}
	return users;
    }
}
