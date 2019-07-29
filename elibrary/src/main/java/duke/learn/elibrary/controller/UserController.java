/**
 * 
 */
package duke.learn.elibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import duke.learn.elibrary.service.UserService;
import duke.learn.elibrary.utils.Constants;
import duke.learn.elibrary.view.model.Response;
import duke.learn.elibrary.view.model.UserView;

/**
 * @author Kazi
 *
 */
@RestController
public class UserController implements Constants {

    @Autowired
    private UserService userService;

    @PostMapping(path = ENDPOINT_REGISTER_USER)
    public Response registerUser(@RequestBody UserView userView) {
	return userService.registerUser(userView);
    }
}
