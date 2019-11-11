/**
 * 
 */
package duke.learn.elibrary.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import duke.learn.elibrary.data.UserRepository;
import duke.learn.elibrary.data.model.Person;
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

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

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
	    Person person = new Person(null, name, age, number);
	    User user = new User(null, person, username, password, email, false);
	    userRepository.createUser(user);
	    message = "User Created Successfully";
	    status = Status.SUCCESS;
	} else {
	    message = "Insufficient Data";
	}

	return new Response(message, status);
    }

    public String login(UserView userView) {
	String username = userView.getUsername();
	String password = userView.getPassword();
	if (username != null && password != null) {
	    User user = userRepository.getUser(username);
	    if (user != null) {
		if (password.equals(user.getPassword())) {
		    // user id valid
		    HttpSession session = request.getSession();
		    session.setAttribute("user", userView);
		}
	    }
	}
	return "home";
    }
}
