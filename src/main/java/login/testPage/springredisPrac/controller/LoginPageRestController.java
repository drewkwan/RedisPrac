package login.testPage.springredisPrac.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import login.testPage.springredisPrac.model.User;
import login.testPage.springredisPrac.service.UserRedis;

@RestController
public class LoginPageRestController {

    @Autowired
    UserRedis redisService;

    private static final Logger logger = LoggerFactory.getLogger(LoginPageRestController.class);

    @GetMapping(path = "/{username}")
    public ResponseEntity<Optional<User>> getByUsername(@PathVariable String username) {
        Optional<User> optUser = redisService.findByUsername(username);
        logger.info("user loading......" + username);
        return ResponseEntity.ok(optUser);
    }
    
}
