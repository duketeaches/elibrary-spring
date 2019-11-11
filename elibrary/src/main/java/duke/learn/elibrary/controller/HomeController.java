/**
 * 
 */
package duke.learn.elibrary.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import duke.learn.elibrary.service.UserService;
import duke.learn.elibrary.utils.Constants;

/**
 * @author Kazi
 *
 */
@Controller
public class HomeController implements Constants {

    @Autowired
    private UserService userService;

    @GetMapping(path = { ENDPOINT_HEARTBEAT })
    public @ResponseBody Object heartbeat() {
	Map<String, Object> map = new HashMap<>();
	map.put("app", "eLibrary");
	map.put("status", "running");
	return map;
    }

    @GetMapping(path = { ENDPOINT_BASE, ENDPOINT_HOME })
    public String home() {
	return "home";
    }
}
