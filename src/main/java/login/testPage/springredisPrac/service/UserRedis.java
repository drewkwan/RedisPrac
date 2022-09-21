package login.testPage.springredisPrac.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import login.testPage.springredisPrac.model.User;

//Remember to annotate service
@Service
public class UserRedis implements UserRepo {

    @Autowired
    RedisTemplate<String, User> redisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserRedis.class);

    @Override
    public void save(User user) {
        
        logger.info("Saving: --------");
        redisTemplate.opsForValue().set(user.getUsername(),user);
        logger.info("saved successfully)");
        
    }

    @Override
    public Optional<User> findByUsername(String username) {
        logger.info("finding by username..." + username);
        try {
            //opsForValue().get(username) will return you user object
            User result = (User) redisTemplate.opsForValue().get(username);
            return Optional.of(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        logger.info("no user found!");
        return Optional.empty();
    }
    
}
