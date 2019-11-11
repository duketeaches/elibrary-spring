/**
 * 
 */
package duke.learn.elibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import duke.learn.elibrary.service.UserService;
import duke.learn.elibrary.utils.Constants;
import duke.learn.elibrary.view.model.UserView;

/**
 * @author Kazi
 *
 */
@Controller
public class UserController implements Constants {

    @Autowired
    private UserService userService;

    @PostMapping(path = ENDPOINT_REGISTER_USER, consumes = "application/x-www-form-urlencoded")
    public String registerUser(@ModelAttribute UserView userView) {
	userService.registerUser(userView);
	return "home";
    }
}
