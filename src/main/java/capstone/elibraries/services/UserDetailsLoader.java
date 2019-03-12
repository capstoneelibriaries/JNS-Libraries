package capstone.elibraries.services;

import capstone.elibraries.models.User;
import capstone.elibraries.models.UserWithRoles;
import capstone.elibraries.repositories.Users;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }
        return new UserWithRoles(user);
    }
}