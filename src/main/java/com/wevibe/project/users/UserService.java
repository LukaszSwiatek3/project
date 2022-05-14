package com.wevibe.project.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/users")
    public ResponseEntity getUsers() throws JsonProcessingException {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(objectMapper.writeValueAsString(users));
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }


//    @Override
//    public void register(UserData user) throws UserAlreadyExistException {
//
//        //Let's check if user already registered with us
//        if(checkIfUserExist(user.getEmail())){
//            throw new UserAlreadyExistException("User already exists for this email");
//        }
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(user, userEntity);
//        encodePassword(userEntity, user);
//        userRepository.save(userEntity);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody User user) {
//        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDb.isEmpty() || wrongPassword(userFromDb, user)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        return ResponseEntity.ok().build();
//    }

//    private boolean wrongPassword(Optional<User> userFromDb, User user) {
//        return !userFromDb.get().getPassword().equals(user.getPassword());
//    }

}
