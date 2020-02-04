package com.getanoutfit.salesAndInventory.Auth;

import com.getanoutfit.salesAndInventory.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    /*
    * Here I have used hard coded username and password.
    * we would use user service to load username and password from DB
    * */

//    Optional<User> user = repository.findByUserName(username);
//        if (user.isPresent()) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new MyUserPrincipal(user);
        return new User("arman", "123", new ArrayList<>());
    }
}
