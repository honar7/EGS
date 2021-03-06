package egs.assignment.kourosh.controller;

import egs.assignment.kourosh.entity.Users;
import egs.assignment.kourosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasAutority('ROLE_ADMIN') or hasAutority('ROLE_MODERATOR')")
//    public String giveAccessToUser(@PathVariable long userId,@PathVariable String userRole){
//        Principal principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//       return service.giveAccessToUser(userId,userRole);
//    }

//    private Users getLoggedInUser(){
//        Principal principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return  service.getLoggedInUser(principal);
//    }

    @GetMapping("getAll")
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAutority('ROLE_ADMIN')")
    public List<Users> getUsers() {
        return service.getUsers();
    }

}
