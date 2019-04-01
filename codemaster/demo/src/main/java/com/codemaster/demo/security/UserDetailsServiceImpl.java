package com.codemaster.demo.security;

import com.codemaster.demo.role.Role;
import com.codemaster.demo.user.ApplicationUser;
import com.codemaster.demo.user.UserRepository;
import com.codemaster.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


   /* @PostConstruct
    public void init() {
        Role role = new Role();
        role.setName("User");
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUserName("Juhan.Juurikas");
        applicationUser.setPassword("Juhan123");
        userService.save(applicationUser);
        ApplicationUser applicationUser1 = new ApplicationUser();
        applicationUser1.setUserName("Mare.Maasikas");
        applicationUser1.setPassword("Mare123");
        userService.save(applicationUser1);
        ApplicationUser applicationUser2 = new ApplicationUser();
        applicationUser2.setUserName("Kristel.Mere");
        applicationUser2.setPassword("Kristel123");
        userService.save(applicationUser2);
        // etc
    }*/

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findOneByUserName(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}
