package egs.assignment.kourosh.service;

import egs.assignment.kourosh.common.UserConstant;
import egs.assignment.kourosh.entity.Users;
import egs.assignment.kourosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {

    public UserService() {
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public  String joinGroup(@RequestBody Users user) {
        user.setRoles(UserConstant.DEFAULT_ROLE);
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return  "Hello "+ user.getUserName();
    }
//
//    public Users findById(long userId){
//        return  userRepository.findById(userId).get();
//    }
//
//    public List<Users> getUsers(){
//        return  userRepository.findAll();
//    }
//
//    public Users getLoggedInUser(Principal principal){
//        return  userRepository.findByUserName(principal.getName()).get();
//    }
//
//    public String giveAccessToUser(@PathVariable long userId, @PathVariable String userRole, Principal principal){
//        Users user = userRepository.findById(userId).get();
//        List<String> activeRoles = getRolesCurrentUser(principal);
//        String newRoles = "";
//        if(activeRoles.contains(userRole)){
//            newRoles = user.getRoles() + "," + userRole;
//            user.setRoles(newRoles);
//        }
//        userRepository.save(user);
//        return  "Hello " + user.getUserName() + "New Roles assigned to you by " + principal.getName();
//    }



}
