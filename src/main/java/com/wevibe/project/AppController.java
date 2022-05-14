package com.wevibe.project;

import com.wevibe.project.users.User;
import com.wevibe.project.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("welcome")
    public String homePage() {
        return "Hi";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");

        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        System.out.println("Login failure handler....");

        return "login";
    }
////
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody User user) {
//        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDb.isEmpty() || wrongPassword(userFromDb, user)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        return ResponseEntity.ok().build();
//    }
//
//    private boolean wrongPassword(Optional<User> userFromDb, User user) {
//        return !userFromDb.get().getPassword().equals(user.getPassword());
//    }

//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<User> listUsers = userRepository.findAll();
//        model.addAttribute("listUsers", listUsers);
//
//        return "users";
//    }
}
