package egs.assignment.kourosh.service;

import egs.assignment.kourosh.entity.Users;
import egs.assignment.kourosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    public GroupUserDetailsService() {
    }

    public GroupUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<Users> user =  userRepository.findByUserName(userName);
       return user.map(GroupUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(userName +" does not exist"));
    }
}
