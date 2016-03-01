package eu.cloudteams.controller;

import eu.cloudteams.authentication.jwt.UserAuthentication;
import eu.cloudteams.repository.service.UserService;
import java.util.logging.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Christos Paraskeva <ch.paraskeva at gmail dot com>
 */
@Controller
public class WebController {

    private static final Logger logger = Logger.getLogger(WebController.class.getName());

    @Autowired
    UserService userService;

    /*
     *  GET Methods 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    /*
     *  POST Methods 
     */

    /*
     *  Help Methods
     */
    /**
     * Retrieve the current logged-in user
     *
     * @return An instance of CurrentUser object
     */
    public static Authentication getCurrentUser() {
        return (Authentication) SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * Check if a user has a JWT AccessToken
     *
     * @return True if user has a JWT in headers, otherwise returns false
     */
    public static boolean hasAccessToken() {
        return SecurityContextHolder.getContext().getAuthentication() instanceof UserAuthentication;
    }
}
