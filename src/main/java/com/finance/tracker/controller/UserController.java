package com.finance.tracker.controller;

import com.finance.tracker.dto.UserDTO;
import com.finance.tracker.model.User;
import com.finance.tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    // Register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.registerUser(dto));
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email,
                                      @RequestParam String password) {
        return ResponseEntity.ok(userService.loginUser(email, password));
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}