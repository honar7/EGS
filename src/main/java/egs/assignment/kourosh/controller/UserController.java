package egs.assignment.kourosh.controller;

import egs.assignment.kourosh.common.UserConstant;
import egs.assignment.kourosh.entity.Users;
import egs.assignment.kourosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/join")
    private  String joinGroup(@RequestBody Users user) {
        user.setRoles(UserConstant.DEFAULT_ROLE);
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return  "Hello "+ user.getUserName();
    }
    @GetMapping("/access/{userId}/{userRole}")
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAutority('ROLE_ADMIN') or hasAutority('ROLE_MODERATOR')")
    public String giveAccessToUser(@PathVariable long userId,@PathVariable String userRole, Principal principal){
        Users user = userRepository.findById(userId).get();
        List<String> activeRoles = getRolesCurrentUser(principal);
        String newRoles = "";
        if(activeRoles.contains(userRole)){
            newRoles = user.getRoles() + "," + userRole;
            user.setRoles(newRoles);
        }
        userRepository.save(user);
        return  "Hello " + user.getUserName() + "New Roles assigned to you by " + principal.getName();
    }

    private Users getLoggedInUser(Principal principal){
        return  userRepository.findbyUserName(principal.getName()).get();
    }

    private List<String> getRolesCurrentUser(Principal principal){
        String roles = getLoggedInUser(principal).getRoles();
        List<String> assignedRoles = Arrays.stream( roles.split(",")).collect(Collectors.toList());
        if(assignedRoles.contains("ROLE_ADMIN")){
            return Arrays.stream(UserConstant.ADMIN_ACCESS).collect(Collectors.toList());
        }
        if(assignedRoles.contains("ROLE_MODERATOR")){
            return Arrays.stream(UserConstant.MODERATOR_ACCESS).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAutority('ROLE_ADMIN')")
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

}
