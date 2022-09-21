package login.testPage.springredisPrac.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import login.testPage.springredisPrac.model.User;
import login.testPage.springredisPrac.service.UserRedis;

@Controller
public class LoginPageController {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageController.class);

    @Autowired
    private UserRedis redisService;

    @GetMapping("/")
    public String getLogin(Model model) {
        return "index";
    }

    @PostMapping("/login")
    public String loginSuccess(@RequestParam(required=true) String username, Model model) {
        Optional<User> optUser = redisService.findByUsername(username);

        User currentUser = new User();
    
        //If user is empty, set a new user
        if (optUser.isEmpty()) {
            logger.info("new user being saved......");
            currentUser.setUsername(username);
            redisService.save(currentUser);
            model.addAttribute("currentUser", currentUser);
            logger.info("user saved successfully!!");
            
        } else { //if the user exists, get the currentUser
            currentUser = optUser.get();
            logger.info("user found! Logging into " + currentUser.getUsername());
            model.addAttribute("currentUser", currentUser);
        }

        logger.info("login first name >>>>> " + currentUser.getFirstName());
        return "userLogin";
    }
    
}
