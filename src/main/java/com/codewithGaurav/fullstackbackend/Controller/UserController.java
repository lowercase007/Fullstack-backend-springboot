package com.codewithGaurav.fullstackbackend.Controller;

import com.codewithGaurav.fullstackbackend.Repository.UserRepository;
import com.codewithGaurav.fullstackbackend.exception.UserNotFoundException;
import com.codewithGaurav.fullstackbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {


@Autowired
private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

//    @GetMapping("/user/{email}")
//    public User getByEmail(@PathVariable String email){
//        return userRepository.getByEmail(email);
//    };
//
//    @GetMapping("/user/{name}")
//    public User findByname(@PathVariable String name){
//        return userRepository.findByname(name);
//    };

//    @GetMapping("/users")
//    Optional<User> findById(@RequestParam(required = false) String id, @RequestParam(required = false) String username){
//        if (!username.equals("")) {
//            // Response using a username
//        }
//        if (!id.email("")) {
//            // Response using an id
//        }
//        return null;
//    }
}



