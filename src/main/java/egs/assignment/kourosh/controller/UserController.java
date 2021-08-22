package egs.assignment.kourosh.controller;

import egs.assignment.kourosh.common.UserConstant;
import egs.assignment.kourosh.entity.Users;
import egs.assignment.kourosh.repository.UserRepository;
import egs.assignment.kourosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
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
    UserService service;

    @PostMapping("/join")
    private  String joinGroup(@RequestBody Users user) {
        return  service.joinGroup(user);
    }



//    @GetMapping("/access/{userId}/{userRole}")
////    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasAutority('ROLE_ADMIN') or hasAutority('ROLE_MODERATOR')")
//    public String giveAccessToUser(@PathVariable long userId,@PathVariable String userRole, Principal principal){
//       return service.giveAccessToUser(userId,userRole,principal);
//    }
//
//    private Users getLoggedInUser(Principal principal){
//        return  service.getLoggedInUser(principal);
//    }
//
//    @GetMapping("getAll")
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasAutority('ROLE_ADMIN')")
//    public List<Users> getUsers() {
//        return service.getUsers();
//    }

}
