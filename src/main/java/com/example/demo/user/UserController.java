package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
@CrossOrigin(origins = "https://frontspring.vercel.app")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "delete")
    public List<User> getUsersDelete(){
        return userService.getUsersDelete();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            User newUser = userService.newUser(user);
            return ResponseEntity.ok(newUser);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(path = "{userId}")
    public void supprimerUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @GetMapping(path="{userId}")
    public Optional<User> getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
        userService.updateUser(userId, user);
    }

    @PutMapping(path = "delete/{userId}")
    public void softDelete(@PathVariable("userId") Long userId){
        userService.softDelete(userId);
    }

    @PutMapping(path = "restore/{userId}")
    public void restoreUser(@PathVariable("userId") Long userId){
        userService.restoreUser(userId);
    }

    @GetMapping(path="montant")
    public List<Long> getMontant(){
        return userService.getMontant();
    }
}
