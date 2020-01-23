package pl.com.britenet.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.com.britenet.lambda.entity.User;
import pl.com.britenet.lambda.repository.UserRepository;

import java.util.Optional;

@EnableWebMvc
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public @ResponseBody
    Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<String> addUser(@RequestParam String name, @RequestParam String email) {
        userRepository.save(new User(name, email));
        return new ResponseEntity<String>("saved", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<User> findById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestParam String name, @RequestParam String email) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            User userToUpdate = user.get();
            userToUpdate.setEmail(email);
            userToUpdate.setName(name);
            userRepository.save(userToUpdate);
            return new ResponseEntity<String>("updated", HttpStatus.OK);
        }
        return new ResponseEntity<String>("bad request", HttpStatus.BAD_REQUEST);
    }

}
