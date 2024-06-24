package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Login;
import com.example.demo.repo.LoginRepo;


@Controller
public class MyController {
	@Autowired
	LoginRepo repo;
	
    @GetMapping("/home")
    public String home() {
        // Add model attributes if needed
        return "index"; // This should resolve to /WEB-INF/jsp/index.jsp
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        List<Login> data = repo.findByUsername(username);

        if (data != null && !data.isEmpty()) {
            for (Login login : data) {
                if (login.getPassword().equals(password)) { // Use .equals() for String comparison
                    return "dashboard"; // Successful login
                }
            }
        }
        return null;
}
}
