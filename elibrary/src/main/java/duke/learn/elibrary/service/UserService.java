/**
 * 
 */
package duke.learn.elibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import duke.learn.elibrary.data.UserRepository;
import duke.learn.elibrary.data.model.Person;
import duke.learn.elibrary.data.model.Role;
import duke.learn.elibrary.data.model.User;
import duke.learn.elibrary.view.model.Response;
import duke.learn.elibrary.view.model.Response.Status;
import duke.learn.elibrary.view.model.UserView;

/**
 * @author Kazi
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Response registerUser(UserView view) {
	String message = null;
	Status status = Status.FAILURE;
	if (view != null) {
	    String name = view.getName();
	    Integer age = view.getAge();
	    String number = view.getNumber();
	    String email = view.getEmail();
	    String username = view.getUsername();
	    String password = view.getPassword();
	    Role role = view.getRole();
	    Person person = new Person(null, name, age, number);
	    User user = new User(person, username, password, email, role);
	    userRepository.createUser(user);
	    message = "User Created Successfully";
	    status = Status.SUCCESS;

	} else {
	    message = "Insufficient Data";
	}

	return new Response(message, status);
    }
}
