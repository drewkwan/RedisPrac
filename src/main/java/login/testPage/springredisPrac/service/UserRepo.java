package login.testPage.springredisPrac.service;

import java.util.Optional;

import login.testPage.springredisPrac.model.User;

//Need to define this as an inter
public interface UserRepo {
    
    public void save(final User user);

    //The findByUsername() method is essentially like a "load" function
    public Optional<User> findByUsername(final String username);
}
